package com.alexplanasobany7.utemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Marcas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);
        Button Entrada = (Button) findViewById(R.id.Entrada);
        Button Salida = (Button) findViewById(R.id.Salida);
        final DatosUsuario ActualUser = (DatosUsuario)getIntent().getExtras().getSerializable("User");


        Entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Registrar a BBDD como entrada
                try {
                    PreparedStatement NuevaEntrada = MainActivity.connexionBBDD().prepareStatement("insert into Marcajes values (?,?,?,?)");
                    NuevaEntrada.setInt(1, ActualUser.IDEmpleado);
                    NuevaEntrada.setString(2,"E");
                    NuevaEntrada.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                    NuevaEntrada.setTime(4, new java.sql.Time(System.currentTimeMillis()));
                    //un campo para cada valor, o campor por defecto hasta que coincida con la BBDD
                    NuevaEntrada.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Registrar salida en BBDD
                try {
                    PreparedStatement NuevaEntrada = MainActivity.connexionBBDD().prepareStatement("insert into Marcajes values (?,?,?,?)");
                    NuevaEntrada.setInt(1, ActualUser.IDEmpleado);
                    NuevaEntrada.setString(2,"S");
                    NuevaEntrada.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                    NuevaEntrada.setTime(4, new java.sql.Time(System.currentTimeMillis()));
                    //un campo para cada valor, o campor por defecto hasta que coincida con la BBDD
                    NuevaEntrada.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
