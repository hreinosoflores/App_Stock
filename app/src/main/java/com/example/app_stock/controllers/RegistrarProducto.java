package com.example.app_stock.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_stock.R;
import com.example.app_stock.beans.Producto;
import com.example.app_stock.dao.ProductoDAO;

public class RegistrarProducto extends AppCompatActivity implements View.OnClickListener {

    private EditText ptRegistrar_STOCK_in, ptRegistrar_PRECIO_in, ptRegistrar_NOMBRE_in;
    private Button btRegistrar_Registrar;
    private ProductoDAO p_dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        ptRegistrar_STOCK_in = findViewById(R.id.ptRegistrar_STOCK_in);
        ptRegistrar_PRECIO_in = findViewById(R.id.ptRegistrar_PRECIO_in);
        ptRegistrar_NOMBRE_in = findViewById(R.id.ptRegistrar_NOMBRE_in);
        btRegistrar_Registrar = findViewById(R.id.btRegistrar_Registrar);
        btRegistrar_Registrar.setOnClickListener(this);

        p_dao = new ProductoDAO(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btRegistrar_Registrar) {

            Producto pro = new Producto();
            pro.setNOMBRE(ptRegistrar_NOMBRE_in.getText().toString());
            pro.setPRECIO(Double.parseDouble(ptRegistrar_PRECIO_in.getText().toString()));
            pro.setSTOCK(Integer.parseInt(ptRegistrar_STOCK_in.getText().toString()));
            pro.setFOTO("img");

            long q = p_dao.registrar(pro);

            if (q > 0) {
                Toast.makeText(RegistrarProducto.this, "Producto Registrado Correctamente", Toast.LENGTH_LONG).show();
                Intent i = new Intent(RegistrarProducto.this, ListaProducto.class);
                startActivity(i);
            } else {
                Toast.makeText(RegistrarProducto.this, "Fallo el registrar", Toast.LENGTH_LONG).show();
            }
        }
    }
}
