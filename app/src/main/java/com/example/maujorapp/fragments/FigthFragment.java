package com.example.maujorapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.maujorapp.databinding.FragmentFigthBinding;
import com.example.maujorapp.model.domain.Users;
import com.example.maujorapp.model.domain.UsersAPI;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FigthFragment extends Fragment {

    FragmentFigthBinding binding;
    private UsersAPI usersAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFigthBinding.inflate(inflater, container, false);

        initRetrofit();
        setupListUsers();


        return binding.getRoot();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://juliocrodrigues.github.io/maujor-app-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

      usersAPI =  retrofit.create(UsersAPI.class);
    }

    private void setupListUsers() {
        usersAPI.getData().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(response.isSuccessful()){
                    List<Users> users = response.body();
                    Log.i("Deu certo!", "Deu certo " + users.size());
                } else {
                    Snackbar.make(binding.getRoot(), "Erro de conexão!", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Snackbar.make(binding.getRoot(), "Erro de conexão!", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}