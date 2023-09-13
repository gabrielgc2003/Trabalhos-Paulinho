package com.example.exercicio2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edRendaBruta;
    private EditText edDependente;
    private EditText edTotalDeducao;
    private Button btCalcular;
    private TextView tvRendaBruta;
    private TextView tvBaseCalculo;
    private TextView tvImposto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edRendaBruta = findViewById(R.id.edRendaBruta);
        edDependente = findViewById(R.id.edDependente);
        edTotalDeducao = findViewById(R.id.edTotalDeducao);
        btCalcular = findViewById(R.id.btCalcular);
        tvRendaBruta = findViewById(R.id.tvRendaBruta);
        tvBaseCalculo = findViewById(R.id.tvBaseCalculo);
        tvImposto = findViewById(R.id.tvImposto);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularIr();
            }
        });

    }
    private void calcularIr() {
        double rendaBrutaAnual;
        double rendaDependentes;
        double baseCalculo;
        double valorCalculoImposto;
        double valorImposto = 0;
        double rendaBruta = Double.parseDouble(edRendaBruta.getText().toString());
        int dependente = Integer.parseInt(edDependente.getText().toString());
        double totalDeducao = Double.parseDouble(edTotalDeducao.getText().toString());

        rendaBrutaAnual = rendaBruta * 12;
        rendaDependentes = (double) (dependente * 300 * 12);
        baseCalculo = rendaBrutaAnual - rendaDependentes - totalDeducao;

         if (baseCalculo >= 18000.01 && baseCalculo <= 27000.0) {
            valorCalculoImposto = baseCalculo - 18000.0;
            valorImposto = valorCalculoImposto * 0.15;
        }else{
            valorCalculoImposto = baseCalculo - 27000.0;
            valorImposto = 1350.0 + (valorCalculoImposto * 0.275);
        }
        tvRendaBruta.setText("Renda Bruta Anual: "+ rendaBrutaAnual);
        tvBaseCalculo.setText("Base de cálculo: "+ baseCalculo);
        tvImposto.setText("Imposto Devido: "+ valorImposto);
    }

}