package com.example.exemploactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity2.modelo.Aluno;
import com.example.exemploactivity2.modelo.Professor;

public class CadastroProfessorActivity extends AppCompatActivity {
    private Button btSalvar;
    private EditText edMatricula;
    private EditText edNomeProfessor;
    private EditText edCpfProfessor;
    private EditText edDtNascimento;
    private EditText edDtAdmissao;
    private TextView tvProfessoresCadastrados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);
        btSalvar = findViewById(R.id.btSalvar);
        edMatricula = findViewById(R.id.edMatricula);
        edNomeProfessor = findViewById(R.id.edNomeProfessor);
        edCpfProfessor = findViewById(R.id.edCpfProfessor);
        edDtNascimento = findViewById(R.id.edDtNascimento);
        edDtAdmissao = findViewById(R.id.edDtAdmissao);
        tvProfessoresCadastrados = findViewById(R.id.tvProfessoresCadastrados);
        atualizarListaProfessores();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProfessor();
            }
        });

    }
    private void salvarProfessor() {
        if(edMatricula.getText().toString().isEmpty()){
            edMatricula.setError("Informe a matrícula do professor");
            return;
        }
        if(edNomeProfessor.getText().toString().isEmpty()){
            edNomeProfessor.setError("Informe o nome do professor");
            return;
        }
        if(edCpfProfessor.getText().toString().isEmpty()){
            edCpfProfessor.setError("Informe o cpf do professor");
            return;
        }
        if(edDtNascimento.getText().toString().isEmpty()){
            edDtNascimento.setError("Informe a data de nascimento do professor");
            return;
        }
        if(edDtAdmissao.getText().toString().isEmpty()){
            edDtAdmissao.setError("Informe a data de admissão do professor");
            return;
        }

        Professor professor = new Professor();
        professor.setMatricula(Integer.parseInt(edMatricula.getText().toString()));
        professor.setNome(edNomeProfessor.getText().toString());
        professor.setCpf(edCpfProfessor.getText().toString());
        professor.setDtNascimento(edDtNascimento.getText().toString());
        professor.setDtAdmissao(edDtAdmissao.getText().toString());

        Controller.getInstance().salvarProfessor(professor);
        Toast.makeText(CadastroProfessorActivity.this,
                "Professor Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();
        this.finish();

    }
    private void atualizarListaProfessores(){
        String texto = "";
        for (Professor professor:
                Controller.getInstance().retornarProfessores()) {
            texto += "Matricula:" +  professor.getMatricula() + " - Nome:"+professor.getNome() + "\nCPF:"+ professor.getCpf()+ " - Dt. Nasc.:" + professor.getDtNascimento() +" - Dt. Admis.:" + professor.getDtAdmissao() +  "\n\n";
        }
        tvProfessoresCadastrados.setText(texto);
    }
}