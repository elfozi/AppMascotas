package com.luisemilio.appmascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context contexto;
    public ConstructorMascotas(Context context){
        this.contexto=context;
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        BaseDeDatos db = new BaseDeDatos(contexto);
        ArrayList<Mascota> mascotasTodas = db.obtenerTodasLasMascotas();
        if(mascotasTodas.isEmpty()){
            inizialidarDatos();
            mascotasTodas = db.obtenerTodasLasMascotas();
        }
        return mascotasTodas;

    }

    //Este metodo si obtiene de la base de datos las ultimas 5 con ratig
    public ArrayList<Mascota> obtener5MascotasFavoritas(){
       BaseDeDatos db = new BaseDeDatos(contexto);
       return db.obtenerLosUltimos5Favoritos();
    }

    public void actualizarMeGusta(Mascota mascota){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_id,mascota.getId());
        mascota.sumarMeGusta();
        contentValues.put((ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta),(mascota.getCantidadMeGusta()));
        BaseDeDatos db = new BaseDeDatos(contexto);
        db.actualizarNumeroMeGusta(contentValues);
    }

    public void inizialidarDatos(){
        BaseDeDatos db = new BaseDeDatos(contexto);
        db.insertarMascota(new Mascota(1,"Ruffo", R.drawable.mascota1,0,"").toContentValue());
        db.insertarMascota(new Mascota(2,"Rex",R.drawable.mascota2,0,"").toContentValue());
        db.insertarMascota(new Mascota(3,"Rocky",R.drawable.mascota3,0,"").toContentValue());
        db.insertarMascota(new Mascota(4,"Garfield",R.drawable.mascota4,0,"").toContentValue());
        db.insertarMascota(new Mascota(5,"Felix",R.drawable.mascota5,0,"").toContentValue());
        db.insertarMascota(new Mascota(6,"Lula", R.drawable.mascota1,0,"").toContentValue());
        db.insertarMascota(new Mascota(7,"Nala",R.drawable.mascota2,0,"").toContentValue());
        db.insertarMascota(new Mascota(8,"Thor",R.drawable.mascota3,0,"").toContentValue());
        db.insertarMascota(new Mascota(9,"Tom",R.drawable.mascota4,0,"").toContentValue());
        db.insertarMascota(new Mascota(10,"Silvestre",R.drawable.silvestre,0,"").toContentValue());
    }





}
