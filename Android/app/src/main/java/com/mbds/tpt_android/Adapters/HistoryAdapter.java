package com.mbds.tpt_android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mbds.tpt_android.Domains.ObjectsDomain;
import com.mbds.tpt_android.R;
import com.mbds.tpt_android.Util.HistoryItem;
import com.mbds.tpt_android.Util.HistoryManager;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    List<HistoryItem> items;
    Context context;

    public HistoryAdapter(List<HistoryItem> items){
        this.items = items;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_history,parent,false);
        context = parent.getContext();
        return new ViewHolder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getObjectName());
        holder.proprietaire.setText(items.get(position).getProprietaire());
        holder.timestamp.setText(items.get(position).getTimestamp());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getObjectName(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);

        switch(position){
            case 0:
                holder.background_img.setImageResource(R.drawable.bg_1);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 1:
                holder.background_img.setImageResource(R.drawable.bg_2);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 2:
                holder.background_img.setImageResource(R.drawable.bg_3);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 3:
                holder.background_img.setImageResource(R.drawable.bg_4);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 4:
                holder.background_img.setImageResource(R.drawable.bg_5);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
        }

        // Configurez votre vue ici
        holder.itemView.setOnClickListener(v -> {
            // Obtenez les détails de l'objet
            String objectId = items.get(position).getObjectId();
            String objectName = items.get(position).getObjectName();
            String proprietaire = items.get(position).getProprietaire();

        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, proprietaire,timestamp;
        ImageView pic, background_img;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            proprietaire = itemView.findViewById(R.id.proprietaire);
            pic = itemView.findViewById(R.id.pic);
            timestamp = itemView.findViewById(R.id.timestamp);
            background_img = itemView.findViewById(R.id.background_img);
            layout = itemView.findViewById(R.id.main_layout);
        }
    }
}
