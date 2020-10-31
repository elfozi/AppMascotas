package com.luisemilio.appmascotas.Interfaces;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Mascota;

import java.util.ArrayList;

public interface IMainFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
