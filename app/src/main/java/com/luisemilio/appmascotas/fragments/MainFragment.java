package com.luisemilio.appmascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    private RecyclerView listaDeMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotaAdaptador adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listaDeMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
        llenarLista();
        inicializarAdaptdor();

        // Inflate the layout for this fragment
        return view;
    }

    private void llenarLista(){
        this.mascotas= new ArrayList<Mascota>();
        this.mascotas.add(new Mascota("Ruffo",R.drawable.mascota1,0));
        this.mascotas.add(new Mascota("Rex",R.drawable.mascota2,0));
        this.mascotas.add(new Mascota("Rocky",R.drawable.mascota3,0));
        this.mascotas.add(new Mascota("Garfield",R.drawable.mascota4,0));
        this.mascotas.add(new Mascota("Felix",R.drawable.mascota5,0));
    }

    public void inicializarAdaptdor(){
        adaptador = new MascotaAdaptador(this.mascotas,this);
        listaDeMascotas.setAdapter(adaptador);

    }

    public void cambioLista(){
        adaptador.notifyDataSetChanged();
    }
}