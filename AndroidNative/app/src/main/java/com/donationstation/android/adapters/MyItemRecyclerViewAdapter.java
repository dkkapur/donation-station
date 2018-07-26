package com.donationstation.android.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.databinding.ItemMyItemBinding;
import com.donationstation.android.models.MyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<MyItem> mMyItems = new ArrayList<>();

    private IRecyclerViewItemClickListener listener;
    public void setOnItemClickListener(IRecyclerViewItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public MyItemRecyclerViewAdapter(@NonNull List<MyItem> myItems) {
        mMyItems.addAll(myItems);
    }

    @Override
    public MyItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMyItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_my_item, parent, false);
        return new MyItemRecyclerViewAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyItemRecyclerViewAdapter.ViewHolder holder, int position) {
        MyItem myItem = mMyItems.get(position);
        holder.bind(myItem);
    }

    @Override
    public int getItemCount() {
        return mMyItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemMyItemBinding mBinding;
        public ViewHolder(ItemMyItemBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(this);
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