package com.example.app_stock.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_stock.beans.Producto;
import com.example.app_stock.conexion_bd.DBHelper;

import java.util.ArrayList;


public class ProductoDAO {
    private final DBHelper dbHelper;
    private SQLiteDatabase db;

    public ProductoDAO(Context cont) {
        dbHelper = new DBHelper(cont, "producto.db", null, 1);
    }

    public ContentValues MapearProducto(Producto p) {
        ContentValues cv = new ContentValues();
        cv.put("NOMBRE", p.getNOMBRE());
        cv.put("PRECIO", p.getPRECIO());
        cv.put("STOCK", p.getSTOCK());
        cv.put("FOTO", p.getFOTO());
        return cv;
    }

    public ArrayList<Producto> listar() {
        ArrayList<Producto> lista = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String[] campos = new String[]{"CODPRODUCTO", "NOMBRE", "PRECIO", "STOCK", "FOTO"};
        Cursor c = db.query("PRODUCTO", campos, null, null, null, null, null);
        while (c.moveToNext()) {
            Producto p = new Producto();
            p.setCODPRODUCTO(c.getLong(0));
            p.setNOMBRE(c.getString(1));
            p.setPRECIO(c.getDouble(2));
            p.setSTOCK(c.getInt(3));
            p.setFOTO(c.getString(4));
            lista.add(p);
        }
        c.close();
        db.close();
        return lista;
    }

    public long registrar(Producto p) {
        long fila;
        db = dbHelper.getWritableDatabase();
        fila = db.insert("PRODUCTO", null, MapearProducto(p));
        db.close();
        return fila;
    }

    public long editar(Producto p) {
        long fila;
        db = dbHelper.getWritableDatabase();
        String codprod = p.getCODPRODUCTO().toString();
        String[] parametros = {codprod};
        fila = db.update("PRODUCTO", MapearProducto(p), "CODPRODUCTO=?", parametros);
        db.close();
        return fila;
    }

    public Producto get(Long codprod) {
        Producto p = new Producto();
        db = dbHelper.getReadableDatabase();
        String[] campos = new String[]{"CODPRODUCTO", "NOMBRE", "PRECIO", "STOCK", "FOTO"};
        String[] parametros = {codprod.toString()};
        Cursor c = db.query("PRODUCTO", campos, "CODPRODUCTO=?", parametros, null, null, null, null);
        if (c.moveToNext()) {
            p.setCODPRODUCTO(c.getLong(0));
            p.setNOMBRE(c.getString(1));
            p.setPRECIO(c.getDouble(2));
            p.setSTOCK(c.getInt(3));
            p.setFOTO(c.getString(4));
        }
        c.close();
        db.close();

        return p;
    }

}
