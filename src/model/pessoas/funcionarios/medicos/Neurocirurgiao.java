package model.pessoas.funcionarios.medicos;

import model.contato.Contato;
import model.endereco.Endereco;

public final class Neurocirurgiao extends Medico {

    public Neurocirurgiao() {
    }

    public Neurocirurgiao(String nome, String cpf, String idade, Endereco endereco, Contato contato,
                          String numCrmMedico) {
        super(nome, cpf, idade, endereco, contato, numCrmMedico);
    }
}
