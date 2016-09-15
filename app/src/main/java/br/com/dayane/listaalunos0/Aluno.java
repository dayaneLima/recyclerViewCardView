package br.com.dayane.listaalunos0;

/**
 * Created by Dayane on 14/09/2016.
 */
public class Aluno {
    private String nome;
    private String curso;

    public Aluno() {
    }

    public Aluno(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
