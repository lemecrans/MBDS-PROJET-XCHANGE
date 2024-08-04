package com.mbds.tpt_android.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.mbds.tpt_android.R;

public class Menu_activity extends AppCompatActivity {

    private ConstraintLayout btnScanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnScanQR = findViewById(R.id.btnScan);
        btnScanQR.setOnClickListener(v -> initiateScan());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Details_activity.class);
            intent.putExtra("OBJECT_ID", result.getContents());
            this.startActivity(intent);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}