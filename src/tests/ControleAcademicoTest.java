package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControleAcademicoTest {

    private ControleAcademico controleAcademico;


    @BeforeEach
    void setUp() {
        controleAcademico = new ControleAcademico();
        controleAcademico.criarDiscilpina("Matemática", 90);
        controleAcademico.criarTurma(controleAcademico.getDisciplinaById(1));
        controleAcademico.criarAluno("John", "12345678");
    }

    @Nested
    class criarProfessor{

        @Test
        void criarProfessorNaoNulo () {
            controleAcademico.criarProfessor("Diego");
            Professor professorObtido = controleAcademico.getProfessorById(1);
            assertNotNull(professorObtido);// Garante que o professor não é nulo
        }
        @Test
        void verificarId() {
            controleAcademico.criarProfessor("Diego");
            Professor professorObtido = controleAcademico.getProfessorById(1);
            assertEquals(1, professorObtido.getId()); // Verifica o ID do professor
        }
        @Test
        void verificarNome() {
            controleAcademico.criarProfessor("Diego");
            Professor professorObtido = controleAcademico.getProfessorById(1);
            assertEquals("Diego", professorObtido.getNome()); // Verifica o nome do professor
        }
    }

    @Nested
    class criarAluno{

        @Test
        void criarAlunoNãoNulo () {
            controleAcademico.criarAluno("John","12345678");
            Aluno alunoObtido = controleAcademico.getAlunoById(1);
            assertNotNull(alunoObtido);// Garante que o aluno não é nulo
        }
        @Test
        void verificarId() {
            controleAcademico.criarAluno("John","12345678");
            Aluno alunoObtido = controleAcademico.getAlunoById(1);
            assertEquals(1, alunoObtido.getId()); // Verifica o ID do aluno
        }
        @Test
        void verificarNome() {
            controleAcademico.criarAluno("John", "12345678");
            Aluno alunoObtido = controleAcademico.getAlunoById(1);
            assertEquals("John", alunoObtido.getNome()); // Verifica o nome do aluno
        }

    }

    @Nested
    class CriarTurma {

        @Test
        void criarTurmaNãoNula() {
            Turma turmaObtida = controleAcademico.getTurmaById(1);
            assertNotNull(turmaObtida);
        }

        @Test
        void verificarAluno() {
            Turma turmaObtida = controleAcademico.getTurmaById(1);
            turmaObtida.addAluno(controleAcademico.getAlunoById(1));
            assertTrue(turmaObtida.getAlunos().contains(controleAcademico.getAlunoById(1)));
        }
    }

    @Nested
    class getProfessorById{

        @Test
        void professorByIdNotNullTest(){
            controleAcademico.criarProfessor("Josef André");
            Professor professorObtido = controleAcademico.getProfessorById(1);
            assertNotNull(professorObtido);
        }

        @Test
        void professorByIdTest(){
            controleAcademico.criarProfessor("Josef André");
            controleAcademico.criarProfessor("Josef André");

            Professor professorObtido = controleAcademico.getProfessorById(2);
            assertEquals(2,professorObtido.getId());
        }
    }

    @Nested
    class getAlunoById{

        @Test
        void alunoByIdNotNullTest(){
            Aluno alunoObtido = controleAcademico.getAlunoById(1);
            assertNotNull(alunoObtido);
        }

        @Test
        void alunoByIdTest(){
            Aluno alunoObtido = controleAcademico.getAlunoById(1);
            assertEquals(1,alunoObtido.getId());
        }
    }

    @Nested
    class getTurmaById{

        @Test
        void turmaByIdNotNullTest(){
            Turma turmaObtido = controleAcademico.getTurmaById(1);
            assertNotNull(turmaObtido);
        }

        @Test
        void turmaByIdTest(){

            Disciplina matematica = new Disciplina(1, "Matemática", 90);
            Disciplina fisica = new Disciplina(2, "Física", 90);
            Disciplina quimica = new Disciplina(3, "Química", 90);

            controleAcademico.criarTurma(fisica);

            Turma turmaObtido = controleAcademico.getTurmaById(2);
            assertEquals(2,turmaObtido.getId());
        }
    }

    @Nested
    class getQtdAlunos {

        @Test
        void getQtdAlunosDisciplinaNenhumaturma() {
            Disciplina disciplina = new Disciplina(1, "Matemática", 90);

            int quantidade = controleAcademico.getQtdAlunosDisciplina(disciplina);

            assertEquals(0, quantidade);
        }

        @Test
        void getQtdAlunosDisciplina() {

            Disciplina matematica = new Disciplina(1, "Matemática", 90);
            Disciplina fisica = new Disciplina(2, "Física", 90);

            controleAcademico.criarAluno("João", "123456");
            controleAcademico.criarAluno("Maria", "654321");
            controleAcademico.criarAluno("Pedro", "789456");

            controleAcademico.criarTurma(matematica);
            controleAcademico.criarTurma(fisica);

            controleAcademico.getTurmaById(1).addAluno(controleAcademico.getAlunoById(1));
            controleAcademico.getTurmaById(1).addAluno(controleAcademico.getAlunoById(2));
            controleAcademico.getTurmaById(2).addAluno(controleAcademico.getAlunoById(3));

            int quantidadeMatematica = controleAcademico.getQtdAlunosDisciplina(matematica);
            assertEquals(2, quantidadeMatematica);
            int quantidadeFisica = controleAcademico.getQtdAlunosDisciplina(fisica);
            assertEquals(1, quantidadeFisica);
        }
    }

    @Nested
    class getDiciplinasProfessor {

        @Test
        void getDisciplinasProfessorTest(){
            // Criação de professor
            Professor professor = new Professor(1, "João");

            // Criação de disciplinas
            Disciplina matematica = new Disciplina(1, "Matemática", 90);
            Disciplina fisica = new Disciplina(2, "Física", 90);
            Disciplina quimica = new Disciplina(3, "Química", 90);

            controleAcademico.criarTurma(matematica);
            controleAcademico.getTurmaById(1).setProfessor(professor);
            controleAcademico.criarTurma(fisica);
            controleAcademico.getTurmaById(2).setProfessor(professor);
            controleAcademico.criarTurma(quimica);


            ArrayList<Disciplina> disciplinasDoProfessor = controleAcademico.getDisciplinasProfessor(professor);

            assertEquals(2, disciplinasDoProfessor.size());
            assertTrue(disciplinasDoProfessor.contains(matematica));
            assertTrue(disciplinasDoProfessor.contains(fisica));
            assertFalse(disciplinasDoProfessor.contains(quimica));
        }


        @Test
        void getDisciplinasProfessorNenhumaDisciplinaTest(){

            Professor professor = new Professor(1, "Maria");

            ArrayList<Disciplina> disciplinasDoProfessor = controleAcademico.getDisciplinasProfessor(professor);

            assertTrue(disciplinasDoProfessor.isEmpty());
        }
    }

    @Nested
    class getDisciplinasAluno {

        @Test
        void getDisciplinasAlunoTest() {
            // Criação de aluno
            Aluno aluno = new Aluno(1, "João", "123456");

            // Criação de disciplinas
            Disciplina matematica = new Disciplina(1, "Matemática", 90);
            Disciplina fisica = new Disciplina(2, "Física", 90);
            Disciplina quimica = new Disciplina(3, "Química", 90);

            controleAcademico.criarTurma(matematica);
            controleAcademico.getTurmaById(1).addAluno(aluno);
            controleAcademico.criarTurma(fisica);
            controleAcademico.getTurmaById(2).addAluno(aluno);
            controleAcademico.criarTurma(quimica);
            controleAcademico.getTurmaById(3).addAluno(aluno);


            ArrayList<Disciplina> disciplinasDoAluno = controleAcademico.getDisciplinasAluno(aluno);

            assertEquals(3, disciplinasDoAluno.size());
            assertTrue(disciplinasDoAluno.contains(matematica));
            assertTrue(disciplinasDoAluno.contains(fisica));
            assertFalse(disciplinasDoAluno.contains(quimica));
        }

        @Test
        void getDisciplinasAlunoNenhumaDisciplinaTest() {
            // Criação de aluno sem matrícula em turmas
            Aluno aluno = new Aluno(1, "Maria", "654321");

            ArrayList<Disciplina> disciplinasDoAluno = controleAcademico.getDisciplinasAluno(aluno);

            assertTrue(disciplinasDoAluno.isEmpty());
        }
    }

}
