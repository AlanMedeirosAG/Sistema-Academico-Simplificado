package tests;

import enums.DiaSemana;
import model.Aluno;
import model.Disciplina;
import model.Professor;
import model.Turma;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.Horario;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {
    static Turma turmaTest;
    @BeforeAll
    static void setup(){
        turmaTest = new Turma(null,1);
    }
    @Test
    void setGetDisciplina() {
        Disciplina disciplina = new Disciplina(1,"Algoritmos",350);
        turmaTest.setDisciplina(disciplina);
        assertEquals(turmaTest.getDisciplina(),disciplina);
    }

    @Test
    void setGetProfessor() {
        Professor professor = new Professor(1,"Herbert Richers");
        turmaTest.setProfessor(professor);
        assertEquals(turmaTest.getProfessor(),professor);
    }

    @Test
    void setGetSala() {
        turmaTest.setSala("B302");
        assertEquals(turmaTest.getSala(),"B302");
    }

    @Test
    void addGetHorario() {
        Horario horario1 = new Horario(DiaSemana.SEGUNDA,7,0);
        Horario horario2 = new Horario(DiaSemana.QUARTA,9,0);
        turmaTest.addHorario(horario1);
        turmaTest.addHorario(horario2);
        assertTrue((turmaTest.getHorario().getFirst() == horario1 && turmaTest.getHorario().getLast() == horario2));
    }

    @Test
    void addGetAluno() {
        Aluno aluno1 = new Aluno(1,"Rodrigo","10101010");
        turmaTest.addAluno(aluno1);
        assertEquals(turmaTest.getAlunos().getFirst().getMatricula(),aluno1.getMatricula());
    }

    @Test
    void setGetId() {
        turmaTest.setId(2);
        assertEquals(turmaTest.getId(), 2);
    }

    @Test
    void getAlunosMatriculados() {
        Aluno aluno1 = new Aluno(1,"Rodrigo","10101010");
        turmaTest.addAluno(aluno1);
        assertEquals(turmaTest.getAlunosMatriculados(),1);
    }
}