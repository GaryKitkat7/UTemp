package com.alexplanasobany7.utemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRegistros extends BaseAdapter {

    private ArrayList<ItemRegistros> itemRegistrosArrayList;
    private Context context;

    public AdapterRegistros (Context context, ArrayList<ItemRegistros> itemRegistrosArrayList){
        this.context = context;
        this.itemRegistrosArrayList = itemRegistrosArrayList;
    }

    @Override
    public int getCount(){
        return itemRegistrosArrayList.size();
    }

    @Override
    public ItemRegistros getItem(int position){
        return itemRegistrosArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.llista_busqueda_registro, viewGroup, false);
        }

        TextView IDEmpleado = (TextView) view.findViewById(R.id.IDEmpleado);
        TextView Data = (TextView) view.findViewById(R.id.Fecha);
        TextView Type = (TextView) view.findViewById(R.id.Type);

        ItemRegistros itemRegistros = getItem(position);
        IDEmpleado.setText(itemRegistros.getIDEmpleado());
        Data.setText(itemRegistros.getData().toString());
        Type.setText(itemRegistros.getTipo());

        return view;
    }
}
