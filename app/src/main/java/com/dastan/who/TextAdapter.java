package com.dastan.who;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder>{

    private List<String> listText;

    public TextAdapter(List<String> listText) {
        this.listText = listText;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.bind(listText.get(position));
    }

    @Override
    public int getItemCount() {
        return listText.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder{

        private TextView text;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tvTextIn);
        }

        public void bind(String s) {
            text.setText(s);
        }
    }
}
