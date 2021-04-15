package com.example.app_stock.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_stock.R;
import com.example.app_stock.beans.Producto;
import com.example.app_stock.dao.ProductoDAO;

public class EditarProducto extends AppCompatActivity implements View.OnClickListener {

    private TextView tvEditar_CODPRODUCTO_out, tvEditar_FOTO_out;
    private EditText ptEditar_STOCK_in, ptEditar_PRECIO_in, ptEditar_NOMBRE_in;
    private Button btEditar_Editar;
    private ProductoDAO p_dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);


        tvEditar_CODPRODUCTO_out = findViewById(R.id.tvEditar_CODPRODUCTO_out);
        tvEditar_FOTO_out = findViewById(R.id.tvEditar_FOTO_out);
        ptEditar_STOCK_in = findViewById(R.id.ptEditar_STOCK_in);
        ptEditar_PRECIO_in = findViewById(R.id.ptEditar_PRECIO_in);
        ptEditar_NOMBRE_in = findViewById(R.id.ptEditar_NOMBRE_in);
        btEditar_Editar = findViewById(R.id.btEditar_Editar);
        btEditar_Editar.setOnClickListener(this);
        p_dao = new ProductoDAO(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvEditar_CODPRODUCTO_out.setText(extras.getLong("CODPRODUCTO") + "");
            ptEditar_NOMBRE_in.setText(extras.getString("NOMBRE"));
            ptEditar_PRECIO_in.setText(extras.getDouble("PRECIO") + "");
            ptEditar_STOCK_in.setText(extras.getInt("STOCK") + "");
            tvEditar_FOTO_out.setText(extras.getString("FOTO"));
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btEditar_Editar) {
            Producto p = new Producto();
            p.setCODPRODUCTO(Long.parseLong(tvEditar_CODPRODUCTO_out.getText().toString()));
            p.setNOMBRE(ptEditar_NOMBRE_in.getText().toString());
            p.setPRECIO(Double.parseDouble(ptEditar_PRECIO_in.getText().toString()));
            p.setSTOCK(Integer.parseInt(ptEditar_STOCK_in.getText().toString()));
            p.setFOTO(tvEditar_FOTO_out.getText().toString());


            long q = p_dao.editar(p);

            if (q > 0) {
                Toast.makeText(EditarProducto.this, "Producto Actualizado Correctamente", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EditarProducto.this, ListaProducto.class);
                startActivity(i);
            } else {
                Toast.makeText(EditarProducto.this, "Fallo al actualizar", Toast.LENGTH_LONG).show();
            }

        }

    }
}
