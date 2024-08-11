package com.mbds.tpt_android.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.mbds.tpt_android.R;

public class Intro_activity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v->onStartClicked());
    }

    private void onStartClicked(){
        Intent intent = new Intent(this, Menu_activity.class);
        this.startActivity(intent);
    }
}