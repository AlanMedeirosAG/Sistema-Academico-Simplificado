package tools;

import enums.DiaSemana;

public class Horario {

    private final DiaSemana diaSemana;
    private final int hora;
    private final int minuto;

    public Horario(DiaSemana dia, int hora, int minuto) {
        this.diaSemana = validaDia(dia);
        this.hora = validaHora(hora);
        this.minuto = validaMinuto(minuto);
    }

    //TODO
    private static DiaSemana validaDia(DiaSemana diaSemana){
        return diaSemana;
    }

    private static int validaHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida: " + hora);
        }
        return hora;
    }

    private static int validaMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido: " + minuto);
        }
        return minuto;
    }

    @Override
    public String toString() {
        return String.format("%s - %02d:%02d", diaSemana, hora, minuto);
    }
}
