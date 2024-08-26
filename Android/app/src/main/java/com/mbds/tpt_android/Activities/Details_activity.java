package com.mbds.tpt_android.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.mbds.tpt_android.Adapters.ObjectsAdapter;
import com.mbds.tpt_android.Domains.ObjectsDomain;
import com.mbds.tpt_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Details_activity extends AppCompatActivity {

    private TextView textViewTitre;
    private TextView textViewProp;
    private TextView description;
    private ImageView img;
    private ConstraintLayout btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewTitre = findViewById(R.id.titre);
        img = findViewById(R.id.img);
        description = findViewById(R.id.description);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String objectId = intent.getStringExtra("OBJECT_ID");

        fetchObjectDetails(objectId);

        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void fetchObjectDetails(String objectId) {
        String url = "http://192.168.88.7:8080/api/objet/"+objectId;
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String decodedResponse = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                            JSONObject singleObject = new JSONObject(decodedResponse);
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
                            runOnUiThread(() -> {
                                textViewTitre.setText(p.getNom());
                                description.setText(p.getDescription());
                                if (p.getImage() != null && !p.getImage().isEmpty()) {
                                    byte[] decodedString = Base64.decode(p.getImage(), Base64.DEFAULT);
                                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                                    Glide.with(Details_activity.this)
                                            .load(decodedByte)
                                            .transform(new RoundedCorners(40))
                                            .into(img);
                                }
                            });
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("THIS DIDINT WORK"+error);
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=UTF-8");
                return headers;
            }
        };
        queue.add(stringRequest);
    }
}