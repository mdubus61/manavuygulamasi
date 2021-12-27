package com.md.manavfb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter <RvAdapter.Cardviewnesnetutucu>{
    private Context mContext ;
    private List <sepet> siparislist ;

    // constractor
    public RvAdapter(Context mContext, List<sepet> siparislist) {
        this.mContext = mContext;
        this.siparislist = siparislist;
    }

    @NonNull
    @Override
    public Cardviewnesnetutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.siparissil,parent,false);
        return new Cardviewnesnetutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Cardviewnesnetutucu holder, int position) {
sepet siparis=siparislist.get(position);


holder.textView1.setText(siparis.getUrun());
holder.textView2.setText(Integer.toString(siparis.getMiktar()));
holder.textView3.setText(Integer.toString(siparis.getTutar()));


holder.buton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sepet");

        myRef.child(siparis.getUrun()).removeValue();




    }


});
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {   //tıklanma metodu
        Toast.makeText(mContext,"siparişiniz : "+siparis.getUrun(),Toast.LENGTH_SHORT).show();
    }
});
    }

    private void onResume() {
    }

    @Override
    public int getItemCount() {
        return siparislist.size();
    }

    public class Cardviewnesnetutucu extends RecyclerView.ViewHolder {
        public TextView textView1,textView2,textView3;
        public Button buton;

        public CardView cardView;
        public Cardviewnesnetutucu(View itemview){
super(itemview);
buton=itemview.findViewById(R.id.buttonsil);
textView1=itemview.findViewById(R.id.tvurun);
textView2=itemview.findViewById(R.id.tvmiktar);
textView3=itemview.findViewById(R.id.tvtutar);
cardView=itemview.findViewById(R.id.cardview);

        }
    }
}
