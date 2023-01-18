package model.atendimento;

import java.util.List;

import model.pessoas.funcionarios.atendente.Atendente;
import model.pessoas.paciente.Paciente;

public class Fila extends Atendimento {

    public Fila(Atendente atendenteResponsavel) {
        super(atendenteResponsavel);
    }

    public static void getPosicaoFila(List<Paciente> pacientes, Paciente paciente) {
        for (int i = 0; i <= pacientes.size() - 1; i++) {
            if (pacientes.get(i) != null && paciente.equals(pacientes.get(i))) {
                System.out.println(" A posição na fila deste paciente é a: " + i + 1);
            }
        }
    }

}
