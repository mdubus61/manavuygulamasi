package com.md.manavfb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
 private Button elma,armut,ayva ;
 private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elma = findViewById(R.id.btnelma);
        armut = findViewById(R.id.btnarmut);
        ayva = findViewById(R.id.btnayva);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sepet");

    }
        public void islemsec(View v){
            switch (v.getId()) {

                case R.id.btnelma:
                    intent = new Intent(MainActivity.this, ElmaActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnarmut:
                    intent = new Intent(MainActivity.this, ArmutActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnayva:
                    intent = new Intent(MainActivity.this, AyvaActivity.class);
                    startActivity(intent);
                    break;


            }
        }
    }