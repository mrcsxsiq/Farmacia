package com.mrcsxsiq.farmacia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrcsxsiq.farmacia.R;
import com.mrcsxsiq.farmacia.adapter.ProdutoRecyclerViewAdapter;
import com.mrcsxsiq.farmacia.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class VisaoGeralFragment extends Fragment {


    public VisaoGeralFragment() {
    }

    public static VisaoGeralFragment newInstance() {
        VisaoGeralFragment fragment = new VisaoGeralFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visao_geral, container, false);
        return view;
    }

}