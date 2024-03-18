package model;

import tools.Horario;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Turma> turmas;
    private ArrayList<Disciplina> disciplinas;


    public void criarProfessor(int id, String nome){
        Professor professor = new Professor(id, nome);
        this.professores.add(professor);
    }

    public void criarAluno(int id, String nome, String matricula){
        Aluno aluno = new Aluno(id, nome, matricula);
        this.alunos.add(aluno);
    }

    public void criarTurma(Disciplina disciplina){
        Turma turma = new Turma(disciplina);
        this.turmas.add(turma);
    }

    public Professor getProfessorById(int id){
        for (Professor professor : professores){
            if (professor.getId() == id) return professor;
        }
        return null;
    }

    public Aluno getAlunoById(int id){
        for (Aluno aluno : alunos){
            if (aluno.getId() == id) return aluno;
        }
        return null;
    }

    public Turma getTurmaById(int id){
        for (Turma turma : turmas){
            if (turma.getId() == id) return turma;
        }
        return null;
    }

    public int getQtdAlunosDisciplina(Disciplina disciplina) {
        int quantidade = 0;
        for(Turma turma : turmas){
            if (turma.getDisciplina() == disciplina){
                quantidade += turma.getAlunosMatriculados();
            }
        }
        return quantidade;
    }

    public ArrayList<Disciplina> getDisciplinasProfessor(Professor professor){
        ArrayList<Disciplina> disciplinasProfessor = new ArrayList<>();
        for (Turma turma : turmas) {
            if (turma.getProfessor() == professor
                    && !disciplinasProfessor.contains(turma.getDisciplina())) {
                disciplinasProfessor.add(turma.getDisciplina());
            }
        }
        return disciplinasProfessor;
    }
    public ArrayList<Disciplina> getDisciplinasAluno(Aluno aluno){
        ArrayList<Disciplina> disciplinasAluno = new ArrayList<>();
        for (Turma turma : turmas) {
            if (turma.getAlunos().contains(aluno)
                    && !disciplinasAluno.contains(turma.getDisciplina())) {
                disciplinasAluno.add(turma.getDisciplina());
            }
        }
        return disciplinasAluno;
    }

//    cabe ao controle academico?
    public ArrayList<Horario> getHorarioAluno(Aluno aluno) {
        ArrayList<Horario> horarioAluno = new ArrayList<>();
        for (Turma turma : turmas){
            if (turma.getAlunos().contains(aluno)){
                horarioAluno.addAll(turma.getHorario());
            }
        }
        return horarioAluno;
    }

}

