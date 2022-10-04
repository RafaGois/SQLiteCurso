package com.example.sqlitecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navegaAddActivity (View view){
        Intent intent = new Intent(this,Adicao.class);
        startActivity(intent);
    }

    public void navegaGraficosActivity (View view){
        Intent intent = new Intent(this,Graficos.class);
        startActivity(intent);
    }
}