package com.alexplanasobany7.utemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Registro_Activity extends AppCompatActivity {

    CalendarView caledario;
    TextView DiaActual;
    ListView LlistaRegistre;
    ItemRegistros itemRegistros;
    AdapterRegistros adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_);

        final DatosUsuario ActualUser = (DatosUsuario)getIntent().getExtras().getSerializable("User");

        DiaActual = (TextView) findViewById(R.id.ActualDate);
        caledario = (CalendarView) findViewById(R.id.calendarView2);
        LlistaRegistre = (ListView) findViewById(R.id.LlistaRegistros);


        caledario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String Data = (day+" / "+month+" / "+year);
                DiaActual.setText(Data);
                ArrayList<ItemRegistros> Lista;

                Lista = new ArrayList<ItemRegistros>();
                Lista.add(ObtenerDatosUser(ActualUser.IDEmpleado));
                adapter = new AdapterRegistros(getApplicationContext(),Lista);
                LlistaRegistre.setAdapter(adapter);

            }
        });
    }

    public ItemRegistros ObtenerDatosUser (int IDEmpl){
        ItemRegistros RegistroDiaActual = null;
        try{
            Statement st = MainActivity.connexionBBDD().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Marcajes WHERE IDEmpleado = " + IDEmpl);
            RegistroDiaActual.IDEmpleado = IDEmpl;
            RegistroDiaActual.Data = rs.getDate("Data");
            RegistroDiaActual.Tipo = rs.getString("Tipo").charAt(0);

        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return RegistroDiaActual;
    }
}
