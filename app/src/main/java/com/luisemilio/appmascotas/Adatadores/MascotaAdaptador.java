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

import com.luisemilio.appmascotas.MainActivity;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;
import com.luisemilio.appmascotas.fragments.MainFragment;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter <MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    MainFragment actividad;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, MainFragment activity){
        this.mascotas=mascotas;
        this.actividad=activity;
    }

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;

    }
    @NonNull
    @Override
    //Inflar el layout y lo pasara al viewholder para que el obtenga los view
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Se asigna el layout, en este caso el cardview, que se va estar reciclando
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        //Si agrego este listener escucha cuando toco cualquier parte del cardview no solo el boton o la foto
        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) v.findViewById(R.id.tvNombreMascota);
                Toast.makeText(activity,t.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
        return new MascotaViewHolder(v);
    }

    @Override
    //aoscia  cada elemento de la lista  con cada view
    public void onBindViewHolder(@NonNull MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        MascotaViewHolder.tvNumeroMeGusta.setText(String.valueOf(mascota.getCantidadMeGusta()));
        //En caso que mi activadad no se la main
        if (actividad != null){
            MascotaViewHolder.imgBtnMeGusta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Mascota mascota= mascotas.get(position);
                    mascota.sumarMeGusta();
                    mascotas.remove(position);
                    mascotas.add(position,mascota);
                    actividad.cambioLista();

                }
            });
        }


    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista

        return mascotas.size();

    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imgFotoMascota;
        private final ImageButton imgBtnMeGusta;
        private final TextView tvNombreMascota;
        private final TextView tvNumeroMeGusta;
        private final ImageView imgFavIco;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascota      = (ImageView)  itemView.findViewById(R.id.imgFotoMascota);
            imgBtnMeGusta       = (ImageButton) itemView.findViewById((R.id.imgBtnMeGusta));
            tvNombreMascota     = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvNumeroMeGusta     = (TextView) itemView.findViewById(R.id.tvNumeroMeGusta);
            imgFavIco           = (ImageView) itemView.findViewById(R.id.imgFavIco);


        }
    }
}