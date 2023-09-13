package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edAltura;
    private EditText edPeso;
    private Button btHomem;
    private Button btMulher;
    private TextView tvRetorno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Iniciando os campos e instanciando pelos id*/
        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);
        btHomem = findViewById(R.id.btHomem);
        btMulher = findViewById(R.id.btMulher);
        tvRetorno = findViewById(R.id.tvRetorno);

        btMulher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularImc(1);
            }
        });

        btHomem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularImc(2);
            }
        });
    }

    private void calcularImc(int tipo) {
        double imc;
        Double peso, altura;
        peso = Double.parseDouble(edPeso.getText().toString());
        altura = Double.parseDouble(edAltura.getText().toString());

        imc = peso / (altura * altura);

        exibirImc(imc);
    }

    private void exibirImc(double imc){
        if (imc <= 18.5) {
            tvRetorno.setText("IMC: " +imc+ " - Magreza") ;
        } else if (imc > 18.5 && imc <= 24.9) {
            tvRetorno.setText("IMC: " +imc+ " - Peso normal") ;
        } else if (imc > 24.9 && imc <= 29.9) {
            tvRetorno.setText("IMC: " +imc+ " - Sobrepeso") ;
        } else if (imc > 30 && imc <= 34.9) {
            tvRetorno.setText("IMC: " +imc+ " - Obesidade grau I") ;
        } else if (imc > 35 && imc <= 40) {
            tvRetorno.setText("IMC: " + imc + " - Obesidade grau II");
        } else {
            tvRetorno.setText("IMC: " + imc + " - Obesidade grau III");
        }
    }
}