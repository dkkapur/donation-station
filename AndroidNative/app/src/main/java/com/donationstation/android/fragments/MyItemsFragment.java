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
import android.view.inputmethod.InputMethodManager;

import com.donationstation.android.R;
import com.donationstation.android.adapters.IRecyclerViewItemClickListener;
import com.donationstation.android.adapters.MyItemDeleteRecyclerViewAdapter;
import com.donationstation.android.adapters.MyItemRecyclerViewAdapter;
import com.donationstation.android.databinding.FragmentMyItemsBinding;
import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;
import com.donationstation.android.utils.JsonUtils;

import org.greenrobot.eventbus.EventBus;


import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class MyItemsFragment extends Fragment implements View.OnClickListener {

    private FragmentMyItemsBinding binding;
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
        adapter = new MyItemDeleteRecyclerViewAdapter(JsonUtils.items);
        binding.recyclerviewItems.setAdapter(adapter);

        adapter.setOnItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {
                JsonUtils.items.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String title = binding.txeAddItem.getText().toString();
        binding.txeAddItem.setText("");
        controlKeyboard();
        JsonUtils.items.add(new MyItem(title));
        adapter.notifyItemInserted(JsonUtils.items.size() - 1);

        EventBus.getDefault().post(new Event());
    }

    public void controlKeyboard() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);

            inputMethodManager.hideSoftInputFromWindow(binding.txeAddItem.getWindowToken(), 0);
    }
}
