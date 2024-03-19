import model.*;
import tools.Horario;
import enums.DiaSemana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de ControleAcademico
        ControleAcademico controleAcademico = new ControleAcademico();

        // Criando professores
        controleAcademico.criarProfessor("Johan");
        controleAcademico.criarProfessor("Mariana");

        // Criando disciplinas
        controleAcademico.criarDiscilpina("Matemática", 90);
        controleAcademico.criarDiscilpina("Física", 90);
        controleAcademico.criarDiscilpina("Química", 90);


        // Criando alunos
        controleAcademico.criarAluno("João", "123456");
        controleAcademico.criarAluno("Maria", "654321");
        controleAcademico.criarAluno("Pedro", "789456");

        // Criando turmas e associando disciplinas
        controleAcademico.criarTurma(controleAcademico.getDisciplinaById(1)); // Turma para Matemática
        controleAcademico.criarTurma(controleAcademico.getDisciplinaById(2)); // Turma para Física
        controleAcademico.criarTurma(controleAcademico.getDisciplinaById(3)); // Turma para Química


        //atribuindo professores as turmas
        //johan com matematica e fisica
        controleAcademico.getTurmaById(1).setProfessor(controleAcademico.getProfessorById(1));
        controleAcademico.getTurmaById(2).setProfessor(controleAcademico.getProfessorById(1));
        //maria com quimica
        controleAcademico.getTurmaById(3).setProfessor(controleAcademico.getProfessorById(2));

//        atribuindo horarios as discplinas
//        matematica
        controleAcademico.getTurmaById(1).addHorario(new Horario(DiaSemana.QUARTA,14,30));
        controleAcademico.getTurmaById(1).addHorario(new Horario(DiaSemana.SEXTA,12,30));
//        fisica
        controleAcademico.getTurmaById(2).addHorario(new Horario(DiaSemana.SEGUNDA,10,30));
        controleAcademico.getTurmaById(2).addHorario(new Horario(DiaSemana.TERÇA,9,30));

        // Adicionando alunos às turmas
        controleAcademico.getTurmaById(1).addAluno(controleAcademico.getAlunoById(1)); // João em Matemática
        controleAcademico.getTurmaById(1).addAluno(controleAcademico.getAlunoById(2)); // Maria em Matemática
        controleAcademico.getTurmaById(2).addAluno(controleAcademico.getAlunoById(3)); // Pedro em Física
        controleAcademico.getTurmaById(1).addAluno(controleAcademico.getAlunoById(3)); // Pedro em Matemtaica

        // quantidade de alunos em cada disciplina
        int quantidadeMatematica = controleAcademico.getQtdAlunosDisciplina(controleAcademico.getDisciplinaById(1));
        System.out.println("Quantidade de alunos em Matemática: " + quantidadeMatematica);

        int quantidadeFisica = controleAcademico.getQtdAlunosDisciplina(controleAcademico.getDisciplinaById(2));
        System.out.println("Quantidade de alunos em Física: " + quantidadeFisica);

        int quantidadeQuimica = controleAcademico.getQtdAlunosDisciplina(controleAcademico.getDisciplinaById(3));
        System.out.println("Quantidade de alunos em Química: " + quantidadeQuimica);

        // Obtendo as disciplinas de um professor
        Professor professor = controleAcademico.getProfessorById(1);
        ArrayList<Disciplina> disciplinasProfessor = controleAcademico.getDisciplinasProfessor(professor);
        System.out.println("Disciplinas do Professor " + professor.getNome() + ":");
        for (Disciplina disciplina : disciplinasProfessor) {
            System.out.println("- " + disciplina.getNome());
        }
//        HORARIO DE UM PROFESSOR
        System.out.println("\n Horario de Johan");
        Map<String, ArrayList<Horario>> horarioJohan = controleAcademico.getHorarioProfessor(controleAcademico.getProfessorById(1));

        for (Map.Entry<String, ArrayList<Horario>> entry : horarioJohan.entrySet()){
            String disciplina = entry.getKey();
            ArrayList<Horario> horarios = entry.getValue();
            System.out.println("Johan em "+disciplina);
            for (Horario horario : horarios) {
                System.out.println(horario.toString());
            }
        }

//        alunos de matematica
        System.out.println("Alunos de Matematica");
        for (Aluno aluno1 : controleAcademico.getTurmaById(1).getAlunos()){
            System.out.print(aluno1.getNome()+" ");
        }

//        disciplinas de pedro
        System.out.println("\nDisciplinas de Pedro");
        for (Disciplina disciplina1 : controleAcademico.getDisciplinasAluno(controleAcademico.getAlunoById(3))){
            System.out.print(disciplina1.getNome() + " ");
        }
        System.out.println("\n Horario de Pedro");
        Map<String, ArrayList<Horario>> horarioPedro = controleAcademico.getHorarioAluno(controleAcademico.getAlunoById(3));

        for (Map.Entry<String, ArrayList<Horario>> entry : horarioPedro.entrySet()){
            String disciplina = entry.getKey();
            ArrayList<Horario> horarios = entry.getValue();
            System.out.println("Pedro em "+disciplina);
            for (Horario horario : horarios) {
                System.out.println(horario.toString());
            }
        }


    }
}

