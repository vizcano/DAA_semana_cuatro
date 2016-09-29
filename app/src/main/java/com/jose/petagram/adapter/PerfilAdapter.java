package com.jose.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jose.petagram.R;
import com.jose.petagram.datos.PerfilMascota;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>{

    ArrayList<PerfilMascota> perfilMascota;

    public PerfilAdapter(ArrayList<PerfilMascota> perfilMascota) {
        this.perfilMascota = perfilMascota;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);

        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final PerfilMascota fotoMascota = perfilMascota.get(position);

        holder.imgFotoMascota.setImageResource(fotoMascota.getFotoMascota());
        holder.txtRatingFoto.setText(fotoMascota.getRatingMascota());
    }

    @Override
    public int getItemCount() {
        return perfilMascota.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascota;
        private TextView txtRatingFoto;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            txtRatingFoto = (TextView) itemView.findViewById(R.id.txtRatingFoto);
        }
    }
}
