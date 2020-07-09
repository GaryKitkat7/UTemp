package com.alexplanasobany7.utemp;

import java.sql.ResultSet;
import java.sql.Statement;

public class DatosUsuario {
    int IDEmpleado;
    String Nombre, Apellido, User, Password;
    char Permissions;

    public DatosUsuario (int IDEmpleado, String Nombre, String Apellido, String User, String pwd, char permissions){
        this.IDEmpleado = IDEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.User = User;
        this.Password = pwd;
        this.Permissions = permissions;

    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public String getNombre(){
        return this.Nombre;
    }
    public String getApellido(){ return this.Apellido;}
    public String getUser(){ return this.User;}
    public String getPassword() { return this.Password;}

    public char getPermissions() {
        return this.Permissions;
    }
}
