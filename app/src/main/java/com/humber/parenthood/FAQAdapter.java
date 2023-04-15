package com.humber.parenthood;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.databinding.FaqListItemBinding;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.ViewHolder> {

    private List<QAModel> qaList;

    public FAQAdapter(List<QAModel> qaList) {
        this.qaList = qaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FaqListItemBinding binding = FaqListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QAModel qaModel = qaList.get(position);
        holder.binding.questionTextView.setText(qaModel.getQuestion());
        holder.binding.answerTextView.setText(qaModel.getAnswer());
    }

    @Override
    public int getItemCount() {
        return qaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FaqListItemBinding binding;

        public ViewHolder(@NonNull FaqListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
