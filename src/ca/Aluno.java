package ca;

import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String nomeAluno;
    private Map<String, String> horario;

    //cosntrutor da classe aluno
    public Aluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
        this.horario = new HashMap<>();//cria o hashmap com os horários
    }

    //recebe o nome da disciplina e o horario,adicionando a disciplina na variável disciplina e o horário no Map
    public void adicionarDisciplina(Disciplina disciplina, String horario) {
        disciplina.adicionarAluno(this, horario);
        this.horario.put(disciplina.getNomeDisciplina(),horario);
    }

    //retorna os nomes e o horários das disciplinas do Aluno
    public String getHorarioAluno() {
        StringBuilder horarios = new StringBuilder();
        for (Map.Entry<String, String> entry : horario.entrySet())
        {
            String disciplina = entry.getKey();
            String horario = entry.getValue();
            horarios.append(disciplina).append(": ").append(horario).append("\n");
        }
        return horarios.toString();
    }
    public String getNome(){return nomeAluno;};

}
