package model.pessoas.funcionarios.atendente;

import static model.atendimento.Fila.getPosicaoFila;
import static model.pessoas.paciente.Paciente.*;

import java.util.List;

import model.Sala;
import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.funcionarios.Funcionario;
import model.pessoas.paciente.Paciente;

public final class Atendente extends Funcionario {

    private boolean atendimentoAtivo;

    public Atendente() {
    }

    public Atendente(String nome, String cpf, String idade, Endereco endereco, Contato contato) {
        super(nome, cpf, idade, endereco, contato);
    }

    public void retornarStatusDoPaciente(String cpfPaciente, List<Paciente> array) {
        if (getPacientes(array)) {
            Paciente pacienteTeste;
            pacienteTeste = verificaPaciente(array, cpfPaciente);
            System.out.println(pacienteTeste);
            getPosicaoFila(array, pacienteTeste);
            listaSintomas((pacienteTeste));
        } else {
            System.out.println("Não existem pacientes cadastrados");
        }
    }

    public static Atendente verificaAtendente(List<Atendente> atendentes, String cpf) {
        Atendente atendenteTeste = null;
        for (int i = 0; i <= atendentes.size() - 1; i++) {
            if (atendentes.get(i) != null && cpf.equals(atendentes.get(i).getCpf())) {
                atendenteTeste = atendentes.get(i);
            }
        }
        if (atendenteTeste == null) {
            throw new IllegalArgumentException("Cpf inválido, selecione novamente uma opção!");
        }
        return atendenteTeste;
    }
}
