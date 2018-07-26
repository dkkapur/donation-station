package com.donationstation.android.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.adapters.IRecyclerViewItemClickListener;
import com.donationstation.android.adapters.MyItemDeleteRecyclerViewAdapter;
import com.donationstation.android.adapters.MyItemRecyclerViewAdapter;
import com.donationstation.android.databinding.FragmentMyItemsBinding;
import com.donationstation.android.models.MyItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class MyItemsFragment extends Fragment implements View.OnClickListener {

    private FragmentMyItemsBinding binding;
    private List<MyItem> myItems = new ArrayList<>();
    private MyItemDeleteRecyclerViewAdapter adapter;

    public static MyItemsFragment getInstance() {
        return new MyItemsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_my_items, container, false);
        View rootView = binding.getRoot();

        binding.btnAdd.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpItemsRecyclerView();
    }

    private void setUpItemsRecyclerView() {
        binding.recyclerviewItems.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyItemDeleteRecyclerViewAdapter(myItems);
        binding.recyclerviewItems.setAdapter(adapter);

        adapter.setOnItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {
                myItems.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String title = binding.editAddItem.getText().toString();
        binding.editAddItem.setText("");

        myItems.add(new MyItem(title));
        adapter.notifyItemInserted(myItems.size() - 1);
    }
}
