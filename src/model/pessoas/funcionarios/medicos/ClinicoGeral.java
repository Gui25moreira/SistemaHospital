package model.pessoas.funcionarios.medicos;

import model.contato.Contato;
import model.endereco.Endereco;

public final class ClinicoGeral extends Medico {
    public ClinicoGeral() {
    }

    public ClinicoGeral(String nome, String cpf, String idade, Endereco endereco, Contato contato,
                        String numCrmMedico) {
        super(nome, cpf, idade, endereco, contato, numCrmMedico);
    }

}
