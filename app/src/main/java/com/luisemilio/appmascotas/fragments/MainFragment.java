package com.luisemilio.appmascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Interfaces.IMainFragmentView;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.Interfaces.IMainFragmentPresenter;
import com.luisemilio.appmascotas.Presentadores.MainFragmentPresenter;
import com.luisemilio.appmascotas.R;

import java.util.ArrayList;


public class MainFragment extends Fragment implements IMainFragmentView {

    private RecyclerView listaDeMascotas;
    private IMainFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listaDeMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        presenter = new MainFragmentPresenter(this,getContext());
           // Inflate the layout for this fragment
        return view;
    }



    public void cambioLista(){
      //  adaptador.notifyDataSetChanged();
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador;
        adaptador = new MascotaAdaptador(mascotas,this);
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaDeMascotas.setAdapter(adaptador);
    }
}