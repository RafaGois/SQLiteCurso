package com.example.sqlitecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //criando banco de dados
            SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);
            //criando tabela
            banco.execSQL("CREATE TABLE IF NOT EXISTS pessoas2 (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");

            //inserindo valores no banco

            //String  delete = "DELETE FROM pessoas2";
            //banco.execSQL(delete);

            /*
            banco.execSQL("INSERT INTO pessoas2(nome, idade) VALUES ('Rafael',20)");
            banco.execSQL("INSERT INTO pessoas2(nome, idade) VALUES ('Matheus',25)");
            banco.execSQL("INSERT INTO pessoas2(nome, idade) VALUES ('Alexandre',26)");
            */

            //atualizando registro
            /*
            String update = "UPDATE pessoas2 set idade = 14 WHERE nome = 'Matheus'";
            banco.execSQL(update);
            */


            //recuperando valores do banco de dados
            String consulta = "SELECT id,nome,idade FROM   pessoas2";
            Cursor cursor = banco.rawQuery(consulta,null);

            //retornando o index das colunas com base nos nomes
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            //retorna tdos os registros que esnotrar na tabela

            //sempre que for ler novamente volta para o primeiro para que seja feita a leitura (volta para a primeira linha)
            cursor.moveToFirst();
            while (cursor != null) {
                //imprimindo os resultados
                Log.i("RESULTADO - ",cursor.getString(indiceId)+" / "+cursor.getString(indiceNome)+ " / " +cursor.getString(indiceIdade));
                //avanca para a prixima linha
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}