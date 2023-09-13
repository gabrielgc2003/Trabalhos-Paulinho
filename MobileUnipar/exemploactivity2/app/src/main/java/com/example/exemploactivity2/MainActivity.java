package com.example.exemploactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exemploactivity2.modelo.Aluno;

public class MainActivity extends AppCompatActivity {
    private Button btCadastraAluno;
    private Button btCadastroProfessor;
    private Button btCadastroDisciplina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastraAluno = findViewById(R.id.btCadastroAluno);
        btCadastroProfessor = findViewById(R.id.btCadastroProfessor);
        btCadastroDisciplina = findViewById(R.id.btCadastroDisciplina);

        btCadastraAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });

        btCadastroProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroProfessor();
            }
        });
        btCadastroDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroDisciplina();
            }
        });
    }

    private void abrirCadastroAluno() {
        Intent intent = new Intent(MainActivity.this, CadastroAlunoActivity.class);
        startActivity(intent);
    }
    private void abrirCadastroProfessor() {
        Intent intent = new Intent(MainActivity.this, CadastroProfessorActivity.class);
        startActivity(intent);
    }
    private void abrirCadastroDisciplina() {
        Intent intent = new Intent(MainActivity.this, CadastroDisciplinaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}