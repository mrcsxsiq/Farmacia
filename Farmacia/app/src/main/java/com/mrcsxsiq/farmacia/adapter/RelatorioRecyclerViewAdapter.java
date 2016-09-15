package com.mrcsxsiq.farmacia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mrcsxsiq.farmacia.R;
import com.mrcsxsiq.farmacia.domain.Produto;
import com.mrcsxsiq.farmacia.domain.Relatorio;

import java.util.List;

public class RelatorioRecyclerViewAdapter extends RecyclerView.Adapter<RelatorioRecyclerViewAdapter.ItemViewHolder>  {

    private List<Relatorio> list;
    private Activity mActivity;
    private LayoutInflater mLayoutInflater;

    public RelatorioRecyclerViewAdapter(Activity activity, List<Relatorio> list) {
        this.mActivity = activity;
        this.list = list;
        this.mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_relatorio, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int position) {

     //   itemViewHolder.textViewNomeArquivo.setText(listArquivos.get(position).getNome());
       // itemViewHolder.textViewTamanho.setText(listArquivos.get(position).getTamanho());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View view) {
            super(view);
        }

    }
}
