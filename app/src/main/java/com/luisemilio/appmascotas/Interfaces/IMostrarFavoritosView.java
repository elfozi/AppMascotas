package com.luisemilio.appmascotas.Interfaces;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Adatadores.MostrarFavoritosAdaptador;
import com.luisemilio.appmascotas.Mascota;

import java.util.ArrayList;

public interface IMostrarFavoritosView {

    public void generarLinearLayoutVertical();
    public MostrarFavoritosAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MostrarFavoritosAdaptador adaptador);
}
