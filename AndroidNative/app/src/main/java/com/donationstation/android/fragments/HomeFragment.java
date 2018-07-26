package com.donationstation.android.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.adapters.EventRecyclerViewAdapter;
import com.donationstation.android.adapters.IRecyclerViewItemClickListener;
import com.donationstation.android.adapters.MyItemRecyclerViewAdapter;
import com.donationstation.android.databinding.FragmentHomeBinding;
import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;
import com.donationstation.android.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<Event> events = new ArrayList<>();
    private List<MyItem> myItems = new ArrayList<>();

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        View rootView = binding.getRoot();

        return rootView;
    }

    private void setUpEventRecyclerView() {
        binding.recyclerviewEvents.setLayoutManager(new LinearLayoutManager(getContext()));
        EventRecyclerViewAdapter adapter = new EventRecyclerViewAdapter(events);
        binding.recyclerviewEvents.setAdapter(adapter);

        adapter.setOnItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {

            }
        });
    }

    private void setUpItemsRecyclerView() {
        binding.recyclerviewItems.setLayoutManager(new LinearLayoutManager(getContext()));
        MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter(myItems);
        binding.recyclerviewItems.setAdapter(adapter);

        adapter.setOnItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {

            }
        });
    }

    private void getEvents(){
        RetrofitClient.getInstance(getContext()).getDonationStationService()
                .getEvents()
                .enqueue(new Callback<List<Event>>() {
                    @Override
                    public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<Event>> call, Throwable t) {

                    }
                });
    }

    private void getMyItems(){
        RetrofitClient.getInstance(getContext()).getDonationStationService()
                .getMyItems()
                .enqueue(new Callback<List<MyItem>>() {
                    @Override
                    public void onResponse(Call<List<MyItem>> call, Response<List<MyItem>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<MyItem>> call, Throwable t) {

                    }
                });
    }
}
