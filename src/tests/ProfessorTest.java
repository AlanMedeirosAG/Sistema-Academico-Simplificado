package tests;

import model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    private Professor professorTest;

    @BeforeEach
    void setup(){
        professorTest = new Professor(1,"Lucas Schwengber Rosario");
    }

    @Test
    void setGetId() {
        professorTest.setId(2);
        assertEquals(professorTest.getId(),2);
    }

    @Test
    void setGetNome() {
        professorTest.setNome("Fleberson Pereira Trajano");
        assertEquals(professorTest.getNome(),"Fleberson Pereira Trajano");
    }
}