package com.mbds.tpt_android.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mbds.tpt_android.R;

public class ObjectsListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterObjectListe;
    private RecyclerView recyclerViewObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_list);

        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerViewObject = findViewById(R.id.view);
        recyclerViewObject.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //adapterObjectListe = new ObjectsAdapter();
        recyclerViewObject.setAdapter(adapterObjectListe);
    }
}