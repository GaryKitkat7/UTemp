package com.alexplanasobany7.utemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_Menu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);
        ListView LlistaMenu;
        final DatosUsuario ActualUser = (DatosUsuario)getIntent().getExtras().getSerializable("User");
        ArrayAdapter<String> LlistaMenuAdapter;
        List<String> MenuPrincipal = new ArrayList<>(
            Arrays.asList("Marcas","Registros","Configuración"));
        List<String> MenuPrincipalAdmin = new ArrayList<>(
                Arrays.asList("Marcas","Registros","Configuración","Administración"));


        LlistaMenu = (ListView) findViewById(R.id.menu);
        if (ActualUser.Permissions == 'W'){
            LlistaMenuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,MenuPrincipal );
        }else{
            LlistaMenuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,MenuPrincipalAdmin );
        }


        LlistaMenu.setAdapter(LlistaMenuAdapter);

        LlistaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long size) {
                if (position == 0){
                    Intent CambioAMarcas = new Intent(Main_Menu.this,Marcas.class );
                    CambioAMarcas.putExtra("User", (Serializable) ActualUser);
                    startActivity(CambioAMarcas);
                }else if (position == 1){
                    Intent CambioARegistro = new Intent (Main_Menu.this, Registro_Activity.class);
                    CambioARegistro.putExtra("User", (Serializable) ActualUser);
                    startActivity(CambioARegistro);
                }else if (position == 2){
                    Intent CambioAConfig = new Intent(Main_Menu.this, ConfiguracionActivity.class);
                    startActivity(CambioAConfig);
                }else{
                    //TODO: Falta cambiar a panel de Admin
                }
            }
        });

        // MISMA FUNCION PERO CON BOTONES

        /*Button Marca = (Button) findViewById(R.id.Marcas);
        Button Registro = (Button) findViewById(R.id.Registro);
        Button Config = (Button) findViewById(R.id.Configuracion);

        Marca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CambioAMarcas = new Intent(Main_Menu.this,Marcas.class );
                startActivity(CambioAMarcas);
            }
        });

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CambioARegistro = new Intent (Main_Menu.this, Registro_Activity.class);
                startActivity(CambioARegistro);
            }
        });

        Config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CambioAConfig = new Intent(Main_Menu.this, ConfiguracionActivity.class);
                startActivity(CambioAConfig);
            }
        });*/
    }
}
