package model.pessoas.funcionarios.medicos;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.funcionarios.Funcionario;
import model.pessoas.paciente.Paciente;

public class Medico extends Funcionario {

    private String numCrmMedico;

    public Medico() {

    }

    public Medico(String nome, String cpf, String idade, Endereco endereco, Contato contato, String numCrmMedico) {
        super(nome, cpf, idade, endereco, contato);
        this.numCrmMedico = numCrmMedico;
    }

    public String getNumCrmMedico() {
        return numCrmMedico;
    }

    public final static void gerarDiagostico(Paciente paciente) {

        boolean gerandoDiagnostico = true;
        while (gerandoDiagnostico) {
            System.out.println("Escolha uma opção!");
            int cadastrarSintomas;

            System.out.println("1 - Cadastrar sintoma");
            System.out.println("0 - Sair do sistema");
            cadastrarSintomas = scan.nextInt();
            switch (cadastrarSintomas) {
                case 1:
                    System.out.println("Digite um sintoma por vez.");
                    String sintoma = scan.next();
                    paciente.setSintomas(sintoma);
                    break;
                case 0:
                    System.out.println("Diagnostico encerrado!");
                    gerandoDiagnostico = false;
            }

        }

    }

    public static Medico verificaMedico(List<Medico> array, String numCrmMedico) {
        Medico medicoTeste = null;
        for (int i = 0; i <= array.size() - 1; i++) {
            if (array.get(i) != null && numCrmMedico.equals(array.get(i).getNumCrmMedico())) {
                medicoTeste = array.get(i);
            }
        }
        if (medicoTeste == null) {
            throw new IllegalArgumentException("Crm inválido, selecione novamente uma opção!");
        }

        return medicoTeste;
    }

    @Override
    public boolean equals(Object o) {
        Medico m = (Medico) o;
        return Objects.nonNull(m) && this.getNumCrmMedico() == m.getNumCrmMedico();
    }

    static Scanner scan = new Scanner(System.in);
}
