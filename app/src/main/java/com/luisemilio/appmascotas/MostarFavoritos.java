package com.luisemilio.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Adatadores.MostrarFavoritosAdaptador;
import com.luisemilio.appmascotas.Interfaces.IMostrarFavoritosPresenter;
import com.luisemilio.appmascotas.Interfaces.IMostrarFavoritosView;
import com.luisemilio.appmascotas.Presentadores.MostrarFavoritosPresenter;

import java.util.ArrayList;

public class MostarFavoritos extends AppCompatActivity implements IMostrarFavoritosView {

    private RecyclerView listaDeMascotas;
    private IMostrarFavoritosPresenter iMostrarFavoritosPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostar_favoritos);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        TabLayout item = (TabLayout) findViewById(R.id.tabLayout);
        item.setVisibility(View.GONE);
        iMostrarFavoritosPresenter = new MostrarFavoritosPresenter(this, getBaseContext());
    }
    /*
    //Sirve para desactivar opciones del menu AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actions, menu);
        MenuItem item = menu.findItem(R.id.action_favoritos);
        item.setVisible(false);//*/
       // return true;
    //}
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case R.id.action_favoritos:
                Toast.makeText(this, "holaa", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }*/
      //  return true;
  //  }



   /* public void cambioLista(){
        adaptador.notifyDataSetChanged();
    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
    }

    @Override
    public MostrarFavoritosAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MostrarFavoritosAdaptador adaptador;
        adaptador = new MostrarFavoritosAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MostrarFavoritosAdaptador adaptador) {
        listaDeMascotas.setAdapter(adaptador);
    }
}