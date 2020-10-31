package com.luisemilio.appmascotas;

import android.content.ContentValues;

import com.luisemilio.appmascotas.db.ConstantesBaseDeDatos;

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int cantidadMeGusta;
    private String fechaUltimoMeGusta;

    public Mascota(){

    }

    public Mascota(int id, String nombre, int foto, int cantidadMeGusta,String fechaUltimoMeGusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadMeGusta = cantidadMeGusta;
        this.id = id;
        this.fechaUltimoMeGusta=fechaUltimoMeGusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(int cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public void sumarMeGusta(){
        this.cantidadMeGusta++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaUltimoMeGusta() {
        return fechaUltimoMeGusta;
    }

    public void setFechaUltimoMeGusta(String fechaUltimoMeGusta) {
        this.fechaUltimoMeGusta = fechaUltimoMeGusta;
    }

    public ContentValues toContentValue(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_id ,this.id);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_nombre ,this.nombre);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_foto ,this.foto);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_numero_me_gusta ,this.cantidadMeGusta);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_fechaUltimoMeGusta ,this.fechaUltimoMeGusta);
        return contentValues;

    }
}
