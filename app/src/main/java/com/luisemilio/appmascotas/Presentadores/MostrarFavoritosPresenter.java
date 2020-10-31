package com.luisemilio.appmascotas.Presentadores;

import android.content.Context;

import com.luisemilio.appmascotas.Interfaces.IMainFragmentView;
import com.luisemilio.appmascotas.Interfaces.IMostrarFavoritosView;
import com.luisemilio.appmascotas.Interfaces.IMostrarFavoritosPresenter;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class MostrarFavoritosPresenter implements IMostrarFavoritosPresenter {


    private IMostrarFavoritosView IMostrarFavoritosView;
    private Context contexto;
    // private MiContructorContactos MiContructorContactos;
    ArrayList<Mascota> mascotas;

    public MostrarFavoritosPresenter(IMostrarFavoritosView IMainFragmentView, Context contexto){
        this.IMostrarFavoritosView=IMainFragmentView;
        this.contexto=contexto;
        obtenerMascotasBaseDatos();
        mostrarMascotasRV();

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this.contexto);
        this.mascotas = constructorMascotas.obtener5MascotasFavoritas();
    }

    @Override
    public void mostrarMascotasRV() {
        IMostrarFavoritosView.inicializarAdaptadorRV(IMostrarFavoritosView.crearAdaptador(mascotas));
        IMostrarFavoritosView.generarLinearLayoutVertical();
    }
}
