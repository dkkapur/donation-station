package com.donationstation.android.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.databinding.FragmentSettingsBinding;


/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class SettingsFragments extends Fragment {


    public static SettingsFragments getInstance() {
        return new SettingsFragments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSettingsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_settings, container, false);
        View rootView = binding.getRoot();

        return rootView;
    }
}
