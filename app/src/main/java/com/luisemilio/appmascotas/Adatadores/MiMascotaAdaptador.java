package com.luisemilio.appmascotas.Adatadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;
import com.luisemilio.appmascotas.fragments.MainFragment;
import com.luisemilio.appmascotas.fragments.MiMascotaFragment;

import java.util.ArrayList;

public class MiMascotaAdaptador extends RecyclerView.Adapter <MiMascotaAdaptador.MiMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    MiMascotaFragment actividad;

    public MiMascotaAdaptador(ArrayList<Mascota> mascotas, MiMascotaFragment activity){
        this.mascotas=mascotas;
        this.actividad=activity;
    }

    @NonNull
    @Override
    //Inflar el layout y lo pasara al viewholder para que el obtenga los view
    public MiMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Se asigna el layout, en este caso el cardview, que se va estar reciclando
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota,parent,false);
        //Si agrego este listener escucha cuando toco cualquier parte del cardview no solo el boton o la foto
        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) v.findViewById(R.id.tvNombreMascota);
                Toast.makeText(activity,t.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
        return new MiMascotaViewHolder(v);
    }

    @Override
    //aoscia  cada elemento de la lista  con cada view
    public void onBindViewHolder(@NonNull MiMascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgMiFotoMascota.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvMiNumeroMeGusta.setText(String.valueOf(mascota.getCantidadMeGusta()));
            }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista

        return mascotas.size();

    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imgMiFotoMascota;
        private final TextView tvMiNumeroMeGusta;
        private final ImageView imgMiFavIco;

        public MiMascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMiFotoMascota      = (ImageView)  itemView.findViewById(R.id.imgMiFotoMascota);
            tvMiNumeroMeGusta     = (TextView) itemView.findViewById(R.id.tvMiNumeroMeGusta);
            imgMiFavIco           = (ImageView) itemView.findViewById(R.id.imgMiFavIco);


        }
    }
}