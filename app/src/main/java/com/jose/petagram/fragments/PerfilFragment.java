package com.jose.petagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jose.petagram.R;
import com.jose.petagram.adapter.PerfilAdapter;
import com.jose.petagram.datos.PerfilMascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private ArrayList<PerfilMascota> perfilMascota;
    private RecyclerView rvPerfilMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfilMascota = (RecyclerView) v.findViewById(R.id.rvFotosMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPerfilMascota.setLayoutManager(glm);

        llenarFotosMascota();
        inicializarAdaptador();

        return v;
    }

    //Inicia el adaptador
    public void inicializarAdaptador(){
        PerfilAdapter adaptador = new PerfilAdapter(perfilMascota);
        rvPerfilMascota.setAdapter(adaptador);
    }

    private void llenarFotosMascota(){
        perfilMascota = new ArrayList<PerfilMascota>();

        perfilMascota.add(new PerfilMascota(R.drawable.sheep, "22"));
        perfilMascota.add(new PerfilMascota(R.drawable.sheep2_48, "4"));
        perfilMascota.add(new PerfilMascota(R.drawable.sheep3_48, "17"));
        perfilMascota.add(new PerfilMascota(R.drawable.sheep4_48, "6"));
        perfilMascota.add(new PerfilMascota(R.drawable.sheep, "0"));
        perfilMascota.add(new PerfilMascota(R.drawable.sheep2_48, "5"));

    }
}
