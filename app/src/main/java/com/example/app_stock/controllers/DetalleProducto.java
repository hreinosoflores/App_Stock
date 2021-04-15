package com.example.app_stock.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_stock.R;

import java.text.DecimalFormat;

public class DetalleProducto extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDetalle_CODPRODUCTO_in, tvDetalle_NOMBRE_in, tvDetalle_PRECIO_in, tvDetalle_STOCK_in, tvDetalle_FOTO_in;
    private Button btDetalle_Editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        tvDetalle_CODPRODUCTO_in = findViewById(R.id.tvDetalle_CODPRODUCTO_in);
        tvDetalle_NOMBRE_in = findViewById(R.id.tvDetalle_NOMBRE_in);
        tvDetalle_PRECIO_in = findViewById(R.id.tvDetalle_PRECIO_in);
        tvDetalle_STOCK_in = findViewById(R.id.tvDetalle_STOCK_in);
        tvDetalle_FOTO_in = findViewById(R.id.tvDetalle_FOTO_in);
        btDetalle_Editar = findViewById(R.id.btDetalle_Editar);
        btDetalle_Editar.setOnClickListener(this);


        DecimalFormat formatosoles = new DecimalFormat("##.00");


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvDetalle_CODPRODUCTO_in.setText(extras.getLong("CODPRODUCTO") + "");
            tvDetalle_NOMBRE_in.setText(extras.getString("NOMBRE"));
            tvDetalle_PRECIO_in.setText(formatosoles.format(extras.getDouble("PRECIO")));
            tvDetalle_STOCK_in.setText(extras.getInt("STOCK") + "");
            tvDetalle_FOTO_in.setText(extras.getString("FOTO"));

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btDetalle_Editar) {
            Intent i = new Intent(DetalleProducto.this, EditarProducto.class);
            i.putExtra("CODPRODUCTO", Long.parseLong(tvDetalle_CODPRODUCTO_in.getText().toString()));
            i.putExtra("NOMBRE", tvDetalle_NOMBRE_in.getText().toString());
            i.putExtra("PRECIO", Double.parseDouble(tvDetalle_PRECIO_in.getText().toString()));
            i.putExtra("STOCK", Integer.parseInt(tvDetalle_STOCK_in.getText().toString()));
            i.putExtra("FOTO", tvDetalle_FOTO_in.getText().toString());

            startActivity(i);
        }

    }
}
