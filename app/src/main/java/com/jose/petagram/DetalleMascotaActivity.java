package com.jose.petagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jose.petagram.adapter.MascotaAdapter;
import com.jose.petagram.datos.DatosMascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DetalleMascotaActivity extends AppCompatActivity {

    ArrayList<DatosMascota> listaDetalleMascota;
    ArrayList<Integer> ordenMascota;
    RecyclerView rvDetalleMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_detalle_mascota);

        final Bundle parametros = getIntent().getExtras();
        ordenMascota = parametros.getIntegerArrayList("mascotas");

        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvDetalleMascotas = (RecyclerView) findViewById(R.id.rvDetalleMascotas);
        LinearLayoutManager llmDetalle = new LinearLayoutManager(this);
        llmDetalle.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetalleMascotas.setLayoutManager(llmDetalle);

        //RecyclerWiew
        listaDetalleMascota = new ArrayList<DatosMascota>();

        listaDetalleMascota.add(new DatosMascota("Perro", String.valueOf(ordenMascota.get(0)), R.drawable.bulldog));
        listaDetalleMascota.add(new DatosMascota("Cerdo", String.valueOf(ordenMascota.get(1)), R.drawable.pig));
        listaDetalleMascota.add(new DatosMascota("Oveja", String.valueOf(ordenMascota.get(2)), R.drawable.sheep));
        listaDetalleMascota.add(new DatosMascota("Gato", String.valueOf(ordenMascota.get(3)), R.drawable.cat));
        listaDetalleMascota.add(new DatosMascota("Gallina", String.valueOf(ordenMascota.get(4)), R.drawable.hen));

        Collections.sort(listaDetalleMascota, new Comparator<DatosMascota>() {
            @Override
            public int compare(DatosMascota m1, DatosMascota m2) {
                return new Integer(m2.getRatingMascota()).compareTo(new Integer(m1.getRatingMascota()));
            }
        });

        //Inicia el adapter
        MascotaAdapter adaptador = new MascotaAdapter(listaDetalleMascota);
        rvDetalleMascotas.setAdapter(adaptador);
    }
}
