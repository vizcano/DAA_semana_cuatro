package com.jose.petagram.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jose.petagram.DetalleMascotaActivity;
import com.jose.petagram.R;
import com.jose.petagram.adapter.MascotaAdapter;
import com.jose.petagram.datos.DatosMascota;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    private ArrayList<DatosMascota> mascotas;
    private ArrayList<Integer> posicionesMascotas;
    private RecyclerView listaMascotas;

    public MascotasFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        mascotas = new ArrayList<DatosMascota>();

        mascotas.add(new DatosMascota("Perro", "3", R.drawable.bulldog));
        mascotas.add(new DatosMascota("Cerdo", "5", R.drawable.pig));
        mascotas.add(new DatosMascota("Oveja", "7", R.drawable.sheep));
        mascotas.add(new DatosMascota("Gato", "9", R.drawable.cat));
        mascotas.add(new DatosMascota("Gallina", "11", R.drawable.hen));

        MascotaAdapter adaptador = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adaptador);

        return v;
    }

    //Mostrar Favoritas
    public void verDetalleMascotas(){
        posicionesMascotas = new ArrayList<Integer>();

        posicionesMascotas.add(Integer.parseInt(mascotas.get(0).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(1).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(2).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(3).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(4).getRatingMascota()));

        Intent intent = new Intent(getActivity(), DetalleMascotaActivity.class);
        intent.putExtra("mascotas", posicionesMascotas);
        startActivity(intent);
    }
}
