package com.example.cinemaapp.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.Users;
import com.example.cinemaapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    String token;
    EditText edtFullName, edtSex, edtUserName, edtPhone, edtStatus;
    Users userInfo;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtFullName = findViewById(R.id.et_full_name);
        edtSex = findViewById(R.id.et_sex);
        edtUserName = findViewById(R.id.et_username);
        edtPhone = findViewById(R.id.et_contact_no);
        edtStatus = findViewById(R.id.et_status);

        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                token= null;
            } else {
                token= extras.getString("TOKEN");
            }
        } else {
            token= (String) savedInstanceState.getSerializable("TOKEN");
        }

        Call<Users> myInfoCall = RetrofitClient.getUserApi().getMyInfo( "Bearer " + token);
        myInfoCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                userInfo = response.body();
                edtFullName.setText(userInfo.getKhachHang().getTenKH().toString());
                edtSex.setText(userInfo.getKhachHang().getGioiTinh());
                edtUserName.setText(userInfo.getUsername());
                edtPhone.setText(userInfo.getKhachHang().getSDT());
                edtStatus.setText(userInfo.getTrangThai());
                Toast.makeText(UserActivity.this, "Call API SUCCESS", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(UserActivity.this, "Call API FAIL", Toast.LENGTH_SHORT).show();
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