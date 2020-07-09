package com.alexplanasobany7.utemp;

import java.util.Date;

public class ItemRegistros {

    private int IDEmpleado;
    private String Tipo;
    private Date Data;

    public ItemRegistros(int idemp, Date Data, String Tipo){
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

    public String getTipo(){
        return this.Tipo;
    }

}
