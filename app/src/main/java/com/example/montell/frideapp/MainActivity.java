package com.example.montell.frideapp;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    DatabaseHelper myDB;
public Button btnAddscrn;
    public Button btnUpdate;
    public Button btnShowscrn;

    public void addScrn(){
        btnAddscrn = (Button)findViewById(R.id.btnAddscrn);
        btnAddscrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add = new Intent(MainActivity.this,Additem.class);
                startActivity(add);
            }
        });

    }
    public void editScrn(){
        btnUpdate = (Button)findViewById(R.id.btnAddscrn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent edit = new Intent(MainActivity.this,Updateitem.class);
                startActivity(edit);
            }
        });

    }


    public void viewAll(){

        btnShowscrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor result =myDB.getAllDate();
                if (result.getCount()==0) {
                    showmessage("Eroor","Nothing in the fridge");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("Id :"+result.getString(0)+"\n");
                    buffer.append("name :"+result.getString(1)+"\n");
                    buffer.append("description :"+result.getString(2)+"\n");
                    buffer.append("date :"+result.getString(3)+"\n");
                    buffer.append("cost :"+result.getString(4)+"\n");
                    buffer.append("quantity :"+result.getString(5)+"\n");
                }
                showmessage("Data",buffer.toString());
                }


        });

    }
   public void showmessage(String title,String Message) {

       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setCancelable(true);
       builder.setTitle(title);
       builder.setMessage(Message);
       builder.show();
   }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        addScrn();
        viewAll();
        editScrn();
    }






}

