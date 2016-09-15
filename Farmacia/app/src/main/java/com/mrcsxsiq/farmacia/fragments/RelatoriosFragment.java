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
import com.mrcsxsiq.farmacia.adapter.RelatorioRecyclerViewAdapter;
import com.mrcsxsiq.farmacia.domain.Produto;
import com.mrcsxsiq.farmacia.domain.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class RelatoriosFragment extends Fragment {

    private RelatorioRecyclerViewAdapter relatorioRecyclerViewAdapte;
    private RecyclerView recyclerView;

    public RelatoriosFragment() {
    }

    public static RelatoriosFragment newInstance() {
        RelatoriosFragment fragment = new RelatoriosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relatorios, container, false);

        relatorioRecyclerViewAdapte = new RelatorioRecyclerViewAdapter(getActivity(), getList());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(relatorioRecyclerViewAdapte);

        return view;
    }

    public List<Relatorio> getList(){
        List<Relatorio> list = new ArrayList<>();
        list.add(new Relatorio());
        return list;
    }

}