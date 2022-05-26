package com.example.maujorapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.maujorapp.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.btnEntrar.setOnClickListener(view1 -> {
            Intent intent = new Intent(getApplicationContext(), DashBoard.class);
            startActivity(intent);
        });

        binding.criejaText.setOnClickListener(view12 -> {
            binding.criejaText.setClickable(true);
            Intent intent = new Intent(getApplicationContext(), FormLogin.class);
            startActivity(intent);
        });

    }
}