package com.luisemilio.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;

import java.util.ArrayList;

public class MostarFavoritos extends AppCompatActivity {

    private RecyclerView listaDeMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotaAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
        llenarLista();
        inicializarAdaptdor();
    }

    //Sirve para desactivar opciones del menu AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
/*
        getMenuInflater().inflate(R.menu.actions, menu);
        MenuItem item = menu.findItem(R.id.action_favoritos);
        item.setVisible(false);//*/
        return true;
    }
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
        return true;
    }


    private void llenarLista(){
        this.mascotas= new ArrayList<Mascota>();
        this.mascotas.add(new Mascota("Rex",R.drawable.mascota2,0));
        this.mascotas.add(new Mascota("Garfield",R.drawable.mascota4,0));
            }

    public void inicializarAdaptdor(){
        adaptador = new MascotaAdaptador(this.mascotas,this);
        listaDeMascotas.setAdapter(adaptador);
    }

    public void cambioLista(){
        adaptador.notifyDataSetChanged();
    }
}