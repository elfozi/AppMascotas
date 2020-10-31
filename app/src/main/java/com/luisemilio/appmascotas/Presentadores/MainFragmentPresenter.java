package com.luisemilio.appmascotas.Presentadores;

import android.content.Context;

import com.luisemilio.appmascotas.Interfaces.IMainFragmentPresenter;
import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.db.ConstructorMascotas;
import com.luisemilio.appmascotas.Interfaces.IMainFragmentView;
import java.util.ArrayList;

public class MainFragmentPresenter  implements IMainFragmentPresenter {


    private IMainFragmentView IMainFragmentView;
    private Context contexto;
   // private MiContructorContactos MiContructorContactos;
    ArrayList<Mascota> mascotas;

    public MainFragmentPresenter(IMainFragmentView IMainFragmentView, Context contexto){
        this.IMainFragmentView=IMainFragmentView;
        this.contexto=contexto;
        obtenerMascotasBaseDatos();
        mostrarMascotasRV();

    }


    @Override
    public void obtenerMascotasBaseDatos() {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(contexto);
        mascotas = constructorMascotas.obtenerTodasLasMascotas();
    }

    @Override
    public void mostrarMascotasRV() {
        IMainFragmentView.inicializarAdaptadorRV(IMainFragmentView.crearAdaptador(mascotas));
        IMainFragmentView.generarLinearLayoutVertical();
    }
}
