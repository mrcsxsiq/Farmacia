package com.mrcsxsiq.farmacia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrcsxsiq.farmacia.R;


public class ProdutosDetalhesFragment extends Fragment {

    public ProdutosDetalhesFragment() {
    }

    public static ProdutosDetalhesFragment newInstance() {
        ProdutosDetalhesFragment fragment = new ProdutosDetalhesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produtos_detalhes, container, false);
        return view;
    }

}