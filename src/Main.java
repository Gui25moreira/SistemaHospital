import static Control.Sistema.iniciarSistema;

import java.util.ArrayList;

import model.Reserva;
import model.Sala;
import model.atendimento.Atendimento;
import model.contato.Contato;
import model.endereco.Endereco;
import model.pessoas.funcionarios.atendente.Atendente;
import model.pessoas.funcionarios.medicos.ClinicoGeral;
import model.pessoas.funcionarios.medicos.Medico;
import model.pessoas.funcionarios.medicos.Neurocirurgiao;
import model.pessoas.paciente.Paciente;

public class Main {
    public static void main(String[] args) {

        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Atendente> atendentes = new ArrayList<>();
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Atendimento> atendimentos = new ArrayList<>();

        Atendente atendente01 = new Atendente("Guilherme", "07330", "23", new Endereco("Rua", "Casa", "Ceará"),
                new Contato("88999", "guilherme.@"));
        atendentes.add(atendente01);

        Atendente atendente02 = new Atendente("Lucas", "12345678", "24", new Endereco("Rua", "Casa", "Ceará"),
                new Contato("88999", "guilherme.@"));
        atendentes.add(atendente02);

        Medico medico01 = new ClinicoGeral("Guilherme", "0733", "23", new Endereco("Rua", "Casa", "Ceará"),
                new Contato("88999", "guilherme.@"), "123");
        medicos.add(medico01);

        Medico medico02 = new Neurocirurgiao("Gabriel", "07355", "23", new Endereco("Rua", "Casa", "Ceará"),
                new Contato("88999", "guilherme.@"), "1234");
        medicos.add(medico02);

        salas.add(new Sala("1"));
        salas.add(new Sala("2"));
        salas.add(new Sala("3"));
        salas.add(new Sala("4"));
        salas.add(new Sala("5"));

        iniciarSistema(pacientes, medicos, atendentes, salas, reservas, atendimentos);

    }
}
