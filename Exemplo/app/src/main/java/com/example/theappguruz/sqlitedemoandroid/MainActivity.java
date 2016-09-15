package com.example.theappguruz.sqlitedemoandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    Button btnAddNewRecord;
    SQLiteHelper sQLiteHelper;

    android.widget.LinearLayout parentLayout;
    LinearLayout layoutDisplayRemedios;

    TextView tvNenhumRegistroFoiEncontrado;
    private String rowID = null;

    private ArrayList<HashMap<String, String>> tableData = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllWidgets();
        sQLiteHelper = new SQLiteHelper(MainActivity.this);
        bindWidgetsWithEvent();
        displayAllRecords();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String nome = data.getStringExtra(Constants.NOME);
            String preco = data.getStringExtra(Constants.PRECO);

            ContactModel contact = new ContactModel();
            contact.setNome(nome);
            contact.setPreco(preco);

            if (requestCode == Constants.ADD_RECORD) {
                //sQLiteHelper.insertRecord(nome, preco);
                sQLiteHelper.insertRecord(contact);
            } else if (requestCode == Constants.UPDATE_RECORD) {
                contact.setID(rowID);
                //sQLiteHelper.updateRecord(nome, preco, rowID);
                sQLiteHelper.updateRecord(contact);
            }
            displayAllRecords();
        }
    }


    private void getAllWidgets() {
        btnAddNewRecord = (Button) findViewById(R.id.btnAddNewRecord);

        parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        layoutDisplayRemedios = (LinearLayout) findViewById(R.id.layoutDisplayRemedios);

        tvNenhumRegistroFoiEncontrado = (TextView) findViewById(R.id.tvNenhumRegistroFoiEncontrado);
    }

    private void bindWidgetsWithEvent() {
        btnAddNewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddRecord();
            }
        });
    }

    private void onAddRecord() {
        Intent intent = new Intent(MainActivity.this, TableManipulationActivity.class);
        intent.putExtra(Constants.DML_TYPE, Constants.INSERT);
        startActivityForResult(intent, Constants.ADD_RECORD);
    }

    private void onUpdateRecord(String firstname, String lastname) {
        Intent intent = new Intent(MainActivity.this, TableManipulationActivity.class);
        intent.putExtra(Constants.NOME, firstname);
        intent.putExtra(Constants.PRECO, lastname);
        intent.putExtra(Constants.DML_TYPE, Constants.UPDATE);
        startActivityForResult(intent, Constants.UPDATE_RECORD);
    }


    private void displayAllRecords() {

        com.rey.material.widget.LinearLayout inflateParentView;
        parentLayout.removeAllViews();

        ArrayList<ContactModel> contacts = sQLiteHelper.getAllRecords();

        if (contacts.size() > 0) {
            tvNenhumRegistroFoiEncontrado.setVisibility(View.GONE);
            ContactModel contactModel;
            for (int i = 0; i < contacts.size(); i++) {

                contactModel = contacts.get(i);

                final Holder holder = new Holder();
                final View view = LayoutInflater.from(this).inflate(R.layout.inflate_record, null);
                inflateParentView = (com.rey.material.widget.LinearLayout) view.findViewById(R.id.inflateParentView);
                holder.tvFullName = (TextView) view.findViewById(R.id.tvFullName);


                view.setTag(contactModel.getID());
                holder.nome = contactModel.getNome();
                holder.preco = contactModel.getPreco();
                String personName = holder.nome + " " + holder.preco;
                holder.tvFullName.setText(personName);

                final CharSequence[] items = {Constants.UPDATE, Constants.DELETE};
                inflateParentView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {

                                    rowID = view.getTag().toString();
                                    onUpdateRecord(holder.nome, holder.preco.toString());
                                } else {
                                    AlertDialog.Builder deleteDialogOk = new AlertDialog.Builder(MainActivity.this);
                                    deleteDialogOk.setTitle("Delete Remédio?");
                                    deleteDialogOk.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //sQLiteHelper.deleteRecord(view.getTag().toString());
                                                    ContactModel contact = new ContactModel();
                                                    contact.setID(view.getTag().toString());
                                                    sQLiteHelper.deleteRecord(contact);
                                                    displayAllRecords();
                                                }
                                            }
                                    );
                                    deleteDialogOk.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                                    deleteDialogOk.show();
                                }
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return true;
                    }
                });
                parentLayout.addView(view);
            }
        } else {
            tvNenhumRegistroFoiEncontrado.setVisibility(View.VISIBLE);
        }
    }

    private class Holder {
        TextView tvFullName;
        String nome;
        String preco;
    }
}
