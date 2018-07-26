package com.donationstation.android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.donationstation.android.adapters.IRecyclerViewItemClickListener;
import com.donationstation.android.adapters.MyAdapter;
import com.donationstation.android.adapters.MyItemRecyclerViewAdapter;
import com.donationstation.android.databinding.ActivityEventDetailBinding;
import com.donationstation.android.databinding.ActivityMainBinding;
import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;

import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/25/18.
 */

public class EventDetailActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;

    private ActivityEventDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_detail);

        Event event = getIntent().getParcelableExtra("event");
        binding.setEvent(event);

        setUpItemsRecyclerView(event.items);
    }

    private void setUpItemsRecyclerView(List<String> myItems) {
        binding.recyclerviewItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MyAdapter adapter = new MyAdapter(myItems);
        binding.recyclerviewItems.setAdapter(adapter);
    }
}