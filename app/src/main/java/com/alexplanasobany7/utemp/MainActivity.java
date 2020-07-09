package com.alexplanasobany7.utemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    public DatosUsuario UsuarioRegistrado;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Login = (Button) findViewById(R.id.LogIn);
        final EditText User = (EditText) findViewById(R.id.User);
        final EditText pwd = (EditText) findViewById(R.id.password);

        //Cambiar de página
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Comprobar credenciales

                UsuarioRegistrado = ConsultaLogin(User.getText().toString(),pwd.getText().toString());
                if (UsuarioRegistrado.User.equals(User.getText().toString()) && UsuarioRegistrado.Password.equals(pwd.getText().toString())){
                    Intent logueado = new Intent(MainActivity.this,Main_Menu.class);
                    logueado.putExtra("User", (Serializable) UsuarioRegistrado);
                    startActivity(logueado);
                }else{
                    Toast.makeText(context,"USUARIO Y/O CONTRASEÑA INCORRECTOS",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // CONNECTAR BBDD

    public static Connection connexionBBDD(){
        Connection connexion = null;
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforce.jtds.jtds.jdbc.Driver").newInstance();
            connexion= DriverManager.getConnection("jdbc:jtds:sqlserver://172.16.16.92;databaseName=MCon_Test;user=sa;password=Vsn1234");
        }catch(Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return connexion;
    }

    public DatosUsuario ConsultaLogin(String usu, String pass){
        DatosUsuario ActualUser = null;
        try{
            Statement st = connexionBBDD().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Usuarios");
            ActualUser.IDEmpleado = rs.getInt("IDEmpleado");
            ActualUser.User = rs.getString("Usuario");
            ActualUser.Password = rs.getString("Password");
            ActualUser.Nombre = rs.getString("Nombre");
            ActualUser.Apellido = rs.getString("Apellido");
            ActualUser.Permissions = rs.getString("Permissions").charAt(0);
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return ActualUser;
    }


    //  TODO: HAY QUE PONERLO EN LA PANTALLA DE ADMIN...... SOLO FALTARIA HACER UN ONCLICKLISTENER Y LLAMAR A ESTA FUNCION

    /*public void AgregarUsuario(){
        try{
            PreparedStatement nuevouser = connexionBBDD().prepareStatement("insert into Usuarios values (?,?,?,?)");
            nuevouser.setString(1, NOMBRE.getText().toString());
            //un campo para cada valor, o campor por defecto hasta que coincida con la BBDD
            nuevouser.executeUpdate();

            Toast.makeText(getApplicationContext(),"Nuevo Usuario Agregado Correctamente",Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),"Error en la agregación del usuario",Toast.LENGTH_SHORT).show();
        }
    }*/

}
