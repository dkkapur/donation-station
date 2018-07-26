package com.donationstation.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.donationstation.android.databinding.ActivityRegistrationBinding;
import com.donationstation.android.models.User;
import com.donationstation.android.network.RetrofitClient;
import com.donationstation.android.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));

        if (SharedPreferencesUtils.getInstance().isUserRegistered()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        binding.btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = binding.txeEmail.getText().toString();
        String name = binding.txeName.getText().toString();
        String zipCode = binding.txeZip.getText().toString();
        String location = binding.txeLocation.getText().toString();

        List<String> items = new ArrayList<>();

        if (binding.checkbox1.isChecked()) items.add(binding.checkbox1.getText().toString());
        if (binding.checkbox2.isChecked()) items.add(binding.checkbox2.getText().toString());
        if (binding.checkbox3.isChecked()) items.add(binding.checkbox3.getText().toString());
        if (binding.checkbox4.isChecked()) items.add(binding.checkbox4.getText().toString());

        User registration = new User(email, name,location, zipCode, items);

        sendToServer(registration);
    }

    private void sendToServer(final User user) {
        RetrofitClient.getInstance(getApplicationContext()).getDonationStationService()
                .sendUserRegistration(user)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                        if (response.isSuccessful()) {
                            SharedPreferencesUtils.getInstance().setIsUserRegistered(true);
                            SharedPreferencesUtils.getInstance().setUserId(user.getUser_id());
                            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            finish();
                        }else{
                            showDialog();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                        Log.e("Error", t.getMessage());
                        showDialog();
                    }
                });
    }

    private void showDialog(){
        new AlertDialog.Builder(RegistrationActivity.this)
                .setTitle("Error")
                .setMessage("Error while doing registration")
                .setPositiveButton("Ok", null)
                .create()
                .show();
    }
}
