package com.donationstation.android.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donationstation.android.R;
import com.donationstation.android.databinding.ItemEventBinding;
import com.donationstation.android.models.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    private List<Event> mEvents = new ArrayList<>();

    private IRecyclerViewItemClickListener listener;
    public void setOnItemClickListener(IRecyclerViewItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public EventRecyclerViewAdapter(@NonNull List<Event> events) {
        this.mEvents = events;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemEventBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_event, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = mEvents.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemEventBinding mBinding;
        public ViewHolder(ItemEventBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(this);
            mBinding = binding;
        }

        public void bind(@NonNull Event event) {
            mBinding.setEvent(event);
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