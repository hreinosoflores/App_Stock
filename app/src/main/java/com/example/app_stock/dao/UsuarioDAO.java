package com.example.app_stock.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_stock.beans.Usuario;
import com.example.app_stock.conexion_bd.DBHelper;

import java.util.ArrayList;

public class UsuarioDAO {

    private final DBHelper dbHelper;
    private SQLiteDatabase db;

    public UsuarioDAO(Context cont) {
        dbHelper = new DBHelper(cont, "usuario.db", null, 1);
    }

    public ContentValues MapearUsuario(Usuario u) {
        ContentValues cv = new ContentValues();
        cv.put("NOMBRES", u.getNOMBRES());
        cv.put("APELLIDOS", u.getAPELLIDOS());
        cv.put("DNI", u.getDNI());
        cv.put("IDLOGIN", u.getIDLOGIN());
        cv.put("PASSWORD", u.getPASSWORD());
        cv.put("ESTADO", u.getESTADO());
        return cv;
    }


    public Usuario log_in(Usuario u_in) {
        Usuario u_out = null;
        db = dbHelper.getReadableDatabase();
        String[] campos = {"CODUSUARIO", "NOMBRES", "APELLIDOS", "DNI", "IDLOGIN", "PASSWORD", "ESTADO"};
        String[] parametros = {u_in.getIDLOGIN(), u_in.getPASSWORD()};
        Cursor c = this.db.query("USUARIO", campos, "IDLOGIN=? AND PASSWORD=?", parametros, null, null, null, null);
        if (c.moveToFirst()) {
            u_out = new Usuario();
            u_out.setCODUSUARIO(c.getLong(0));
            u_out.setNOMBRES(c.getString(1));
            u_out.setAPELLIDOS(c.getString(2));
            u_out.setDNI(c.getString(3));
            u_out.setIDLOGIN(c.getString(4));
            u_out.setPASSWORD(c.getString(5));
            u_out.setESTADO(Boolean.parseBoolean(c.getString(6)));
            c.close();//cierro el cursor
        } else {
            return null;
        }

        //cierro la conexion
        c.close();
        db.close();
        return u_out;
    }


    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String[] campos = {"CODUSUARIO", "NOMBRES", "APELLIDOS", "DNI", "IDLOGIN", "PASSWORD", "ESTADO"};
        Cursor c = this.db.query("USUARIO", campos, null, null, null, null, null);
        while (c.moveToNext()) {
            Usuario u = new Usuario();
            u.setCODUSUARIO(c.getLong(0));
            u.setNOMBRES(c.getString(1));
            u.setAPELLIDOS(c.getString(2));
            u.setDNI(c.getString(3));
            u.setIDLOGIN(c.getString(4));
            u.setPASSWORD(c.getString(5));
            u.setESTADO(Boolean.parseBoolean(c.getString(6)));
            lista.add(u);
        }
        c.close();

        //cierro la conexion
        db.close();
        return lista;
    }

    public long registrar(Usuario u) {
        long fila;
        db = dbHelper.getWritableDatabase();
        fila = db.insert("USUARIO", null, MapearUsuario(u));
        db.close();
        return fila;
    }


}
