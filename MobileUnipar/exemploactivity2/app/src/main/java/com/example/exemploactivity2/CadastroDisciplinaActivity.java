package com.example.exemploactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity2.modelo.Disciplina;
import com.example.exemploactivity2.modelo.Professor;

import java.util.ArrayList;

public class CadastroDisciplinaActivity extends AppCompatActivity {
    private EditText edDescricao;
    private EditText edCargaHoraria;
    private Spinner spProfessor;
    private TextView tvErroProfessor;
    private Button btSalvar;
    private TextView tvDisciplinasCadastradas;
    private ArrayList<Professor> listaProfessores;
    private int posicaoSelecionada = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);
        edDescricao = findViewById(R.id.edDescricao);
        edCargaHoraria = findViewById(R.id.edCargaHoraria);
        spProfessor = findViewById(R.id.spProfessor);
        tvErroProfessor = findViewById(R.id.tvErroProfessor);
        btSalvar = findViewById(R.id.btSalvar);
        tvDisciplinasCadastradas = findViewById(R.id.tvDisciplinasCadastradas);

        spProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0){
                    posicaoSelecionada = posicao;
                    tvErroProfessor.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDisciplina();
            }
        });
        carregaProfessores();
        atualizaListaDisciplinas();
    }
    private void carregaProfessores() {
        listaProfessores = Controller.getInstance().retornarProfessores();
        String[] vetProfs = new String[listaProfessores.size()+1];
        vetProfs[0] = "Selecione o professor";
        for (int i = 0; i < vetProfs.length; i++) {
            Professor prof = listaProfessores.get(i);
            vetProfs[i+1] = prof.getMatricula()+ " - " + prof.getNome();
        }
        ArrayAdapter adapter= new ArrayAdapter<>(
                CadastroDisciplinaActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetProfs);
        spProfessor.setAdapter(adapter);
    }
    private void salvarDisciplina() {
        double cargaHoraria;
        if (edDescricao.getText().toString().isEmpty()){
            edDescricao.setError("A descrição da disciplina deve ser informada!!");
            edDescricao.requestFocus();
            return;
        }
        if (edCargaHoraria.getText().toString().isEmpty()){
            edCargaHoraria.setError("A carga horaria da disciplina deve ser informada!!");
            edCargaHoraria.requestFocus();
            return;
        }
        if (edCargaHoraria.getText().toString().isEmpty()){
            edCargaHoraria.setError("A carga horaria da disciplina deve ser informada!!");
            edCargaHoraria.requestFocus();
            return;
        }else {
            cargaHoraria = Double.parseDouble(edCargaHoraria.getText().toString());
            if (cargaHoraria <= 0){
                edCargaHoraria.setError("A carga horaria deve ser maior que 0!!");
                edCargaHoraria.requestFocus();
                return;
            }
        }
        if (posicaoSelecionada <= 0){
            tvErroProfessor.setVisibility(View.VISIBLE);
            return;
        }

        Professor prof = listaProfessores.get(posicaoSelecionada-1);
        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao(edDescricao.getText().toString());
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setProfessor(prof);
        Controller.getInstance().salvarDisciplina(disciplina);
        Toast.makeText(this,
                "Disciplina salva com sucesso!",
                Toast.LENGTH_LONG);
    }
    private void atualizaListaDisciplinas(){
        ArrayList<Disciplina> lista = Controller.getInstance().retornarDisciplinas();

        String texto = "";
        for (Disciplina disciplina:
                Controller.getInstance().retornarDisciplinas()) {
            Professor professor = disciplina.getProfessor();
            texto += "Descrição:" +  disciplina.getDescricao() + " - Carga Horaria:" + disciplina.getCargaHoraria() + "\nProfessor:"+ professor.getNome()+ "\n\n";
        }
        tvDisciplinasCadastradas.setText(texto);
    }
}