package com.mbds.tpt_android.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_list);

        initRecyclerView();
    }



    private void initRecyclerView(){
        ArrayList<ObjectsDomain> items = new ArrayList<ObjectsDomain>();
        String url = "http://192.168.88.7:8080/api/objet";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Response is: " + response);
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i =0;i<array.length();i++){
                                JSONObject singleObject = array.getJSONObject(i);
                                JSONObject proprietaireObject = singleObject.getJSONObject("proprietaire");
                                String username = proprietaireObject.getString("username");
                                ObjectsDomain p = new ObjectsDomain(
                                        singleObject.getString("id"),
                                        singleObject.getString("nom"),
                                        singleObject.getString("description"),
                                        singleObject.getString("valeur"),
                                        username,
                                        singleObject.getBoolean("disponible")
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
                System.out.println("THIS DIDINT WORK"+error);
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwb2x5cGhpYUB5b3BtYWlsLmNvbSIsImlhdCI6MTcyMjc4MDMyNywiZXhwIjoxNzIyNzgxMjI3fQ.euSVG8DaqGnbAwI-Lni6BD5ZdfJ5hdQ1K1_Vng4F3Dk");
                return headers;
            }
        };
        queue.add(stringRequest);

        System.out.println("----------------------------------------------------"+items.size());
        //System.out.println("===================================================="+items.get(0).getNom());
        recyclerViewObject = findViewById(R.id.view);
        recyclerViewObject.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }


}