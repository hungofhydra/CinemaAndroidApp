package com.example.cinemaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.Models.TicketOfUser.TicketDetail;
import com.example.cinemaapp.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private List<TicketDetail> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public TicketAdapter(Context context, List<TicketDetail> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.ticket_item_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TicketDetail ticketDetail = mData.get(position);
        String movieName = ticketDetail.ve.phim.tenPhim;
        String room = ticketDetail.ve.phongChieu.tenPhong;
        String chair = ticketDetail.ve.ghe.vitriDay + ticketDetail.ve.ghe.vitriCot ;

        Date date = ticketDetail.ve.suatChieu.timeStart;
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateFormatted = dt.format(date);
        //Log.e("Date", dateFormatted);
        String urlImage = ticketDetail.ve.phim.poster;
        setInfo(holder,  movieName,  room,  chair,  dateFormatted,  urlImage);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView textViewMovieName;
        TextView textViewRoom;
        TextView textViewChair;
        TextView textViewDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview_movie_ticket);
            textViewMovieName = itemView.findViewById(R.id.textNameMovie_ticket);
            textViewRoom = itemView.findViewById(R.id.textPhongChieu);
            textViewChair = itemView.findViewById(R.id.textGheChieu);
            textViewDate = itemView.findViewById(R.id.textNgayChieu);
        }

    }

    public void setInfo(TicketAdapter.ViewHolder holder, String movieName, String room, String chair, String dateFormatted, String urlImage){

        holder.textViewMovieName.setText(movieName);
        holder.textViewRoom.setText("Phòng chiếu: " + room);
        holder.textViewChair.setText("Ghế ngồi: " + chair);
        holder.textViewDate.setText("Ngày chiếu: " + dateFormatted);
        Picasso.get().load(urlImage).into(holder.movieImage);
    }

}

