package tests;

import model.Aluno;
import model.Disciplina;
import model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {
    private Professor professor;
    private Aluno aluno;
    private Disciplina disciplina;

    @BeforeEach
    void setup(){
        professor = new Professor("Zezo");
        disciplina = new Disciplina("Algoritmos", professor);
        aluno = new Aluno("Shaolin");
    }

    @Test
    void adicionarAluno() {
        disciplina.adicionarAluno(aluno, "12:00");
        assertTrue(disciplina.getAlunos().contains(aluno));
    }

//nao ha getProfessor(), impossivel testar
//    @Test
//    void adicionarProfessor() {
//        disciplina.adicionarProfessor(professor);
//    }
    @Nested
    class getAlunos{
        @Test
        void getAlunosVazio() {
            assertTrue(disciplina.getAlunos().isEmpty());
        }

        @Test
        void getAlunosPreenchido() {
            disciplina.adicionarAluno(aluno,"12:00");
            assertFalse(disciplina.getAlunos().isEmpty());
        }
    }

    @Test
    void getNomeDisciplina() {
        assertEquals(disciplina.getNomeDisciplina(), "Algoritmos");
    }

    @Test
    void getNumeroAlunosVazio() {
        assertEquals(disciplina.getNumeroAlunos(), 0);
    }
    @Test
    void getNumeroAlunos() {
        disciplina.adicionarAluno(aluno, "12:12");
        assertEquals(disciplina.getNumeroAlunos(), 1);
    }
}