package com.example.maujorapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashViewHolder> {

    private List<DashboardComponents> listaComponentes;
    public DashboardAdapter(List<DashboardComponents> lista) {
        this.listaComponentes = lista;
    }

    public class DashViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        ImageView background;

        public DashViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtForum);
            background = itemView.findViewById(R.id.viewBack);
        }
    }

    @NonNull
    @Override
    public DashViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // buscando o item da lista que foi criada no adapter
        View itemDashboard = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_adapter, parent, false);

        // criando os itens do recycler
        return new DashViewHolder(itemDashboard);
    }

    @Override
    public void onBindViewHolder(@NonNull DashViewHolder holder, int position) {
        DashboardComponents componentes = listaComponentes.get(position);
        holder.titulo.setText(componentes.getTitulo());

    }

    @Override
    public int getItemCount() {
        return listaComponentes.size();
    }


}
