package model;

import tools.Horario;

import java.util.ArrayList;

public class Turma {
    private int id;
    private Disciplina disciplina;
    private Professor professor;
    private final ArrayList<Aluno> alunos;
    private final ArrayList<Horario> horarios;
    private String sala;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    public ArrayList<Horario> getHorario(){return this.horarios;}

    public void addHorario(Horario horario){
        this.horarios.add(horario);
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunosMatriculados(){
        return alunos.size();
    }
    public Turma(Disciplina disciplina, int id) {
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.id = id;
    }
}
