package model.pessoas;

import model.contato.Contato;
import model.endereco.Endereco;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String idade;
    private Contato contato;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String idade, Endereco endereco, Contato contato) {

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.contato = contato;

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {

        return cpf;
    }

    public String getIdade() {
        return idade;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade='" + idade + '\'' +
                ", contato=" + contato.toString() +
                ", endereco=" + endereco.toString() +
                '}';
    }

    public boolean equals(Object o) {
        Pessoa p = (Pessoa) o;
        if (this.getCpf() == p.getCpf()) {
            return true;
        } else {
            return false;
        }
    }
}
