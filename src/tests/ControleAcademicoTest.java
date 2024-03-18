package tests;

import model.*;
import tools.Horario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControleAcademicoTest {

    private ControleAcademico controleAcademico;
    private Turma turma;


    @BeforeEach
    void setUp() {
        controleAcademico = new ControleAcademico();
        Disciplina disciplina = new Disciplina(5, "Matemática", 90);
        controleAcademico.criarTurma(disciplina);
        controleAcademico.criarAluno(1, "John", "12345678");
        controleAcademico.criarProfessor(10,"Junior Morais");
    }

   @Nested
    class criarProfessor{

        @Test
        void criarProfessorNãoNulo () {
            controleAcademico.criarProfessor(01, "Diego");
            Professor professorObtido = controleAcademico.getProfessorById(1);
            assertNotNull(professorObtido);// Garante que o professor não é nulo
        }
        @Test
        void verificarId() {
            controleAcademico.criarProfessor(01, "Diego");
            Professor professorObtido = controleAcademico.getProfessorById(1);
                assertEquals(1, professorObtido.getId()); // Verifica o ID do professor
            }
       @Test
       void verificarNome() {
           controleAcademico.criarProfessor(01, "Diego");
           Professor professorObtido = controleAcademico.getProfessorById(1);
         assertEquals("Diego", professorObtido.getNome()); // Verifica o nome do professor
    }
  }

    @Nested
    class criarAluno{

    @Test
    void criarAlunoNãoNulo () {
        controleAcademico.criarAluno(01, "John","12345678");
        Aluno alunoObtido = controleAcademico.getAlunoById(1);
        assertNotNull(alunoObtido);// Garante que o aluno não é nulo
    }
    @Test
    void verificarId() {
        controleAcademico.criarAluno(01, "John","12345678");
        Aluno alunoObtido = controleAcademico.getAlunoById(1);
        assertEquals(1, alunoObtido.getId()); // Verifica o ID do aluno
    }
    @Test
    void verificarNome() {
        controleAcademico.criarAluno(01, "John", "12345678");
        Aluno alunoObtido = controleAcademico.getAlunoById(1);
        assertEquals("John", alunoObtido.getNome()); // Verifica o nome do aluno
        }

    }

    @Nested
    class CriarTurma {

        @Test
        void criarTurmaNãoNula() {
            Turma turmaObtida = controleAcademico.getTurmaById(5);
            assertNotNull(turmaObtida);
        }

        @Test
        void verificarAluno() {
            Turma turmaObtida = controleAcademico.getTurmaById(5);
            turmaObtida.addAluno(controleAcademico.getAlunoById(1));
            assertTrue(turmaObtida.getAlunos().contains(controleAcademico.getAlunoById(1)));
        }
    }

  @Nested
  class getProfessorById{

        @Test
        void professorByIdNotNullTest(){
            Professor professorObtido = controleAcademico.getProfessorById(10);
            assertNotNull(professorObtido);
        }

      @Test
      void professorByIdTest(){
          Professor professorObtido = controleAcademico.getProfessorById(10);
          assertEquals(10,professorObtido.getId());
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
            Turma turmaObtido = controleAcademico.getTurmaById(5);
            assertNotNull(turmaObtido);
        }

        @Test
        void turmaByIdTest(){
            Turma turmaObtido = controleAcademico.getTurmaById(5);
            assertEquals(5,turmaObtido.getId());
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

            controleAcademico.criarAluno(1, "João", "123456");
            controleAcademico.criarAluno(2, "Maria", "654321");
            controleAcademico.criarAluno(3, "Pedro", "789456");

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
          controleAcademico.criarTurma(quimica); // Esta turma não tem professor

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

          ArrayList<Disciplina> disciplinasDoAluno = controleAcademico.getDisciplinasAluno(aluno);

          assertEquals(2, disciplinasDoAluno.size());
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



