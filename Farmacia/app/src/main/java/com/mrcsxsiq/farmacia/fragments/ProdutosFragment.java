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

public class ProdutosFragment extends Fragment {

    private ProdutoRecyclerViewAdapter produtoRecyclerViewAdapter;
    private RecyclerView recyclerView;

    public ProdutosFragment() {
    }

    public static ProdutosFragment newInstance() {
        ProdutosFragment fragment = new ProdutosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        produtoRecyclerViewAdapter = new ProdutoRecyclerViewAdapter(getActivity(), getList());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(produtoRecyclerViewAdapter);

        return view;
    }

    public List<Produto> getList(){
        List<Produto> list = new ArrayList<>();
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        list.add(new Produto("Nome", "Descricao", "Bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula bula"));
        return list;
    }

}