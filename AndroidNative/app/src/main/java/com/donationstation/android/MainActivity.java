package com.donationstation.android;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.donationstation.android.databinding.ActivityMainBinding;
import com.donationstation.android.fragments.HomeFragment;
import com.donationstation.android.fragments.MyItemsFragment;
import com.donationstation.android.fragments.SettingsFragments;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpBottomNavigation();
    }

    private void setUpBottomNavigation() {
        final FragmentManager manager = getSupportFragmentManager();
        mFragmentTransaction = manager.beginTransaction();

        mFragmentTransaction.add(R.id.fragment, HomeFragment.getInstance());
        mFragmentTransaction.commitAllowingStateLoss();
        binding.toolbarTitle.setText(R.string.menu_home);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mFragmentTransaction = manager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.action_my_items:
                        binding.toolbarTitle.setText(R.string.menu_my_items);
                        mFragmentTransaction.replace(R.id.fragment, MyItemsFragment.getInstance());
                        break;
                    case R.id.action_home:
                        binding.toolbarTitle.setText(R.string.menu_home);
                        mFragmentTransaction.replace(R.id.fragment, HomeFragment.getInstance());
                        break;
                    case R.id.action_settings:
                        binding.toolbarTitle.setText(R.string.menu_settings);
                        mFragmentTransaction.replace(R.id.fragment, SettingsFragments.getInstance());
                        break;
                }
                mFragmentTransaction.commitAllowingStateLoss();
                return false;
            }
        });
    }
}
