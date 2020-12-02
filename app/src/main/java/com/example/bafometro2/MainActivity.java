package com.example.bafometro2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String status = "";
    public String returnAlcool = "";
    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.d("asfadfaa","asfdfa");
            Intent relato = getIntent();
            Bundle dados = relato.getExtras();

            Double coeficient = 0.0;
            String sexo = dados.getString("sexo");
            String jejum = dados.getString("jejum");
            if(jejum.equals("s")){
                if (sexo.equals("m"))
                    coeficient = 0.7;
                else coeficient = 0.6;
            }
            else coeficient = 1.1;

            double alcool = Double.parseDouble(dados.getString("copos"))*4.8/(Double.parseDouble(dados.getString("peso"))*coeficient);
            returnAlcool = String.valueOf(alcool);

            if (alcool > 0.2) status = "Pessoa Alcoolizada";
            else status = "Pessoa NÃO Alcoolizada";
        }

        public void CalculaAlcool(View v) {
            Intent relato = new Intent("ACAO");
            relato.addCategory("Custom");
            Bundle dados = new Bundle();

            dados.putString("alcool",returnAlcool);
            dados.putString("status",status);
            Log.d("retorno", returnAlcool + "  " + status);
            relato.putExtras(dados);
            setResult(1, relato);
            finish();
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

}
