package com.example.montell.frideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Additem extends AppCompatActivity {
    EditText addNametext, addDesctext, addexpdatetext, addCosttext, addTotaltext;
    Button addItembtn;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        myDB = new DatabaseHelper(this);

        addNametext = (EditText) findViewById(R.id.addNametext);
        addDesctext = (EditText) findViewById(R.id.addDesctext);
        addexpdatetext = (EditText) findViewById(R.id.addexpdatetext);
        addCosttext = (EditText) findViewById(R.id.addCosttext);
        addTotaltext = (EditText) findViewById(R.id.addTotaltext);
        addItembtn = (Button) findViewById(R.id.addItembtn);

    }

    public void Adddata() {
        addItembtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted =  myDB.insertDate(addNametext.getText().toString(),addDesctext.getText().toString(),addexpdatetext.getText().toString(),addCosttext.getText().toString(),addTotaltext.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(Additem.this,"Item added to fridge",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Additem.this,"Item not added to fridge",Toast.LENGTH_LONG).show();

                    }
                }

        );
    }
}
