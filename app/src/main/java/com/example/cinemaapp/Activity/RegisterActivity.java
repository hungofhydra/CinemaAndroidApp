package com.example.cinemaapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.RegisterData;
import com.example.cinemaapp.Models.RegisterResponse;
import com.example.cinemaapp.R;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtPassword2;
    androidx.appcompat.widget.Toolbar toolbar;
    private EditText edtPhoneNumber;
    private EditText edtCMND;
    private Button btnConfirmRegister;
    private RadioButton r_male, r_female;
    private String sex;
    private RegisterData registerData;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.et_name);
        edtUsername = findViewById(R.id.et_reg_username);
        edtPassword = findViewById(R.id.et_reg_password);
        edtPassword2 = findViewById(R.id.et_reg_password2);
        edtPhoneNumber = findViewById(R.id.et_reg_sdt);
        edtCMND = findViewById(R.id.et_reg_cmnd);
        btnConfirmRegister = findViewById(R.id.btn_confirm_register);
        r_male = findViewById(R.id.radio_male);
        r_female = findViewById(R.id.radio_female);
        toolbar = findViewById(R.id.toolbarRegister);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        btnConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                register();

            }
        });



    }

    private void register(){
        String name = edtName.getText().toString();
        String userName = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String password2 = edtPassword2.getText().toString();

        String phoneNumber = edtPhoneNumber.getText().toString();
        String cmnd = edtCMND.getText().toString();
        if (r_male.isChecked()) sex = "Nam";
        else sex = "Nữ";

        if (name.isEmpty() || userName.isEmpty() || password.isEmpty() || password2.isEmpty() || phoneNumber.isEmpty() || cmnd.isEmpty() || sex.isEmpty()) {
            alert("Error","Please input all the data required");
        }
        else {
            if (password.length()<8) alert("Error","Password length must be over or equal to 8 character");
            else if (!password.equals(password2) ) alert("Error","Password and re-enter password are not the same");
            else if (phoneNumber.length()!= 10) alert("Error","Wrong phone number format");
            else {
                registerData = new RegisterData(name,sex,cmnd,phoneNumber,userName,password);
                Call<RegisterResponse> registerCall = RetrofitClient.getUserApi().signUp(registerData);
                registerCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.body() == null) alertError("Error", "Username or CMND already exist");
                        else {
                            RegisterResponse result = response.body();
                            if (result == null) message = null;
                            else message = result.getMessage();
                            Log.e("message", message);
                            Check(message);
                        }

                        //if(result.getMessage().equals("Username is exist")) alert("Username is already used");


                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                        Toast.makeText(RegisterActivity.this, "Call API FAIL", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }


    private void Check(String message){
        switch (message){
            case "NULL" :
                alert("Username or CMND is already used");
                break;
            case "Create User success":
                alert("Success","Create User success");
                break;
            default:
                break;
        }
    }
    private boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }


    private void alert(String title, String message){
        AlertDialog dlg = new AlertDialog.Builder(RegisterActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
        dlg.show();
    }

    private void alertError(String title, String message){
        AlertDialog dlg = new AlertDialog.Builder(RegisterActivity.this)
                .setTitle(title)
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

    private void alert( String message){
        AlertDialog dlg = new AlertDialog.Builder(RegisterActivity.this)
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