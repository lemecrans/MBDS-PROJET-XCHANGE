package com.mbds.tpt_android.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mbds.tpt_android.Adapters.ObjectsAdapter;
import com.mbds.tpt_android.Domains.ObjectsDomain;
import com.mbds.tpt_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectsListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterObjectListe;
    private RecyclerView recyclerViewObject;
    private ConstraintLayout btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_list);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackClicked());

        initRecyclerView();
    }

    private void onBackClicked(){
        finish();
    }

    private void initRecyclerView() {
        recyclerViewObject = findViewById(R.id.view);
        recyclerViewObject.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        System.out.println("---------------------------------------------------JE SUIS ICI");
        ArrayList<ObjectsDomain> items = new ArrayList<>();
        String url = "http://192.168.88.7:8080/api/objet";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Response is: " + response);
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject singleObject = array.getJSONObject(i);
                                JSONObject proprietaireObject = singleObject.getJSONObject("proprietaire");
                                String username = proprietaireObject.getString("username");
                                String imageBase64 = singleObject.optString("image", null);

                                ObjectsDomain p = new ObjectsDomain(
                                        singleObject.getString("id"),
                                        singleObject.getString("nom"),
                                        singleObject.getString("description"),
                                        singleObject.getString("valeur"),
                                        username,
                                        singleObject.getBoolean("disponible"),
                                        imageBase64
                                );
                                items.add(p);
                            }
                            adapterObjectListe = new ObjectsAdapter(items);
                            recyclerViewObject.setAdapter(adapterObjectListe);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("THIS DIDN'T WORK: " + error);
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                return headers;
            }
        };

        int socketTimeout = 5 * 1000;
        RetryPolicy policy = new DefaultRetryPolicy(
                socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );
        stringRequest.setRetryPolicy(policy);

        queue.add(stringRequest);
    }



}