package com.donationstation.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.donationstation.android.databinding.ActivityRegistrationBinding;
import com.donationstation.android.models.User;
import com.donationstation.android.network.RetrofitClient;
import com.donationstation.android.utils.SharedPreferencesUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = RegistrationActivity.class.getSimpleName();
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));

        /*if (SharedPreferencesUtils.getInstance().isUserRegistered()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }*/

        binding.btnRegister.setOnClickListener(this);

        binding.txeLocation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    openGooglePlace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        String email = binding.txeEmail.getText().toString();
        String name = binding.txeName.getText().toString();
        String location = binding.txeLocation.getText().toString();

        List<String> items = new ArrayList<>();

        if (binding.checkbox1.isChecked()) items.add(binding.checkbox1.getText().toString());
        if (binding.checkbox2.isChecked()) items.add(binding.checkbox2.getText().toString());
        if (binding.checkbox3.isChecked()) items.add(binding.checkbox3.getText().toString());
        if (binding.checkbox4.isChecked()) items.add(binding.checkbox4.getText().toString());

        User registration = new User(email, name,location, "", items);

        sendToServer(registration);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                //place.().
                place.getLatLng();

                binding.txeLocation.setText(place.getAddress());
            }
        }
    }

    private void sendToServer(final User user) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferencesUtils.getInstance().setIsUserRegistered(true);
                SharedPreferencesUtils.getInstance().setUserId(user.getUser_id());
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                finish();
            }
        },1500);

        /*RetrofitClient.getInstance(getApplicationContext()).getDonationStationService()
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
                });*/
    }

    private void showDialog(){
        new AlertDialog.Builder(RegistrationActivity.this)
                .setTitle("Error")
                .setMessage("Error while doing registration")
                .setPositiveButton("Ok", null)
                .create()
                .show();
    }

    private void openGooglePlace(){
        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }

    }
}
