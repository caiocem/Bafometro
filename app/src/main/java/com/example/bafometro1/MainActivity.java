package com.example.bafometro1;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart(){
        super.onStart();
        Log.d("Estado atual de ", getClass().getName() + "= .onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("Estado atual de ", getClass().getName() + "= .onResume");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("Estado atual de ", getClass().getName() + "= .onRestart");
    }

    protected void onPause(){
        super.onPause();
        Log.d("Estado atual de ", getClass().getName() + "= .onPause");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("Estado atual de ", getClass().getName() + "= .onDestroy");
    }

    public void GerarIntentBundle (View view) {
        EditText peso = (EditText) findViewById(R.id.editTextPeso);
        EditText sexo = (EditText) findViewById(R.id.editTextSexo);
        EditText copos = (EditText) findViewById(R.id.editTextCopos);
        EditText jejum = (EditText) findViewById(R.id.editTextJejum);

        boolean valido = (!peso.getText().toString().equals("") && !sexo.getText().toString().equals("") && !copos.getText().toString().equals("") && !jejum.getText().toString().equals("")&&Double.parseDouble(peso.getText().toString())>0);
        if (valido) {
            Intent relato = new Intent("acao");
            relato.addCategory("Custom");
            Bundle dados = new Bundle();

            dados.putString("peso",peso.getText().toString());
            dados.putString("sexo",sexo.getText().toString());
            dados.putString("copos",copos.getText().toString());
            dados.putString("jejum",jejum.getText().toString());

            relato.putExtras(dados);
            startActivityForResult(relato,10);
        } else {
            Log.d("faltando coisa", "soltar mensagem");
            Toast.makeText(this, "Dados Incompletos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            Toast.makeText(this, "Nenhum valor", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            String status = data.getStringExtra("status");
            String alcool = data.getStringExtra("alcool");
            Toast.makeText(this, "Taxa de Alcoolemia: "+ alcool + '\n' + "Classificação: "+ status , Toast.LENGTH_LONG).show();
        }
//        String status = data.getStringExtra("status");
//        String alcool = data.getStringExtra("alcool");
//        Log.d("TAG", alcool + "  " + status);
    }
}