package tests;

import model.Disciplina;
import model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    private Professor professor;
    private Disciplina disciplina;
    private final String horario = "12:00";
    @BeforeEach
    void setup(){
        professor = new Professor("Maria");
        disciplina = new Disciplina("Algoritmos", professor);
    }

    @Test
    void adicionarDisciplina(){
        professor.adicionarDisciplina(disciplina, horario);
        assertEquals(professor.getHorarioProfessor(), "Algoritmos: "+horario+"\n");
    }

    @Nested
    class getHorario{
        @Test
        void getHorarioVazio() {
            assertEquals(professor.getHorarioProfessor(), "");
        }
        @Test
        void getHorarioPreenchido(){
            professor.adicionarDisciplina(disciplina,"12:30");
            assertFalse(professor.getHorarioProfessor().isEmpty());
        }
    }


    @Nested
    class getNome{
        @Test
        void getNomeCorreto() {
            assertEquals(professor.getNome(), "Maria");
        }
        @Test
        void getNomeIncorreto() {
            assertNotEquals(professor.getNome(), "Não Maria");
        }
    }
}