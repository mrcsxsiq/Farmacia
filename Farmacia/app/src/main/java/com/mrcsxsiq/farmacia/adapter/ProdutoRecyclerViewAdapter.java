package com.mrcsxsiq.farmacia.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrcsxsiq.farmacia.DetalhesActivity;
import com.mrcsxsiq.farmacia.R;
import com.mrcsxsiq.farmacia.domain.Produto;

import java.util.List;

public class ProdutoRecyclerViewAdapter extends RecyclerView.Adapter<ProdutoRecyclerViewAdapter.ItemViewHolder>  {

    private List<Produto> list;
    private Activity mActivity;
    private LayoutInflater mLayoutInflater;

    public ProdutoRecyclerViewAdapter(Activity activity, List<Produto> list) {
        this.mActivity = activity;
        this.list = list;
        this.mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_produto, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int position) {

        itemViewHolder.textViewNome.setText(list.get(position).getNome());
        itemViewHolder.textViewDescricao.setText(list.get(position).getDescricacao());
        itemViewHolder.textViewBula.setText(list.get(position).getBula());

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, DetalhesActivity.class);
                intent.putExtra("TIPO", 2);
                mActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNome;
        public TextView textViewDescricao;
        public TextView textViewBula;

        public ImageView imageView;

        public ItemViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textViewNome = (TextView) view.findViewById(R.id.textView1);
            textViewDescricao = (TextView) view.findViewById(R.id.textView2);
            textViewBula = (TextView) view.findViewById(R.id.textView3);

        }

    }
}
