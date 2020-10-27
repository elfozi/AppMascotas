package com.luisemilio.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class EnvioMail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_mail_);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);
        //Para ver la flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout item = (TabLayout) findViewById(R.id.tabLayout);
        item.setVisibility(View.GONE);
    }


}