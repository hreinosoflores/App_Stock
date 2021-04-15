package com.example.app_stock.conexion_bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table PRODUCTO (" +
                        "CODPRODUCTO integer primary key autoincrement," +
                        "NOMBRE text," +
                        "PRECIO numeric," +
                        "STOCK integer," +
                        "FOTO text);"
        );
        db.execSQL(
                "create table USUARIO(" +
                        "CODUSUARIO integer  primary key autoincrement," +
                        "NOMBRES text," +
                        "APELLIDOS text," +
                        "DNI text," +
                        "IDLOGIN text," +
                        "PASSWORD text," +
                        "ESTADO int);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
