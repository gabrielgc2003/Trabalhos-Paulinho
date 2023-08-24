package com.example.exercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edInvestimentoInicial;
    private EditText edTaxaJuro;
    private EditText edPeriodo;
    private Button btCalcular;
    private TextView tvMontante;
    private TextView tvJuros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edInvestimentoInicial = findViewById(R.id.edInvestimentoInicial);
        edTaxaJuro = findViewById(R.id.edTaxaJuro);
        edPeriodo = findViewById(R.id.edPeriodo);
        btCalcular = findViewById(R.id.btCalcular);
        tvMontante = findViewById(R.id.tvMontante);
        tvJuros = findViewById(R.id.tvJuros);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularJuro();
            }
        });
    }
    private void calcularJuro() {
       // M = C ( 1+i)t Math.pow(2,9); //2^9
        double montante, juro;
        double investimento = Double.parseDouble(edInvestimentoInicial.getText().toString());
        double periodo = Double.parseDouble(edPeriodo.getText().toString());
        double taxa = Double.parseDouble(edTaxaJuro.getText().toString()) / 100;
        montante = investimento * Math.pow((1+taxa), periodo);
        juro = montante - investimento;

        tvMontante.setText("Montante final: "+ montante);
        tvJuros.setText("Valor de Juros Composto: "+ juro);
    }
}