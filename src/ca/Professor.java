package ca;

import java.util.HashMap;
import java.util.Map;

public class Professor {
    private String nomeProfessor;
    private Map<String, String> disciplinas;
    private Map<String, String> horario;

    //construtor da classe professor
    public Professor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        this.disciplinas = new HashMap<>();
        this.horario = new HashMap<>();
    }

    //adiciona a diciplina em um hashmap com o nome e horário
    public void adicionarDisciplina(Disciplina disciplina, String horario) {
        disciplina.adicionarProfessor(this);
        this.horario.put(disciplina.getNomeDisciplina(),horario);
    }

    //retorna os nomes e o horários das disciplinas do professor
    public String getHorarioProfessor() {
        StringBuilder horarios = new StringBuilder();
        for (Map.Entry<String, String> entry : horario.entrySet())
        {
            String disciplina = entry.getKey();
            String horario = entry.getValue();
            horarios.append(disciplina).append(": ").append(horario).append("\n");
        }
        return horarios.toString();
    }
    //retorna nome professor
    public String getNome(){return nomeProfessor;};
}


