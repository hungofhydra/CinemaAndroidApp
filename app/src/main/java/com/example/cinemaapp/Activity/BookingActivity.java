package com.example.cinemaapp.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.BookingData;
import com.example.cinemaapp.Models.Schedule;
import com.example.cinemaapp.Models.Seat;
import com.example.cinemaapp.Models.Showtime;
import com.example.cinemaapp.Models.TicketData;
import com.example.cinemaapp.Models.TicketResponse;
import com.example.cinemaapp.Models.TicketType;
import com.example.cinemaapp.Models.UpdateSeat;
import com.example.cinemaapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {
    ViewGroup layout;
    Spinner scheduleDropdown ;
    Spinner showtimeDropdown ;
    Spinner ticketTypeDropdown;
    Toolbar toolbarBooking;
    Button bookingButton;
    int ticketNumber = 0;
    String seatsLine = "AAAAAAAAAA/"
            + "AAAAAAAAAA/"
            + "AAAAAAAAAA/";
    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 100;
    int seatGaping = 10;
    int movieId;
    int roomId;
    String movieName;
    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";
    ArrayList<Seat> listSeat;
    TextView textViewTotal ;
    int userID;
    String token;
    int phimId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                movieId = Integer.parseInt(null);
                movieName = null;
            } else {
                movieId = extras.getInt("MOVIE_ID");
                movieName = extras.getString("MOVIE_NAME");
            }
        } else {
            movieId =  savedInstanceState.getInt("MOVIE_ID");
            movieName = savedInstanceState.getString("MOVIE_NAME");
        }
        layout = findViewById(R.id.layoutSeat);
        toolbarBooking = findViewById(R.id.toolbarBooking);
        toolbarBooking.setTitle(movieName);
        setSupportActionBar(toolbarBooking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(movieName);
        textViewTotal = findViewById(R.id.tv_Total);
        SharedPreferences sp = getApplication().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        userID = sp.getInt("userID", 0);
        token = sp.getString("Token", "");
        phimId = sp.getInt("maPhim", 0);
        textViewTotal.setText(Integer.toString(ticketNumber));
        bookingButton = findViewById(R.id.bookingButton);
        scheduleDropdown = findViewById(R.id.spinnerSchedule);
        showtimeDropdown = findViewById(R.id.spinnerShowtime);
        ticketTypeDropdown = findViewById(R.id.spinnerTicketType);

        Call<ArrayList<TicketType>> getTicketTypeCall = RetrofitClient.getTicketTypeApi().getTicketType();
        getTicketTypeCall.enqueue(new Callback<ArrayList<TicketType>>() {
            @Override
            public void onResponse(Call<ArrayList<TicketType>> call, Response<ArrayList<TicketType>> response) {
                ArrayList<TicketType> result = response.body();
                ArrayAdapter<TicketType> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, result);
                adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
                ticketTypeDropdown.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<TicketType>> call, Throwable t) {

            }
        });


        Call<ArrayList<Schedule>> getScheduleByMovieIdCall = RetrofitClient.getScheduleApi()
                .getCategoryByMovieIdSatus(movieId, "Chuẩn bị chiếu");
        getScheduleByMovieIdCall.enqueue(new Callback<ArrayList<Schedule>>() {
            @Override
            public void onResponse(Call<ArrayList<Schedule>> call, Response<ArrayList<Schedule>> response) {

                ArrayList<Schedule> result = response.body();
                ArrayAdapter<Schedule> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, result);
                adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
                scheduleDropdown.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Schedule>> call, Throwable t) {

            }
        });

        scheduleDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                layout.removeAllViews();
                ticketNumber = 0;
                textViewTotal.setText("0");
                Schedule test =  (Schedule) adapterView.getItemAtPosition(i);
                roomId = test.getMaPhong();
                Call<ArrayList<Seat>> getSeatCall = RetrofitClient.getSeatApi().getSeatByRoomId(roomId);

                getSeatCall.enqueue(new Callback<ArrayList<Seat>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Seat>> call, Response<ArrayList<Seat>> response) {
                        listSeat = response.body();
                        setSeat(listSeat);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Seat>> call, Throwable t) {

                    }
                });

                Call<ArrayList<Showtime>> getShowTimeCall = RetrofitClient.getShowtimeApi()
                        .getCategoryByMovieIdSatus(test.getId(),"active");
                getShowTimeCall.enqueue(new Callback<ArrayList<Showtime>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Showtime>> call, Response<ArrayList<Showtime>> response) {
                        ArrayList<Showtime> result = response.body();
                        ArrayAdapter<Showtime> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, result);
                        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
                        showtimeDropdown.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Showtime>> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ticketTypeDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TicketType ticketType = (TicketType ) ticketTypeDropdown.getSelectedItem();
                String price = ticketType.giaVe;
                int totalPrice = Integer.parseInt(price) * ticketNumber;
                textViewTotal.setText(Integer.toString(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIds.equals("")){
                    alertError("Pick at least 1 seat");
                }
                else alertBooking("Are you sure ?" );

            }
        });
    }

    public void setSeat(ArrayList<Seat> seats)
    {
        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layoutSeat.addView(layout);
        int count = 0;
        int test = 1;

        String chuCaiDau = seats.get(0).vitriDay;
        for (int index = 0; index < seats.size(); index++) {
            if (seats.get(index).vitriDay.contains(chuCaiDau)){
                if(seats.get(index).trangThai.equals("Đã đặt")) {
                    count++;
                    TextView view = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                    view.setLayoutParams(layoutParams);
                    view.setPadding(0, 0, 0, 2 * seatGaping);
                    view.setId(seats.get(index).id);
                    view.setGravity(Gravity.CENTER);
                    view.setBackgroundResource(R.drawable.ic_seats_booked);
                    view.setTextColor(Color.WHITE);
                    view.setTag(STATUS_BOOKED);
                    view.setText(seats.get(index).vitriDay + seats.get(index).vitriCot);
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                    layout.addView(view);
                    seatViewList.add(view);
                    view.setOnClickListener(this);
                }
                else if(seats.get(index).trangThai.equals("Còn trống")) {
                    count++;
                    TextView view = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                    view.setLayoutParams(layoutParams);
                    view.setPadding(0, 0, 0, 2 * seatGaping);
                    view.setId(seats.get(index).id);
                    view.setGravity(Gravity.CENTER);
                    view.setBackgroundResource(R.drawable.ic_seats_book);
                    view.setText(seats.get(index).vitriDay + seats.get(index).vitriCot);
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                    view.setTextColor(Color.BLACK);
                    view.setTag(STATUS_AVAILABLE);
                    layout.addView(view);
                    seatViewList.add(view);
                    view.setOnClickListener(this);
                }
            }
            else {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
                chuCaiDau = seats.get(index).vitriDay;
                index --;
            }
        }
    }


    @Override
    public void onClick(View view) {
        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
                ticketNumber --;
                TicketType ticketType = (TicketType ) ticketTypeDropdown.getSelectedItem();
                String price = ticketType.giaVe;
                int totalPrice = Integer.parseInt(price) * ticketNumber;
                textViewTotal.setText(Integer.toString(totalPrice) + " vnđ");
                //Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);
                Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
                ticketNumber ++;
                TicketType ticketType = (TicketType ) ticketTypeDropdown.getSelectedItem();
                String price = ticketType.giaVe;
                int totalPrice = Integer.parseInt(price) * ticketNumber;
                textViewTotal.setText(Integer.toString(totalPrice) + " vnđ");
            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
        }
    }

    public List<String> changeStatusforSeatfromUnbooktoBooked(){
        String seletecSeat =  selectedIds.substring(0,selectedIds.length()-1);
        UpdateSeat updateSeat = new UpdateSeat("Đã đặt");
        List<String> idList = Arrays.asList(seletecSeat.split(","));
        for (String id : idList) {
            Call<Void> call = RetrofitClient.getSeatApi().changeStatus(Integer.parseInt(id), updateSeat);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        return idList;
    }

    private void alertBooking(String message){
        AlertDialog dlg = new AlertDialog.Builder(BookingActivity.this)
                .setTitle("Confirm")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        List<String> idList = changeStatusforSeatfromUnbooktoBooked();
//                        for (String id : idList) {
//                            Log.e("Seat id", id);
//                        }
                        String seletecSeat =  selectedIds.substring(0,selectedIds.length()-1);
                        List<String> idList = Arrays.asList(seletecSeat.split(","));
                        Showtime showtime = (Showtime) showtimeDropdown.getSelectedItem();
                        int maSuatChieu = showtime.getId();
                        TicketType ticketType = (TicketType) ticketTypeDropdown.getSelectedItem();
                        int maLoaiVe = ticketType.id;
                        int maPhong = roomId;
                        int maPhim = phimId;

                        Date ngayMua = new Date();

                        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


                        for ( String id : idList) {
                            int maGhe = Integer.parseInt(id);
                            TicketData ticketData = new TicketData(maSuatChieu, maLoaiVe, maPhong, maPhim, maGhe, ngayMua);
                            Call<TicketResponse> call = RetrofitClient.getTicketApi().createTicket(ticketData);
                            call.enqueue(new Callback<TicketResponse>() {
                                @Override
                                public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                                    TicketResponse ticketResponse= response.body();
                                    Call<Void> call2 = RetrofitClient.getTicketApi().createBooking("Bearer " + token , new BookingData(userID, ticketResponse.ticket.id));
                                    call2.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {

                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {

                                        }
                                    });
                                }

                                @Override
                                public void onFailure(Call<TicketResponse> call, Throwable t) {

                                }
                            });
                        }

                    }
                })
                .create();
        dlg.show();
    }

    private void alertError(String message){
        AlertDialog dlg = new AlertDialog.Builder(BookingActivity.this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dlg.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}