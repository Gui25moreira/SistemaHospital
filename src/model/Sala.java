package model;

import model.pessoas.paciente.Paciente;

import java.util.List;

public class Sala {

    private String numero;

    public Sala() {
    }

    public Sala(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static Sala verificaSala(List<Sala> salas, String numero) {
        Sala salaTeste = null;
        for (int i = 0; i <= salas.size() - 1; i++) {
            if (salas.get(i) != null && numero.equals(salas.get(i).getNumero())) {
                salaTeste = salas.get(i);
            }
        }
        if (salaTeste == null) {
            throw new IllegalArgumentException("Numero da sala inválido, selecione novamente uma opção!");
        }
        return salaTeste;
    }
}
