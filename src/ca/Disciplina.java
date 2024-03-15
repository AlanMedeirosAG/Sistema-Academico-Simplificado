package ca;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String nomeDisciplina;
    private List<Aluno> alunos;
    private Professor professor;

    //construtor da classe disciplinas
    public Disciplina(String nomeDisciplina,Professor professor){
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    //recebe um objeto do tipo aluno e String e adiciona o objeto na lista de alunos
    public void adicionarAluno(Aluno aluno,String horario){
        alunos.add(aluno);
    }

    //recebe um objeto do tipo professor
    public void adicionarProfessor(Professor professor){
        this.professor = professor;
    }

    //retorna a lista de alunos
    public List<Aluno> getAlunos() {
        return alunos;
    }

    //retorna nome da disciplina
    public String getNomeDisciplina(){return nomeDisciplina;};

    public int getNumeroAlunos(){
        return alunos.size();
    }

}

