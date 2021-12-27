package com.md.manavfb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ArmutActivity extends AppCompatActivity {
    Button sepeteekle,alisveristm ;
    EditText miktar ;
    Intent intent ;
    ImageButton arti,eksi;
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armut);
        arti=findViewById(R.id.arti2);
        eksi=findViewById(R.id.eksi2);
        sepeteekle=findViewById(R.id.sepeteekleelma2);
        alisveristm=findViewById(R.id.alisveristamamlaelma2);
        miktar=findViewById(R.id.etmiktar2);
        imageView2=findViewById(R.id.imageView3);
        miktar.setText(Integer.toString(1));
        arti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val= miktar.getText().toString();
                int a= Integer.parseInt(val)+1;
                miktar.setText(Integer.toString(a));
            }
        });
        eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val= miktar.getText().toString();

                int a= Integer.parseInt(val);
                if (a >1 )
                    a=a-1 ;
                miktar.setText(Integer.toString(a));

            }
        });

        sepeteekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("sepet");


                Map<String,Object>sepett=new HashMap<>();
                sepett.put("urun","armut");
                String val= miktar.getText().toString();
                int a= Integer.parseInt(val);
                sepett.put("miktar",a);
                sepett.put("tutar",a*10);
                myRef.child("armut").updateChildren(sepett);
                Toast.makeText(ArmutActivity.this, "Sepetininiz güncellendi", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void islemSecimiarmut (View v){

        intent = new Intent(this, SiparistamamlaActivity.class);
        startActivity(intent);


    }
}