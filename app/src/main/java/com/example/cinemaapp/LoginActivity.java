package com.example.cinemaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.API.UserApi;
import com.example.cinemaapp.Models.LoginData;
import com.example.cinemaapp.Models.LoginResponse;
import com.example.cinemaapp.Models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;
    LoginResponse result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btl_login);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()){
                    alert("Please input all the data required");
                }
                else {
                    clickLogin();
                }

            }
        });
    }

    private void clickLogin(){
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();


            Call<LoginResponse> loginResponseCall = RetrofitClient.getUserApi().signIn(new LoginData(username, password));
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    //Toast.makeText(LoginActivity.this, "Call API SUCCESS", Toast.LENGTH_SHORT).show();
                    result = response.body();
                    if (result == null) alert("Wrong username or password");
                    else {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("LOGIN_RESPONSE", result);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Call API FAIL", Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void alert(String message){
        AlertDialog dlg = new AlertDialog.Builder(LoginActivity.this)
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


}