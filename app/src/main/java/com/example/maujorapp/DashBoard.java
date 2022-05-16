package com.example.maujorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.example.maujorapp.databinding.ActivityDashBoardBinding;
import com.google.android.material.badge.BadgeDrawable;

import java.util.ArrayList;
import java.util.List;

public class DashBoard extends AppCompatActivity {

    private ActivityDashBoardBinding binding;
    private RecyclerView recyclerView;
    private List<DashboardComponents> listaComponentes = new ArrayList<>();
    private NavHostFragment navHostFragment;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        // chamando criação dos componentes
        this.criarComponente();

        // configurando recyclerView
        recyclerView = binding.recyclerDash;

        // configurando o adapter
        DashboardAdapter adapter = new DashboardAdapter(listaComponentes);

        // layout menager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        // adapter
        recyclerView.setAdapter(adapter);

        // iniciando a navegação
        this.initNavigation();
        this.initBadge();   // icons de notificação

    }

    // criando componentes para o Dashboard
    public void criarComponente(){
        DashboardComponents forum = new DashboardComponents("Fórum");
        this.listaComponentes.add(forum);

        DashboardComponents artigos = new DashboardComponents("Artigos");
        this.listaComponentes.add(artigos);

        DashboardComponents novidades = new DashboardComponents("Novidades");
        this.listaComponentes.add(novidades);

        DashboardComponents duelos = new DashboardComponents("Duelos");
        this.listaComponentes.add(duelos);

    }

    public void initNavigation(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

    public void initBadge(){
        BadgeDrawable badge = binding.bottomNavigation.getOrCreateBadge(R.id.menu_notificacoes);
        badge.setVisible(true);
        badge.setNumber(10);
    }
}