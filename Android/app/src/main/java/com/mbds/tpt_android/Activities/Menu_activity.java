package com.mbds.tpt_android.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.mbds.tpt_android.R;

public class Menu_activity extends AppCompatActivity {

    private ConstraintLayout btnScanQR, btnList, btnHistory, btnSearch;
    private TextView detailsText, voirText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnScanQR = findViewById(R.id.btnScan);
        btnScanQR.setOnClickListener(v -> initiateScan());

        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(v -> onListClicked());

        btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(v -> onHistoryClicked());

        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(v -> onListClicked());

        voirText = findViewById(R.id.voirText);
        voirText.setOnClickListener(v -> onListClicked());
    }

    private void initiateScan() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan a QR code");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(true);
        integrator.setCaptureActivity(CaptureActivityPortrait.class);
        integrator.initiateScan();
    }

    private void onListClicked(){
        Intent intent = new Intent(this, ObjectsListActivity.class);
        this.startActivity(intent);
    }

    private void onHistoryClicked(){
        Intent intent = new Intent(this, HistoryListActivity.class);
        this.startActivity(intent);
    }

    private void onDetailsClicked(){
        Intent intent = new Intent(this, Details_activity.class);
        intent.putExtra("OBJECT_ID", 2);
        this.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && result.getContents()!=null) {
            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Details_activity.class);
            intent.putExtra("OBJECT_ID", result.getContents());
            this.startActivity(intent);
        }
    }
}