package com.donationstation.android.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.donationstation.android.R;
import com.donationstation.android.databinding.ItemMyItemBinding;
import com.donationstation.android.databinding.ItemMyItemDeleteBinding;
import com.donationstation.android.models.MyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/25/18.
 */

public class MyItemDeleteRecyclerViewAdapter extends RecyclerView.Adapter<MyItemDeleteRecyclerViewAdapter.ViewHolder> {

    private IRecyclerViewItemClickListener listener;
    private List<MyItem> mMyItems = new ArrayList<>();

    public void setOnItemClickListener(IRecyclerViewItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public MyItemDeleteRecyclerViewAdapter(@NonNull List<MyItem> myItems) {
        this.mMyItems = myItems;
    }

    @Override
    public MyItemDeleteRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMyItemDeleteBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_my_item_delete, parent, false);
        return new MyItemDeleteRecyclerViewAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyItemDeleteRecyclerViewAdapter.ViewHolder holder, int position) {
        MyItem myItem = mMyItems.get(position);
        holder.bind(myItem);
    }

    @Override
    public int getItemCount() {
        return mMyItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemMyItemDeleteBinding mBinding;

        public ViewHolder(ItemMyItemDeleteBinding binding) {
            super(binding.getRoot());
            binding.btnDelete.setOnClickListener(this);
            mBinding = binding;
        }

        public void bind(@NonNull MyItem myItem) {
            mBinding.setMyItem(myItem);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClicked(mBinding.getRoot(), getAdapterPosition());
            }
        }
    }
}