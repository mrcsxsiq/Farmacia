package com.mrcsxsiq.farmacia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mrcsxsiq.farmacia.fragments.BlankFragment;
import com.mrcsxsiq.farmacia.fragments.ClientesDetalhesFragment;
import com.mrcsxsiq.farmacia.fragments.ClientesFragment;
import com.mrcsxsiq.farmacia.fragments.ProdutosDetalhesFragment;
import com.mrcsxsiq.farmacia.fragments.ProdutosFragment;
import com.mrcsxsiq.farmacia.fragments.RelatoriosFragment;
import com.mrcsxsiq.farmacia.fragments.VisaoGeralFragment;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int tipo = 0;
        try {
            tipo = getIntent().getExtras().getInt("TIPO", 0);
        } catch (Exception e) {}
        setFragment(tipo);
    }

    public void setFragment(int tipo) {

        Fragment fragment = new BlankFragment().newInstance();

        if (tipo == 1){
            fragment = new ClientesDetalhesFragment().newInstance();
            setTitle("Detalhes Cliente");
        } else if (tipo == 2){
            fragment = new ProdutosDetalhesFragment().newInstance();
            setTitle("Detalhes Produto");
        } else {
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .commit();
    }
}
