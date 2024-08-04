package com.mbds.tpt_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;

import com.mbds.tpt_android.Activities.Details_activity;
import com.mbds.tpt_android.Domains.ObjectsDomain;
import com.mbds.tpt_android.R;
import com.mbds.tpt_android.Util.HistoryItem;
import com.mbds.tpt_android.Util.HistoryManager;

import java.util.ArrayList;
import java.util.List;

public class ObjectsAdapter extends RecyclerView.Adapter<ObjectsAdapter.ViewHolder> {
    ArrayList<ObjectsDomain> items;
    Context context;

    public ObjectsAdapter(ArrayList<ObjectsDomain> items){
        this.items = items;
    }

    @NonNull
    @Override
    public ObjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list,parent,false);
        context = parent.getContext();
        return new ViewHolder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectsAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getNom());
        holder.proprietaire.setText(items.get(position).getProprietaire());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getNom(),"drawable",holder.itemView.getContext().getPackageName());
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

        holder.itemView.setOnClickListener(v -> {
            String objectId = items.get(position).getId();
            String objectName = items.get(position).getNom();
            String proprietaire = items.get(position).getProprietaire();

            HistoryManager historyManager = new HistoryManager(context);
            //historyManager.addToHistory(objectId, objectName,proprietaire);

            List<HistoryItem> historyList = historyManager.getAllHistory();

            for (HistoryItem item : historyList) {
                System.out.println("Timestamp: " + item.getTimestamp());
                System.out.println("Object ID: " + item.getObjectId());
                System.out.println("Object Name: " + item.getObjectName());
                System.out.println("Proprietaire: "+ item.getProprietaire());
            }

            Intent intent = new Intent(context, Details_activity.class);
            intent.putExtra("OBJECT_ID", objectId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, proprietaire;
        ImageView pic, background_img;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            proprietaire = itemView.findViewById(R.id.proprietaire);
            pic = itemView.findViewById(R.id.pic);
            background_img = itemView.findViewById(R.id.background_img);
            layout = itemView.findViewById(R.id.main_layout);
        }
    }
}
