package com.example.exemploactivity2;

import com.example.exemploactivity2.modelo.Aluno;
import com.example.exemploactivity2.modelo.Disciplina;
import com.example.exemploactivity2.modelo.Professor;

import java.util.ArrayList;

public class Controller {
    private static Controller instancia;
    private static ArrayList<Aluno> listaAlunos;
    private static ArrayList<Professor> listaProfessores;
    private static ArrayList<Disciplina> listaDisciplinas;

    public static Controller getInstance(){
        if (instancia == null)
            return instancia = new Controller();
        else
            return instancia;
    }

    private Controller(){
        listaAlunos = new ArrayList<>();
        listaProfessores = new ArrayList<>();
        listaDisciplinas = new ArrayList<>();
    }
    public void salvarAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }
    public void salvarProfessor(Professor professor){
        listaProfessores.add(professor);
    }
    public void salvarDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    public ArrayList<Aluno> retornarAlunos() {
        return listaAlunos;
    }
    public ArrayList<Professor> retornarProfessores() {
        return listaProfessores;
    }
    public ArrayList<Disciplina> retornarDisciplinas() {
        return listaDisciplinas;
    }
}
