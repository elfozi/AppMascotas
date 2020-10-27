package com.luisemilio.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.luisemilio.appmascotas.Adatadores.MascotaAdaptador;
import com.luisemilio.appmascotas.Adatadores.PageAdapter;
import com.luisemilio.appmascotas.fragments.MainFragment;
import com.luisemilio.appmascotas.fragments.MiMascotaFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager1);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);
        setUpViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_enviar_comentario:
                Intent intentEnviarComentario = new Intent(this,EnvioMail_Activity.class);
                startActivity(intentEnviarComentario);
                break;
            case R.id.menu_acerca_de:
                Intent intentAcercaDe = new Intent(this,AcercaDeActivity.class);
                startActivity(intentAcercaDe);
                break;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new MiMascotaFragment());
        return fragments;
    }

    private void setUpViewPager(){
        FragmentManager fm = getSupportFragmentManager();
        PageAdapter adapter = new PageAdapter(fm,0,agregarFragments());

        if (viewPager != null){
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_dog_house_100);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_dog_64);
    }



}