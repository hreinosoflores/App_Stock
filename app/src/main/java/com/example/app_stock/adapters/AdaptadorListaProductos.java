package com.example.app_stock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_stock.R;
import com.example.app_stock.beans.Producto;

import java.util.ArrayList;

public class AdaptadorListaProductos extends BaseAdapter {

    private final Context cont;
    private final int layout;
    private final ArrayList<Producto> lstProductos;

    public AdaptadorListaProductos(Context cont, int layout, ArrayList<Producto> lstProductos) {
        this.cont = cont;
        this.layout = layout;
        this.lstProductos = lstProductos;
    }

    @Override
    public int getCount() {
        return lstProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return lstProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador = LayoutInflater.from(cont);
        convertView = inflador.inflate(R.layout.list_item, null);
        Producto p = lstProductos.get(position);
        TextView tvLista_Item_Nombre = convertView.findViewById(R.id.tvLista_Item_NOMBRE_In);
        tvLista_Item_Nombre.setText(p.getNOMBRE());
        TextView tvLista_Item_Stock = convertView.findViewById(R.id.tvLista_Item_STOCK_In);
        tvLista_Item_Stock.setText(p.getSTOCK() + "");

        ImageView ivLista_Item_Foto = convertView.findViewById(R.id.ivLista_Item_FOTO);
        int foto = cont.getResources().getIdentifier(p.getFOTO(), "drawable", cont.getPackageName());
        ivLista_Item_Foto.setImageResource(foto);

        return convertView;
    }
}
