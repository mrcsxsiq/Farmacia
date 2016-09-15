package com.example.theappguruz.sqlitedemoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nikunj on 01-09-2015.
 */
public class TableManipulationActivity extends Activity {

    EditText etNome;
    EditText etPreco;

    Button btnDML;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_manipulation);
        getAllWidgets();
        bindWidgetsWithEvent();
        checkForRequest();
    }

    private void checkForRequest() {
        String request = getIntent().getExtras().get(Constants.DML_TYPE).toString();
        if (request.equals(Constants.UPDATE)) {
            btnDML.setText(Constants.UPDATE);
            etNome.setText(getIntent().getExtras().get(Constants.NOME).toString());
            etPreco.setText(getIntent().getExtras().get(Constants.PRECO).toString());
        } else {
            btnDML.setText(Constants.INSERT);
        }
    }

    private void bindWidgetsWithEvent() {
        btnDML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });
    }

    private void getAllWidgets() {
        etNome = (EditText) findViewById(R.id.etNome);
        etPreco = (EditText) findViewById(R.id.etPreco);

        btnDML = (Button) findViewById(R.id.btnDML);
    }

    private void onButtonClick() {
        if (etNome.getText().toString().equals("") || etPreco.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Add Both Fields", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(Constants.NOME, etNome.getText().toString());
            intent.putExtra(Constants.PRECO, etPreco.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
