package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;

public class mainscreen extends AppCompatActivity {
Button takepic,nextbtn;
EditText phno;
DatabaseReference reff;
long id=0;
Visitors visitors;
//long phne;
private int STORAGE_PERMISSION_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        visitors=new Visitors();
        takepic=(Button)findViewById(R.id.takepic);
        nextbtn=(Button)findViewById(R.id.nextbtn);
        phno=(EditText)findViewById(R.id.phno);
        //phne=Long.parseLong(phno.getText().toString().trim());
        takepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent3=new   Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(Intent3);
            }

        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mainscreen.this, "Next...",Toast.LENGTH_LONG).show();
            }
        });


    }
}
