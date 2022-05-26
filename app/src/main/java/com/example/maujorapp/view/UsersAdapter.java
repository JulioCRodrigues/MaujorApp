package com.example.maujorapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maujorapp.R;
import com.example.maujorapp.model.domain.Users;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<Users> users;

    public UsersAdapter(List<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_adapter, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Users user = users.get(position);
        Context context = holder.itemView.getContext();

        // compara os valores para organizar os itens em ordem crescente
        Comparator<Users> UsersPoints = new Comparator<Users>(){

            @Override
            public int compare(Users p1, Users p2) {
                return p2.getPoints() - p1.getPoints();
            }
        };

        int points = user.getPoints();

        if(points != 0){
            Collections.sort(users, UsersPoints);
            holder.points.setText(String.valueOf(user.getPoints()));
        }
        holder.name.setText(user.getName());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView name;
        TextView points;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNameUser);
            points = itemView.findViewById(R.id.tvPoints);

        }
    }
}
