package com.example.pract5.ui.stateholder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pract5.R;
import com.example.pract5.databinding.ItemSublistBinding;
import com.example.pract5.data.db.entities.SublistItem;

import java.util.List;

public class SublistAdapter extends RecyclerView.Adapter<SublistAdapter.ViewHolder> {

    private final List<SublistItem> sublistItems;

    public OnSubItemListClickListener onSubItemListClickListener = null;

    public interface OnSubItemListClickListener {
        void onSubItemListClickListener(int position);
    }

    public SublistAdapter(List<SublistItem> hackathonListItems) {
        this.sublistItems = hackathonListItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemSublistBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SublistItem item = sublistItems.get(position);
        holder.binding.name.setText(item.getName());
        holder.binding.company.setText(item.getClassic());
        holder.binding.dateStartEnd.setText(item.getDate());
        holder.binding.languages.setText(item.getTeacher());
        holder.binding.status.setText(item.getMark());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubItemListClickListener.onSubItemListClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return sublistItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSublistBinding binding;

        public ViewHolder(@NonNull ItemSublistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
