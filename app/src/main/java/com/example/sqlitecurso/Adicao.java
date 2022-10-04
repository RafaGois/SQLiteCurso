package com.example.sqlitecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Adicao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicao);

        criaOuIniciaTable();
        buscaDados();
    }

    public void adicionarValor (View view) {
        SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);

        EditText editText = findViewById(R.id.inputText);

        banco.execSQL("INSERT INTO pessoas2(nome, idade) VALUES ('"+editText.getText().toString()+"',10)");

        buscaDados();

        editText.setText("");
    }

    private void criaOuIniciaTable () {
        SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);

        try {
            banco.execSQL("CREATE TABLE IF NOT EXISTS pessoas2 (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscaDados () {
        try {
            SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);

            String consulta = "SELECT id,nome,idade FROM pessoas2";
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

    private void removeValor (int index) {
        SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);
        banco.execSQL("DELETE FROM pessoas2 WHERE id = "+ index);
    }

    private void atualizaValor () {
        //atualizando registro
            /*
            String update = "UPDATE pessoas2 set idade = 14 WHERE nome = 'Matheus'";
            banco.execSQL(update);
            */
    }

    public void volta (View view) {
        finish();
    }
}