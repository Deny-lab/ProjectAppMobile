package com.deny.projectappmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.GridViewHolder> {
    private ArrayList<Novel> listNovel;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public MainAdapter(ArrayList<Novel> list) {
        this.listNovel = list;
    }
    @NonNull
    @Override
    public MainAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_grid, parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Novel novel = listNovel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listNovel.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgView);

        holder.tv_judul.setText(novel.getJudul());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listNovel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNovel.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView tv_judul;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.cover);
            tv_judul = itemView.findViewById(R.id.judul);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Novel data);
    }
}
