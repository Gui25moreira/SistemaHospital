package model.pessoas.paciente;

import java.util.ArrayList;
import java.util.List;

import model.atendimento.Atendimento;
import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.Pessoa;

public final class Paciente extends Pessoa {

    private List<String> sintomas;

    public Paciente() {
    }

    public Paciente(String nomePaciente, String cpf, String idade, Endereco endereco, Contato contato) {
        super(nomePaciente, cpf, idade, endereco, contato);
        sintomas = new ArrayList<>();
    }

    public void setSintomas(String sintoma) {
        this.sintomas.add(sintoma);
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public static void listaSintomas(Paciente paciente) {
        if (paciente.getSintomas().size() != 0) {
            List<String> sintomas = paciente.getSintomas();
            for (int i = 0; i < sintomas.size(); i++) {
                System.out.println("\nSintomas\n");
                System.out.println(sintomas.get(i));
            }
        } else {
            System.out.println(" Não existem sintomas cadastrados!");
        }
    }

    public static Paciente verificaPaciente(List<Paciente> array, String cpf) {
        Paciente pacienteTeste = null;
        for (int i = 0; i <= array.size() - 1; i++) {
            if (array.get(i) != null && cpf.equals(array.get(i).getCpf())) {
                pacienteTeste = array.get(i);
            }
        }
        if (pacienteTeste == null) {
            throw new IllegalArgumentException("Cpf inválido, selecione novamente uma opção!");
        }
        return pacienteTeste;
    }

    public static boolean verificaCpf(List<Paciente> array, String cpf) {
        for (int i = 0; i <= array.size() - 1; i++) {
            if (array.get(i) != null && cpf.equals(array.get(i).getCpf())) {
                throw new IllegalArgumentException("Cpf já cadastrado!");
            }
            return false;
        }
        return true;
    }

    public static boolean getPacientes(List<Paciente> pacientes) {
        if (pacientes.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Paciente: {' " + this.getNome() + '\'' + " \n CPF do paciente: '" + this.getCpf() + '\''
                + ",\n Idade do paciente: '" + this.getIdade() + '\'' + ",\n Contato do paciente: "
                + this.getContato().toString() + '}';
    }
}
