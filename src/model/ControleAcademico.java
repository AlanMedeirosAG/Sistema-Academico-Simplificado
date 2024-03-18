package model;

import tools.Horario;

import java.util.ArrayList;

public class ControleAcademico {
    private final ArrayList<Professor> professores = new ArrayList<>();
    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private final ArrayList<Turma> turmas = new ArrayList<>();
    private final ArrayList<Disciplina> disciplinas = new ArrayList<>();


    public void criarProfessor(String nome){
        int id = professores.size()+1;
        Professor professor = new Professor(id, nome);
        this.professores.add(professor);
    }

    public void criarDiscilpina(String nome, int ch){
        int id = disciplinas.size()+1;
        Disciplina disciplina = new Disciplina(id, nome, ch);
        this.disciplinas.add(disciplina);
    }

    public void criarAluno(String nome, String matricula){
        int id = alunos.size()+1;
        Aluno aluno = new Aluno(id, nome, matricula);
        this.alunos.add(aluno);
    }

    public void criarTurma(Disciplina disciplina){
        int id = turmas.size()+1;
        Turma turma = new Turma(disciplina, id);
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
            if (turma.getId() == id){
                return turma;
            }
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

    public Disciplina getDisciplinaById(int id){
        for (Disciplina disciplina : disciplinas){
            if (disciplina.getId() == id) return disciplina;
        }
        return null;
    }
}

