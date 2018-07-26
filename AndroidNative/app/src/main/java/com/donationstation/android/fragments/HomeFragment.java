package com.donationstation.android.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.EventDetailActivity;
import com.donationstation.android.R;
import com.donationstation.android.adapters.EventRecyclerViewAdapter;
import com.donationstation.android.adapters.IRecyclerViewItemClickListener;
import com.donationstation.android.adapters.MyItemRecyclerViewAdapter;
import com.donationstation.android.databinding.FragmentHomeBinding;
import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;
import com.donationstation.android.network.RetrofitClient;
import com.donationstation.android.utils.JsonUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<Event> events = new ArrayList<>();

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        View rootView = binding.getRoot();

        setUpEventRecyclerView();
        setUpItemsRecyclerView();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event){
        setUpItemsRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpEventRecyclerView();
        setUpItemsRecyclerView();
    }

    private void setUpEventRecyclerView() {
        events = JsonUtils.getEvents();

        binding.recyclerviewEvents.setLayoutManager(new LinearLayoutManager(getContext()));
        EventRecyclerViewAdapter adapter = new EventRecyclerViewAdapter(events);
        binding.recyclerviewEvents.setAdapter(adapter);

        adapter.setOnItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {
                Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                intent.putExtra("event", events.get(position));
                startActivity(intent);
            }
        });
    }

    private void setUpItemsRecyclerView() {
        binding.recyclerviewItems.setLayoutManager(new LinearLayoutManager(getContext()));
        MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter(JsonUtils.items);
        binding.recyclerviewItems.setAdapter(adapter);

    }
}
