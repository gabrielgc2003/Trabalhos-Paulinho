package com.example.exemploactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity2.modelo.Aluno;

public class CadastroAlunoActivity extends AppCompatActivity {
    private Button btSalvar;
    private EditText edRaAluno;
    private EditText edNomeAluno;
    private EditText edCpfAluno;
    private EditText edDtNascimento;
    private TextView tvAlunosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        btSalvar = findViewById(R.id.btSalvar);
        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
        edCpfAluno = findViewById(R.id.edCpfAluno);
        edDtNascimento = findViewById(R.id.edDtNascimento);
        tvAlunosCadastrados = findViewById(R.id.tvAlunosCadastrados);
        atualizarListaAlunos();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });
    }

    private void salvarAluno() {
        if(edRaAluno.getText().toString().isEmpty()){
            edRaAluno.setError("Informe o RA do aluno");
            return;
        }
        if (edNomeAluno.getText().toString().isEmpty()){
            edNomeAluno.setError("Informe o Nome do aluno");
            return;
        }
        if (edCpfAluno.getText().toString().isEmpty()){
            edCpfAluno.setError("Informe o cpf do aluno");
            return;
        }
        if (edDtNascimento.getText().toString().isEmpty()){
            edDtNascimento.setError("Informe a data de nascimento do aluno");
            return;
        }
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRaAluno.getText().toString()));
        aluno.setNome(edNomeAluno.getText().toString());
        aluno.setCpf(edCpfAluno.getText().toString());
        aluno.setDtNascimento(edDtNascimento.getText().toString());

        Controller.getInstance().salvarAluno(aluno);
        Toast.makeText(CadastroAlunoActivity.this,
                "Aluno Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();
        this.finish();

    }
    private void atualizarListaAlunos(){
        String texto = "";
        for (Aluno aluno:
                Controller.getInstance().retornarAlunos()) {
            texto += "RA:" +  aluno.getRa() + " - NOME:"+aluno.getNome() + "\nCPF:"+ aluno.getCpf()+ " - Dt. Nasc.:" + aluno.getDtNascimento()  +  "\n\n";
        }
        tvAlunosCadastrados.setText(texto);
    }

}