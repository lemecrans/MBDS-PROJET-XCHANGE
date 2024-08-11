package com.mbds.tpt_android.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mbds.tpt_android.Adapters.HistoryAdapter;
import com.mbds.tpt_android.Adapters.ObjectsAdapter;
import com.mbds.tpt_android.Domains.ObjectsDomain;
import com.mbds.tpt_android.R;
import com.mbds.tpt_android.Util.HistoryItem;
import com.mbds.tpt_android.Util.HistoryManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterObjectListe;
    private RecyclerView recyclerViewObject;
    private ConstraintLayout btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        btnBack = findViewById(R.id.btnBck);
        btnBack.setOnClickListener(v->onBackClicked());
        initRecyclerView();
    }

    private void onBackClicked(){
        finish();
    }

    private void initRecyclerView(){
        recyclerViewObject = findViewById(R.id.view);
        recyclerViewObject.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        HistoryManager historyManager = new HistoryManager(this);
        List<HistoryItem> items = historyManager.getAllHistory();

        adapterObjectListe = new HistoryAdapter(items);
        recyclerViewObject.setAdapter(adapterObjectListe);
    }


}