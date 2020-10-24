package com.luisemilio.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaDeMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotaAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);

        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
        llenarLista();
        inicializarAdaptdor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favoritos:
                Intent intent = new Intent(this, MostarFavoritos.class);
                startActivity(intent);

                //Toast.makeText(this, "holaa", Toast.LENGTH_SHORT).show();
                //return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
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