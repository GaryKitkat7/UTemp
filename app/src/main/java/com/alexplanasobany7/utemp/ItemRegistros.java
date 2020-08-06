package com.alexplanasobany7.utemp;

import java.util.Date;

public class ItemRegistros {

    int IDEmpleado;
    char Tipo;
    Date Data;

    public ItemRegistros(int idemp, Date Data, char Tipo){
        this.IDEmpleado = idemp;
        this.Data = Data;
        this.Tipo = Tipo;
    }

    public int getIDEmpleado(){
        return this.IDEmpleado;
    }

    public Date getData(){
        return this.Data;
    }

    public char getTipo(){
        return this.Tipo;
    }

}
