package com.example.cinemaapp.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.TicketOfUser.TicketDetail;
import com.example.cinemaapp.R;
import com.example.cinemaapp.Adapter.TicketAdapter;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketHistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int userID;
    List<TicketDetail> ticketDetailsList;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_history);
        toolbar = findViewById(R.id.toolbarTicketHistory);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewTicketHistory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(TicketHistoryActivity.this));

        SharedPreferences sp = getApplication().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        userID = sp.getInt("userID", 0);

        Call<List<TicketDetail>> call = RetrofitClient.getTicketApi().getBookedTicketByUserId(userID);
        call.enqueue(new Callback<List<TicketDetail>>() {
            @Override
            public void onResponse(Call<List<TicketDetail>> call, Response<List<TicketDetail>> response) {
                ticketDetailsList = response.body();
                Collections.sort(ticketDetailsList);
                TicketAdapter ticketAdapter = new TicketAdapter(TicketHistoryActivity.this, ticketDetailsList);
                recyclerView.setAdapter(ticketAdapter);
            }

            @Override
            public void onFailure(Call<List<TicketDetail>> call, Throwable t) {

            }
        });
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