package Control;

import static model.Reserva.verificaReserva;
import static model.atendimento.Atendimento.getAtendimentos;
import static model.atendimento.Cirurgia.realizarCirurgia;
import static model.pessoas.funcionarios.atendente.Atendente.verificaAtendente;
import static model.pessoas.funcionarios.medicos.Medico.gerarDiagostico;
import static model.pessoas.funcionarios.medicos.Medico.verificaMedico;
import static model.pessoas.paciente.Paciente.verificaCpf;
import static model.pessoas.paciente.Paciente.verificaPaciente;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Reserva;
import model.Sala;
import model.atendimento.Atendimento;
import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.funcionarios.atendente.Atendente;
import model.pessoas.funcionarios.medicos.Medico;
import model.pessoas.paciente.Paciente;

public class Sistema {

    public static void iniciarSistema(List<Paciente> pacientes, List<Medico> medicos, List<Atendente> atendentes, List<Sala> salas, List<Reserva> reservas, List<Atendimento> atendimentos) {
        boolean atendimentoAtivo = true;
        while (atendimentoAtivo) {
            try {
                int escolha;
                imprimeMenuInicial();
                escolha = scan.nextInt();
                System.out.println();
                switch (escolha) {
                    case 1:
                        Medico medicoTeste = buscarMedico(medicos);
                        if (medicoTeste != null) {
                            System.out.println("Login efetuado com sucesso, bem vindo Doutor " + medicoTeste.getNome());
                            System.out.println();
                            iniciarSistemaMedico(pacientes, medicoTeste, atendimentoAtivo);
                        } else {
                            System.out.println("Médico não encontrado!");
                        }
                        break;
                    case 2:
                        Atendente atendenteTeste = buscarAtendente(atendentes);
                        if (atendenteTeste != null) {
                            System.out.println("Login efetuado com sucesso, bem vindo: " + atendenteTeste.getNome());
                            System.out.println();
                            iniciarSistemaAtendente(pacientes, atendenteTeste, atendimentoAtivo, reservas, medicos, salas, atendimentos);
                        } else {
                            System.out.println("Atendente não encontrado!");
                            System.out.println();
                            System.out.println("\n Tecle enter para continuar! \n");
                            scan.nextLine();
                        }
                        break;
                    case 0:
                        System.out.println("Você saiu do sistema");
                        System.out.println();
                        atendimentoAtivo = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Entrada inválida, selecione uma opção válida!");

                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }


        }
    }

    public static void iniciarSistemaAtendente(List<Paciente> pacientes, Atendente atendente, boolean atendimentoAtivo, List<Reserva> reservas, List<Medico> medicos, List<Sala> salas, List<Atendimento> atendimentos) {
        try {
            while (atendimentoAtivo) {
                scan.nextLine();
                int escolha;
                imprimeMenulAtendente();
                escolha = scan.nextInt();
                switch (escolha) {
                    case 1:
                        pacientes.add(cadastrarAtendimento(atendente, atendimentos, pacientes));
                        System.out.println("\n Tecle enter para continuar! \n");
                        scan.nextLine();
                        break;
                    case 2:
                        buscarStatus(atendente, pacientes);
                        System.out.println("\n Tecle enter para continuar! \n");
                        scan.nextLine();
                        break;
                    case 3:
                        reservas.add(cadastrarReservaDeSala(medicos, salas, reservas));
                        System.out.println("\n Tecle enter para continuar! \n");
                        scan.nextLine();
                        break;
                    case 4:
                        getAtendimentos(atendimentos);
                        System.out.println("\n Tecle enter para continuar! \n");
                        scan.nextLine();
                        break;
                    case 0:
                        System.out.println("Você saiu do sistema");
                        System.out.println();
                        atendimentoAtivo = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Entrada inválida, selecione uma opção válida!");
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            iniciarSistemaAtendente(pacientes, atendente, atendimentoAtivo, reservas, medicos, salas, atendimentos);
        }
    }

    public static void iniciarSistemaMedico(List<Paciente> pacientes, Medico medico, boolean atendimentoAtivo) {
        try {
            while (atendimentoAtivo) {
                int escolha;
                imprimeMenuMedico();
                escolha = scan.nextInt();
                switch (escolha) {
                    case 1:
                        Paciente pacienteTeste = buscarPaciente(pacientes);
                        gerarDiagostico(pacienteTeste);
                        break;
                    case 2:
                        realizarCirurgia();
                        break;
                    case 0:
                        System.out.println("Você saiu do sistema");
                        atendimentoAtivo = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Entrada inválida, selecione uma opção válida!");
                }

            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            iniciarSistemaMedico(pacientes, medico, atendimentoAtivo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void imprimeMenuInicial() {
        System.out.println();
        System.out.println("Quem está acessando o sistema?");
        System.out.println("1 - Medico");
        System.out.println("2 - Atendente");
        System.out.println("0 - Sair do sistema.");
        System.out.println();
    }

    public static Medico buscarMedico(List<Medico> medicos) {
        Medico medicoTeste;
        System.out.println();
        System.out.println("Digite o CRM do médico!");
        String crm = scan.next();
        System.out.println();
        medicoTeste = verificaMedico(medicos, crm);
        return medicoTeste;
    }

    public static Atendente buscarAtendente(List<Atendente> atendentes) {
        Atendente atendenteTeste;
        System.out.println();
        System.out.println("Digite o cpf do atendente!");
        String cpf = scan.next();
        System.out.println();
        atendenteTeste = verificaAtendente(atendentes, cpf);
        return atendenteTeste;
    }

    public static Paciente buscarPaciente(List<Paciente> pacientes) {
        Paciente pacienteTeste;
        System.out.println();
        System.out.println("Digite o cpf do paciente!");
        String cpf = scan.next();
        System.out.println();
        pacienteTeste = verificaPaciente(pacientes, cpf);
        return pacienteTeste;
    }

    public static void imprimeMenulAtendente() {
        System.out.println();
        System.out.println("Escolha uma operação");
        System.out.println("1 - Realizar novo atendimento.");
        System.out.println("2 - Buscar Status de um paciente.");
        System.out.println("3 - Reservar sala.");
        System.out.println("4 - Buscar atendimentos.");
        System.out.println("0 - Voltar");
        System.out.printf("Operação: ");
        System.out.println();
    }


    public static void imprimeMenuMedico() {
        System.out.println();
        System.out.println("Escolha uma operação");
        System.out.println("1 - Realizar novo Diagnostico.");
        System.out.println("2 - Realizar Cirurgia.");
        System.out.println("0 - Voltar");
        System.out.printf("Operação: ");
        System.out.println();
    }

    public static Paciente cadastrarAtendimento(Atendente atendente, List<Atendimento> atendimentos, List<Paciente> pacientes) {

        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scan.next();

        System.out.println("Digite o cpf do paciente:");
        String cpf = scan.next();

        System.out.println("Digite a idade do paciente:");
        String idade = scan.next();

        System.out.println("Digite o telefone do paciente:");
        String telefone = scan.next();

        System.out.println("Digite o email do paciente:");
        String email = scan.next();

        System.out.println("Digite a rua, número e bairro da residência do paciente:");
        String enderecoCompleto = scan.next();

        System.out.println("Digite o tipo da residência do paciente:");
        String tipoDaResidencia = scan.next();

        System.out.println("Digite o Estado do paciente:");
        String estado = scan.next();

        System.out.println("Cadastro realizado com sucesso!");
        System.out.println();
        Endereco endereco = new Endereco(enderecoCompleto, tipoDaResidencia, estado);
        Contato contato = new Contato(telefone, email);

        Atendimento atendimento = new Atendimento(atendente);
        atendimentos.add(atendimento);

        if (verificaCpf(pacientes, cpf)) {
            Paciente paciente = new Paciente(nomePaciente, cpf, idade, endereco, contato);
            System.out.println("\n Tecle enter para continuar! \n");
            scan.nextLine();
            return paciente;
        }

        return null;
    }

    public static void buscarStatus(Atendente atendente, List<Paciente> array) {

        String cpf;
        System.out.println("Digite o cpf do paciente!");
        cpf = scan.next();
        System.out.println();
        atendente.retornarStatusDoPaciente(cpf, array);
    }

    public static Reserva cadastrarReservaDeSala
            (List<Medico> medicos, List<Sala> salas, List<Reserva> reservas) {

        System.out.println("Digite o numero da sala a ser reservada!");
        Sala sala = new Sala(scan.next());
        System.out.println("Digite o crm do médico que vai usar a sala!");
        String crm = scan.next();
        System.out.println("Digite a data que a sala será usada!");
        String data = scan.next();

        try {
            Medico medicoTeste = verificaMedico(medicos, crm);
            Reserva reservaTeste = verificaReserva(reservas, data, sala, medicoTeste);
            System.out.println("Sala reservada com sucesso!");
            System.out.println();
            return reservaTeste;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

    static Scanner scan = new Scanner(System.in);
}
