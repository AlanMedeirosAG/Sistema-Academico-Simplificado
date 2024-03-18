package tests;

import model.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private Aluno alunoTest;
    @BeforeEach
    void setup(){
        alunoTest = new Aluno(1,"Fabiano Rocha","212080190");
    }

    @Test
    void setGetId() {
        alunoTest.setId(9);
        assertEquals(alunoTest.getId(), 9);
    }

    @Test
    void setGetNome() {
        alunoTest.setNome("Rodrigo Juliano");
        assertEquals(alunoTest.getNome(),"Rodrigo Juliano");
    }

    @Test
    void setGetMatricula() {
        alunoTest.setMatricula("212080111");
        assertEquals(alunoTest.getMatricula(),"212080111");
    }
}