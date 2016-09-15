package com.mrcsxsiq.farmacia.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrcsxsiq.farmacia.DetalhesActivity;
import com.mrcsxsiq.farmacia.R;
import com.mrcsxsiq.farmacia.domain.Cliente;
import com.mrcsxsiq.farmacia.domain.Produto;

import java.util.List;

public class ClienteRecyclerViewAdapter extends RecyclerView.Adapter<ClienteRecyclerViewAdapter.ItemViewHolder>  {

    private List<Cliente> list;
    private Activity mActivity;
    private LayoutInflater mLayoutInflater;

    public ClienteRecyclerViewAdapter(Activity activity, List<Cliente> list) {
        this.mActivity = activity;
        this.list = list;
        this.mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_cliente, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int position) {

        itemViewHolder.textViewNome.setText(list.get(position).getNome());
        itemViewHolder.textViewRG.setText("RG: "+list.get(position).getRg());
        itemViewHolder.textViewCPF.setText("CPF: "+list.get(position).getCpf());
        itemViewHolder.textViewNascimento.setText(list.get(position).getNascimento());

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, DetalhesActivity.class);
                intent.putExtra("TIPO", 1);
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
        public TextView textViewRG;
        public TextView textViewCPF;
        public TextView textViewNascimento;

        public ImageView imageView;

        public ItemViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textViewNome = (TextView) view.findViewById(R.id.textView1);
            textViewRG = (TextView) view.findViewById(R.id.textView2);
            textViewCPF = (TextView) view.findViewById(R.id.textView3);
            textViewNascimento = (TextView) view.findViewById(R.id.textView4);

        }

    }
}
