package com.example.app_stock.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_stock.R;
import com.example.app_stock.beans.Usuario;
import com.example.app_stock.dao.UsuarioDAO;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Usuario> usuarios;
    private EditText ptLogin_IDLOGIN_in, ptLogin_PASSWORD_in;

    private Button btLogin_Ingresar;

    private UsuarioDAO u_dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ptLogin_IDLOGIN_in = findViewById(R.id.ptLogin_IDLOGIN_in);
        ptLogin_PASSWORD_in = findViewById(R.id.ptLogin_PASSWORD_in);
        btLogin_Ingresar = findViewById(R.id.btLogin_Ingresar);

        btLogin_Ingresar.setOnClickListener(this);

        u_dao = new UsuarioDAO(this);
        usuarios = u_dao.listar();

        if (usuarios.size() < 1) {
            Usuario u1 = new Usuario("Daniel", "Reinoso", "73580887", "alm_01", "1234", true);
            Usuario u2 = new Usuario("Rally", "Flores", "12456598", "alm_02", "1234", true);
            Usuario u3 = new Usuario("Olga", "Flores", "04152687", "alm_03", "1234", true);

            u_dao.registrar(u1);
            u_dao.registrar(u2);
            u_dao.registrar(u3);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLogin_Ingresar) {

            Usuario u_in = new Usuario();
            u_in.setIDLOGIN(ptLogin_IDLOGIN_in.getText().toString());
            u_in.setPASSWORD(this.ptLogin_PASSWORD_in.getText().toString());

            Usuario u_out = u_dao.log_in(u_in);

            if (u_out != null) {
                Toast.makeText(Login.this, "Usuario logueado correctamente", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Login.this, ListaProducto.class);
                startActivity(i);
            } else {
                Toast.makeText(Login.this, "Hubo problemas al validar el usuario", Toast.LENGTH_LONG).show();
            }

        }

    }
}
