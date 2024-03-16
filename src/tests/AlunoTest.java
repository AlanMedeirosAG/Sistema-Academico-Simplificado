package tests;

import model.Aluno;
import model.Disciplina;
import model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private Aluno aluno;
    private Professor professor;
    private Disciplina disciplina;
    private final String horario = "12:00";


    @BeforeEach
    void setup(){
        professor = new Professor("Diego");
        aluno = new Aluno("João");
        disciplina = new Disciplina("Algoritmos", professor);
    }

    @Nested
    class getHorarioAluno{
        @Test
        void getHorarioAlunoVazio() {
            assertEquals(aluno.getHorarioAluno(), "");
        }
        @Test
        void getHorarioAlunoPreenchido(){
            aluno.adicionarDisciplina(disciplina,"12:30");
            assertFalse(aluno.getHorarioAluno().isEmpty());
        }
    }


    @Test
    void adicionarDisciplina() {
        aluno.adicionarDisciplina(disciplina,horario);
        assertEquals(aluno.getHorarioAluno(), "Algoritmos: "+horario+"\n");
    }

    @Nested
    class getNome{
        @Test
        void getNomeCorreto() {
            assertEquals(aluno.getNome(), "João");
        }
        @Test
        void getNomeIncorreto() {
            assertNotEquals(aluno.getNome(), "Jorge");
        }
    }
}