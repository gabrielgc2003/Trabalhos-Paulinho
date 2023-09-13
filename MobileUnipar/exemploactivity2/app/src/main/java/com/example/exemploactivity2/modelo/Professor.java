package com.example.exemploactivity2.modelo;

public class Professor {
    private int matricula;
    private String nome;
    private String cpf;
    private String dtNascimento;
    private String dtAdmissao;

    public Professor() {
    }

    public Professor(int matricula, String nome, String cpf, String dtNascimento, String dtAdmissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.dtAdmissao = dtAdmissao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public String getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(String dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dtNascimento='" + dtNascimento + '\'' +
                ", dtAdmissao='" + dtAdmissao + '\'' +
                '}';
    }
}
