package com.md.manavfb;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class SiparisActivity extends AppCompatActivity {
    private RecyclerView rv2;
    private ArrayList<sepet>siparislistesi;
    TextView tv;
    private RvAdapter adapter;
    Button buton;

    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis3);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sepet");

        buton=findViewById(R.id.buttondevam);
        rv2=findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);
        rv2.setLayoutManager(new LinearLayoutManager(this));


        siparislistesi=new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d:snapshot.getChildren())
                {

                    sepet sp =d.getValue(sepet.class);

                    a=a+sp.getTutar();
                    String m=  sp.getUrun();

                    sepet sepet =new sepet(sp.getUrun(), sp.getMiktar(),sp.getTutar());

                    siparislistesi.add(sepet);

                }

                adapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });
buton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SiparisActivity.this, MainActivity.class);
        startActivity(intent);
    }
});

        adapter=new RvAdapter(this,siparislistesi);

        rv2.setAdapter(adapter);

    } }
