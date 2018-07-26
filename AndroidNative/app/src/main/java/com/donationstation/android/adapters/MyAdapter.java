package com.donationstation.android.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.databinding.ItemMyBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/25/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> mMyItems = new ArrayList<>();
    private IRecyclerViewItemClickListener listener;

    public void setOnItemClickListener(IRecyclerViewItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public MyAdapter(@NonNull List<String> myItems) {
        this.mMyItems = myItems;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMyBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_my, parent, false);
        return new MyAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        String myItem = mMyItems.get(position);
        holder.bind(myItem);
    }

    @Override
    public int getItemCount() {
        return mMyItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemMyBinding mBinding;

        public ViewHolder(ItemMyBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(this);
            mBinding = binding;
        }

        public void bind(@NonNull String myItem) {
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
