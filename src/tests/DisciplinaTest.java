package tests;

import model.Disciplina;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {
    private static Disciplina disciplinaTest;
    @BeforeAll
    static void setup(){
        disciplinaTest = new Disciplina(0,"",0);
    }

    @Test
    void setGetId() {
        disciplinaTest.setId(1);
        assertEquals(disciplinaTest.getId(),1);
    }

    @Test
    void setGetNome() {
        disciplinaTest.setNome("Matematica Discreta");
        assertEquals(disciplinaTest.getNome(), "Matematica Discreta");
    }

    @Test
    void setGetCargaHoraria() {
        disciplinaTest.setCargaHoraria(350);
        assertEquals(disciplinaTest.getCargaHoraria(),350);
    }

}