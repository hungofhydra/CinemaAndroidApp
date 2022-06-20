package com.example.cinemaapp.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.ChangePasswordData;
import com.example.cinemaapp.Models.Message;
import com.example.cinemaapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    Button buttonChangePassword;
    String token;
    int userID;
    EditText oldPassET, newPassET, newPass2ET;
    String oldPass, newPass, newPass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldPassET = findViewById(R.id.et_old_password);
        newPassET = findViewById(R.id.et_new_password);
        newPass2ET = findViewById(R.id.et_new_password2);



        buttonChangePassword = findViewById(R.id.btn_confirm_changePassword);

        toolbar = findViewById(R.id.toolbarChangePassword);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        SharedPreferences sp = getApplication().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        token = sp.getString("Token", "");
        userID = sp.getInt("userID", 0);

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPass = oldPassET.getText().toString();
                newPass = newPassET.getText().toString();
                newPass2 = newPass2ET.getText().toString();

                if (oldPass.isEmpty() || newPass.isEmpty() || newPass2.isEmpty()) {
                    alertError("Please input all the data required");
                }
                else{
                    if (newPass.length()<8) alertError("New password length must be over or equal to 8 character");
                    else if (!newPass.equals(newPass2) ) alertError("Password and re-enter password are not the same");
                    else {
                        alertConfirm("Are you sure");
                    }
                }

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

    private void alertError(String message){
        AlertDialog dlg = new AlertDialog.Builder(ChangePasswordActivity.this)
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

    private void changePassword(){
        Call<Message> call = RetrofitClient.getUserApi().changePassword("Bearer " + token, new ChangePasswordData(oldPass, newPass, userID));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.body() != null) {
                    alertSuccess();
                }
                else alertError("Wrong current password ");

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }

    private void alertConfirm(String message){
        AlertDialog dlg = new AlertDialog.Builder(ChangePasswordActivity.this)
                .setTitle("Confirm")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        changePassword();
                    }
                })
                .create();
        dlg.show();
    }

    private void alertSuccess(){
        AlertDialog dlg = new AlertDialog.Builder(ChangePasswordActivity.this)
                .setTitle("Success")
                .setMessage("Change Password Success")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
        dlg.show();
    }
}