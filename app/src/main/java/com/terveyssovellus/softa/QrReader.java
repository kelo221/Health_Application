package com.terveyssovellus.softa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.CameraSource;
import com.terveyssovellus.softa.profile.Profile;

import java.io.IOException;

public class QrReader extends AppCompatActivity {
    SurfaceView surfaceView;
    CameraSource cameraSource;
    TextView codePreview;
    BarcodeDetector barcodeDetector;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_reader);
        surfaceView = (SurfaceView) findViewById(R.id.cameraPreview);
        codePreview = (TextView)findViewById(R.id.codePreview);
        barcodeDetector = new BarcodeDetector.Builder(getApplicationContext())
                .setBarcodeFormats(Barcode.QR_CODE).build();
        profile = Profile.getInstance();
        cameraSource = new CameraSource.Builder(getApplicationContext(), barcodeDetector)
                .setRequestedPreviewSize(640, 480).build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                try {
                    cameraSource.start(holder);
                } catch(IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

            @Override
            public void surfaceDestroyed(SurfaceHolder holder){
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>(){
            @Override
            public void release(){}

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if(qrCodes.size() != 0){
                    codePreview.post(new Runnable(){
                        @Override
                        public void run() {
                            cameraSource.stop();
                            Profile.getInstance().setPlanString(qrCodes.valueAt(0).displayValue);
                            Intent refresh = new Intent(getApplicationContext(), MainActivity.class);
                            refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            refresh.putExtra(MainActivity.TARGET_FRAGMENT,1);
                            finish();
                            startActivity(refresh);
                        }
                    });
                }
            }
        });
    }
}