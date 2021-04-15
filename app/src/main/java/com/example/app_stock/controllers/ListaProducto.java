package com.example.app_stock.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_stock.R;
import com.example.app_stock.adapters.AdaptadorListaProductos;
import com.example.app_stock.beans.Producto;
import com.example.app_stock.dao.ProductoDAO;

import java.util.ArrayList;

public class ListaProducto extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Producto> productos;
    private ListView lvlista;
    private Button btLista_Registrar;
    private ProductoDAO p_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);

        lvlista = findViewById(R.id.lvLista);
        btLista_Registrar = findViewById(R.id.btLista_Registrar);

        p_dao = new ProductoDAO(this);

        productos = p_dao.listar();

        if (productos.size() < 1) {


            Producto p1 = new Producto("Foco botella led BUID 38w 6500k ac 110v-250v                         ", 17.000000, 200, "img1");
            Producto p2 = new Producto("Foco flor 38w 3650 lumen led UFO 80% power saving                    ", 17.000000, 200, "img2");
            Producto p3 = new Producto("Foco emergencia recargable led 4h duración bateria li-on 1300 mah USB", 15.000000, 200, "img3");
            Producto p4 = new Producto("Panel led 60x60cm ERALED 40w long live 50000h duracion               ", 70.000000, 200, "img4");
            Producto p5 = new Producto("Panel led 60x60cm ERALED 48w long live 50000h duracion               ", 74.000000, 200, "img5");
            Producto p6 = new Producto("Panel led 60x60cm ERALED 53w long live 50000h duracion               ", 78.000000, 200, "img6");
            Producto p7 = new Producto("Panel led 120x30cm ERALED 40w long live 50000h duracion              ", 70.000000, 200, "img7");
            Producto p8 = new Producto("Panel led 120x30cm ERALED 48w long live 50000h duracion              ", 74.000000, 200, "img8");
            Producto p9 = new Producto("Panel led 120x30cm ERALED 53w long live 50000h duracion              ", 78.000000, 200, "img9");
            Producto p10 = new Producto("Luz emergencia SOLUXLED 10h duración 4.2w 400 lumens                ", 48.000000, 200, "img10");


            p_dao.registrar(p1);
            p_dao.registrar(p2);
            p_dao.registrar(p3);
            p_dao.registrar(p4);
            p_dao.registrar(p5);
            p_dao.registrar(p6);
            p_dao.registrar(p7);
            p_dao.registrar(p8);
            p_dao.registrar(p9);
            p_dao.registrar(p10);


        }

        final AdaptadorListaProductos a = new AdaptadorListaProductos(this, R.layout.list_item, p_dao.listar());
        lvlista.setAdapter(a);
        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Producto p = (Producto) a.getItem(position);
                Intent i = new Intent(ListaProducto.this, DetalleProducto.class);
                i.putExtra("CODPRODUCTO", p.getCODPRODUCTO());
                i.putExtra("NOMBRE", p.getNOMBRE());
                i.putExtra("PRECIO", p.getPRECIO());
                i.putExtra("STOCK", p.getSTOCK());
                i.putExtra("FOTO", p.getFOTO());
                startActivity(i);

            }
        });
        btLista_Registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLista_Registrar) {
            Intent i = new Intent(ListaProducto.this, RegistrarProducto.class);
            startActivity(i);
        }


    }
}
