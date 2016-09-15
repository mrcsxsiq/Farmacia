package com.mrcsxsiq.farmacia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrcsxsiq.farmacia.R;
import com.mrcsxsiq.farmacia.adapter.ClienteRecyclerViewAdapter;
import com.mrcsxsiq.farmacia.adapter.ProdutoRecyclerViewAdapter;
import com.mrcsxsiq.farmacia.domain.Cliente;
import com.mrcsxsiq.farmacia.domain.Produto;

import java.util.ArrayList;
import java.util.List;


public class ClientesFragment extends Fragment {

    private ClienteRecyclerViewAdapter clienteRecyclerViewAdapter;
    private RecyclerView recyclerView;

    public ClientesFragment() {
    }

    public static ClientesFragment newInstance() {
        ClientesFragment fragment = new ClientesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clientes, container, false);

        clienteRecyclerViewAdapter = new ClienteRecyclerViewAdapter(getActivity(), getList());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(clienteRecyclerViewAdapter);

        return view;
    }

    public List<Cliente> getList(){
        List<Cliente> list = new ArrayList<>();
        list.add(new Cliente("Tyller Jor'el", "11/08/1996", "2314138", "000.123.123-99", "Um lugar qualquer bem ali"));
        list.add(new Cliente("Jó de Oliveira Vidal", "21/10/1983", "129104-4", "789.123.413.91", "Rua Azenor Two Fly, n1, Centro de Galáxias, Manaus - AM"));
        list.add(new Cliente("nome 2", "nascimento 2", "rg 2", "cpf 2", "endereco 2"));
        list.add(new Cliente("nome 3", "nascimento 3", "rg 3", "cpf 3", "endereco 3"));
        list.add(new Cliente("nome 4", "nascimento 4", "rg 4", "cpf 4", "endereco 4"));
        return list;
    }

}