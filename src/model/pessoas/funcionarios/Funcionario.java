package model.pessoas.funcionarios;

import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.Pessoa;

public abstract class Funcionario extends Pessoa {
    public Funcionario() {
    }
    public Funcionario(String nome, String cpf, String idade, Endereco endereco, Contato contato) {
        super(nome, cpf, idade, endereco, contato);
    }
}
