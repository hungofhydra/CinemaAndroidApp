package com.example.cinemaapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.Schedule;
import com.example.cinemaapp.Models.Seat;
import com.example.cinemaapp.Models.Showtime;
import com.example.cinemaapp.Models.TicketType;
import com.example.cinemaapp.R;

import java.util.ArrayList;
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
                Schedule test =  (Schedule) adapterView.getItemAtPosition(i);
                roomId = test.getMaPhong();
                Call<ArrayList<Seat>> getSeatCall = RetrofitClient.getSeatApi().getSeatByRoomId(roomId);

                getSeatCall.enqueue(new Callback<ArrayList<Seat>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Seat>> call, Response<ArrayList<Seat>> response) {
                        listSeat = response.body();
                        //seatsLine = setSeat(listSeat);
                        //drawSeat(seatsLine);
                        setSeat2(listSeat);
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

        //drawSeat(seats);
    }

    public String setSeat(ArrayList<Seat> seats){
        String chuCaiDau = seats.get(0).vitriDay;
        String chuoiSeat = "";

        for (int index = 0; index < seats.size(); index++) {
            if (seats.get(index).vitriDay.contains(chuCaiDau)){
                if(seats.get(index).trangThai.equals("Đã đặt")) {
                    chuoiSeat += "U";
                }
                else if(seats.get(index).trangThai.equals("Còn trống")) {
                   chuoiSeat += "A";
                }
            }
            else {
                chuoiSeat += "/";
                chuCaiDau = seats.get(index).vitriDay;
                index --;
            }
        }
        return chuoiSeat;
    }

    public void setSeat2(ArrayList<Seat> seats)
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
            Log.e("chuoi seat", seats.get(index).toString());
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

//    public void drawSeat(String seats){
//        layout = findViewById(R.id.layoutSeat);
//        seats = "/" + seats;
//
//        LinearLayout layoutSeat = new LinearLayout(this);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutSeat.setOrientation(LinearLayout.VERTICAL);
//        layoutSeat.setLayoutParams(params);
//        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
//        layout.addView(layoutSeat);
//
//        LinearLayout layout = null;
//
//        int count = 0;
//        int test = 1;
//
//        for (int index = 0; index < seats.length(); index++) {
//            if (seats.charAt(index) == '/') {
//                layout = new LinearLayout(this);
//                layout.setOrientation(LinearLayout.HORIZONTAL);
//                layoutSeat.addView(layout);
//            } else if (seats.charAt(index) == 'U') {
//                count++;
//                TextView view = new TextView(this);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
//                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
//                view.setId(test);
//                view.setGravity(Gravity.CENTER);
//                view.setBackgroundResource(R.drawable.ic_seats_booked);
//                view.setTextColor(Color.WHITE);
//                view.setTag(STATUS_BOOKED);
//                view.setText(count + "");
//                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
//                layout.addView(view);
//                seatViewList.add(view);
//                view.setOnClickListener(this);
//            } else if (seats.charAt(index) == 'A') {
//                count++;
//                TextView view = new TextView(this);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
//                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
//                view.setId(test);
//                view.setGravity(Gravity.CENTER);
//                view.setBackgroundResource(R.drawable.ic_seats_book);
//                view.setText(count + "");
//                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
//                view.setTextColor(Color.BLACK);
//                view.setTag(STATUS_AVAILABLE);
//                layout.addView(view);
//                seatViewList.add(view);
//                view.setOnClickListener(this);
//            } else if (seats.charAt(index) == 'R') {
//                count++;
//                TextView view = new TextView(this);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
//                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
//                view.setId(count);
//                view.setGravity(Gravity.CENTER);
//                view.setBackgroundResource(R.drawable.ic_seats_reserved);
//                view.setText(count + "");
//                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
//                view.setTextColor(Color.WHITE);
//                view.setTag(STATUS_RESERVED);
//                layout.addView(view);
//                seatViewList.add(view);
//                view.setOnClickListener(this);
//            } else if (seats.charAt(index) == '_') {
//                TextView view = new TextView(this);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
//                view.setLayoutParams(layoutParams);
//                view.setBackgroundColor(Color.TRANSPARENT);
//                view.setText("");
//                layout.addView(view);
//            }
//        }
//
//    }

    @Override
    public void onClick(View view) {
        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
                 Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);
                Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
        }
    }
}