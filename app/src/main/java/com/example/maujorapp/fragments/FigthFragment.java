package com.example.maujorapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maujorapp.R;
import com.example.maujorapp.databinding.FragmentFigthBinding;


public class FigthFragment extends Fragment {

    FragmentFigthBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFigthBinding.inflate(inflater, container, false);

        setupListUsers();

        return binding.getRoot();
    }

    private void setupListUsers() {
        // TODO listar os usuários da API 
    }
}