package ca;

import model.Aluno;
import model.Disciplina;
import model.Professor;

import java.util.List;

public class ControleAcademico {

    public static void main(String[] arg){

        //instancias alunos

        Aluno aluno1 = new Aluno("Luiza Medeiros");
        Aluno aluno2 = new Aluno("Julio César");
        Aluno aluno3 = new Aluno("Klebson Junior");

        //instancias professor

        Professor professor1 = new Professor("Jefferson");
        Professor professor2 = new Professor("Sabrina");

        //instancias diciplinas

        Disciplina disciplina1 = new Disciplina("Metódos Avançados de programação",professor2);
        Disciplina disciplina2 = new Disciplina("Cálculo 3",professor1);
        Disciplina disciplina3 = new Disciplina("Paradigmas de Programação",professor1);

        //adicionando alunos nas diciplinas

        aluno1.adicionarDisciplina(disciplina1,"16:00");
        aluno1.adicionarDisciplina(disciplina3,"14:00");

        aluno2.adicionarDisciplina(disciplina2,"07:00");
        aluno2.adicionarDisciplina(disciplina3,"09:00");

        aluno3.adicionarDisciplina(disciplina1,"11:00");
        aluno3.adicionarDisciplina(disciplina2,"16:00");

        //adicionando professores

        professor1.adicionarDisciplina(disciplina3,"16:00");
        professor1.adicionarDisciplina(disciplina2,"11:00");
        professor2.adicionarDisciplina(disciplina1,"11:00");

        //horarios

        System.out.println("Horário do professor(a)" + professor1.getNome() + ":\n"  + professor1.getHorarioProfessor());
        System.out.println("Horário do professor(a)" + professor2.getNome() + ":\n"  + professor2.getHorarioProfessor());
        System.out.println("Horário do Aluno(a)" + aluno1.getNome() + ":\n"  + aluno1.getHorarioAluno());
        System.out.println("Horário do Aluno(a)" + aluno2.getNome() + ":\n"  + aluno2.getHorarioAluno());
        System.out.println("Horário do Aluno(a)" + aluno3.getNome() + ":\n"  + aluno3.getHorarioAluno());

        //lista de alunos

        List<Aluno> turma1 = disciplina1.getAlunos();
        List<Aluno> turma2 = disciplina2.getAlunos();
        List<Aluno> turma3 = disciplina3.getAlunos();

        System.out.println("Alunos da disciplina de " + disciplina1.getNomeDisciplina() + ":");
        for (Aluno aluno : turma1) {
            System.out.println(aluno.getNome());
        }

    System.out.print("\n");

    System.out.println("Alunos da disciplina de " + disciplina2.getNomeDisciplina() + ":");
        for (Aluno aluno : turma2) {
        System.out.println(aluno.getNome());
    }

        System.out.print("\n");

     System.out.println("Alunos da disciplina de " + disciplina3.getNomeDisciplina() + ":");
        for (Aluno aluno : turma3) {
        System.out.println(aluno.getNome());
        }

        System.out.print("\n");

        //professores de cada disciplina

        System.out.println("Professor da disciplina " + disciplina1.getNomeDisciplina() + ": " + professor2.getNome());
        System.out.println("Professor da disciplina " + disciplina2.getNomeDisciplina() + ": " + professor1.getNome());
        System.out.println("Professor da disciplina " + disciplina3.getNomeDisciplina() + ": " + professor1.getNome());

     //numero de alunos

        System.out.print("\n");

        int numeroAlunos = disciplina3.getNumeroAlunos();

      System.out.println("Número de alunos na disciplina de " + disciplina1.getNomeDisciplina() + ": " + numeroAlunos);

      System.out.println("Número de alunos na disciplina de " + disciplina2.getNomeDisciplina() + ": " + numeroAlunos);

      System.out.println("Número de alunos na disciplina de " + disciplina3.getNomeDisciplina() + ": " + numeroAlunos);


    }
}

