package com.luisemilio.appmascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.luisemilio.appmascotas.Mascota;
import com.luisemilio.appmascotas.R;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context contexto;

    public BaseDeDatos(@Nullable Context context) {
        super(context, ConstantesBaseDeDatos.DATABASE_NAME, null, ConstantesBaseDeDatos.DATABASE_VERSION);
        this.contexto=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascitas ="CREATE TABLE " +ConstantesBaseDeDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_nombre     + " TEXT, "+
                ConstantesBaseDeDatos.TABLE_MASCOTAS_foto       + " INTEGER, "+
                ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta     + " TEXT, "+
                ConstantesBaseDeDatos.TABLE_MASCOTAS_fechaUltimoMeGusta     + " TEXT"+
                ")";
        db.execSQL(queryCrearTablaMascitas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDeDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db =this.getReadableDatabase();
        db.insert(ConstantesBaseDeDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void actualizarNumeroMeGusta(ContentValues contentValues){
        int idMascota = contentValues.getAsInteger(ConstantesBaseDeDatos.TABLE_MASCOTAS_id);
        int numeroMeGusta =  contentValues.getAsInteger(ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta);
        String query = "UPDATE "+ConstantesBaseDeDatos.TABLE_MASCOTAS+
                " set "+ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta+" = "+numeroMeGusta+", "+
                ConstantesBaseDeDatos.TABLE_MASCOTAS_fechaUltimoMeGusta+ "= julianday('now')"+
                "WHERE "+ConstantesBaseDeDatos.TABLE_MASCOTAS_id + "="+idMascota;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public ArrayList<Mascota> obtenerLosUltimos5Favoritos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "
                + ConstantesBaseDeDatos.TABLE_MASCOTAS +
                " WHERE " + ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta + " !=0 "+
                " order by "+ConstantesBaseDeDatos.TABLE_MASCOTAS_fechaUltimoMeGusta+
                " desc limit 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));
            mascota.setCantidadMeGusta(registros.getInt(3));
            mascota.setFechaUltimoMeGusta(registros.getString(4));
            mascotas.add(mascota);
        }
        db.close();
        return  mascotas;


    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM "+ConstantesBaseDeDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros  = db.rawQuery(query,null);
        while(registros.moveToNext()){
            Mascota  mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));
            mascota.setCantidadMeGusta(registros.getInt(3));
            mascota.setFechaUltimoMeGusta(registros.getString(4));
            mascotas.add(mascota);
        }
        db.close();
        return  mascotas;
    }

}
