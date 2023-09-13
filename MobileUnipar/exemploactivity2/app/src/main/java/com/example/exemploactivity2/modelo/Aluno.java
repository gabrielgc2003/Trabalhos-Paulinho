package com.example.exemploactivity2.modelo;

public class Aluno {
    private int ra;
    private String nome;
    private String cpf;
    private String dtNascimento;

    public Aluno() {
    }

    public Aluno(int ra, String nome, String cpf, String dtNascimento) {
        this.ra = ra;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dtNascimento='" + dtNascimento + '\'' +
                '}';
    }
}
