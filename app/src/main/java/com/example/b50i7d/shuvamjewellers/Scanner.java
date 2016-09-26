package com.example.b50i7d.shuvamjewellers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by B50i7D on 9/25/2016.
 */
public class Scanner extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }



    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        //Do anything with result here :D
        final String[] a = new String[1];
        Firebase.setAndroidContext(this);
        Firebase mRef = new Firebase("https://shuvamjewelery.firebaseio.com/");


        Log.w("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        String url = result.getText();
        builder.setMessage(url);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Firebase messagesRef11 = mRef.child(url);
        messagesRef11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                 a[0] = value;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        Intent intent = new Intent(Scanner.this,Total_activity.class);
        intent.putExtra("name",url);
        startActivity(intent);

        //Resume scanning
        //mScannerView.resumeCameraPreview(this);
    }
}

