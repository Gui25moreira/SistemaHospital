package model;

import java.util.Date;
import java.util.List;

import model.pessoas.Pessoa;
import model.pessoas.funcionarios.medicos.Medico;

public class Reserva {
    private Sala sala;
    private String data;
    private Medico medico;

    public Reserva() {
    }

    public Reserva(Sala sala, String data, Medico medico) {
        this.sala = sala;
        this.data = data;
        this.medico = medico;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public static Reserva verificaReserva(List<Reserva> reservas, String data, Sala sala, Medico medico) {
        for (int i = 0; i <= reservas.size() - 1; i++) {
            if (reservas.get(i) != null && data.equals(reservas.get(i).getData()) && reservas.get(i).getSala().getNumero().equals(sala.getNumero())) {
                throw new IllegalArgumentException("Sala já reservada, selecione uma nova data!");
            }
            return null;
        }
        return new Reserva(sala, data, medico);
    }

}
