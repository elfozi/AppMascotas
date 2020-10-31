package com.luisemilio.appmascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Adatadores.MiMascotaAdaptador;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MiMascotaFragment extends Fragment {


    private RecyclerView listaDeMascotas;
    private ArrayList<Mascota> mascotas;
    private MiMascotaAdaptador adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mi_mascota, container, false);
        ImageView imgFotoMiPerro = (ImageView) view.findViewById(R.id.imgMiPerfilMascota);
        imgFotoMiPerro.setImageResource(R.drawable.mascota1);
        TextView tvMiNombreMascota = view.findViewById(R.id.tvMiNombreMascota);
        tvMiNombreMascota.setText(getString(R.string.nombr_mi_perro));
        listaDeMascotas = (RecyclerView) view.findViewById(R.id.rvMiMascotas);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaDeMascotas.setLayoutManager(glm);
        llenarLista();
        inicializarAdaptdor();

        // Inflate the layout for this fragment
        return view;
    }

    private void llenarLista() {
        this.mascotas = new ArrayList<Mascota>();
        this.mascotas.add(new Mascota(1,"Ruffo", R.drawable.mimascota1, 0,""));
        this.mascotas.add(new Mascota(2,"Ruffo", R.drawable.mimascota2, 0,""));
        this.mascotas.add(new Mascota(3,"Ruffo", R.drawable.mimascota3, 0,""));
        this.mascotas.add(new Mascota(4,"Ruffo", R.drawable.mimascota4, 0,""));
        this.mascotas.add(new Mascota(5,"Ruffo", R.drawable.mimascota5, 0,""));
    }

    public void inicializarAdaptdor() {
        adaptador = new MiMascotaAdaptador(this.mascotas, this);
        listaDeMascotas.setAdapter(adaptador);

    }
}