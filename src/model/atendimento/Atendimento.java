package model.atendimento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.pessoas.funcionarios.atendente.Atendente;

public class Atendimento {

    private String dataAtendimento;
    private Atendente atendenteResponsavel;

    public Atendimento(Atendente atendenteResponsavel) {
        this.atendenteResponsavel = atendenteResponsavel;
        this.dataAtendimento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public Atendente getAtendenteResponsavel() {
        return atendenteResponsavel;
    }

    public static void getAtendimentos(List<Atendimento> atendimentos) {
        if (atendimentos.size() != 0) {
            for (int i = 0; i < atendimentos.size(); i++) {
                System.out.println(atendimentos.get(i));
            }
        } else {
            System.out.println(" Não existem atendimentos cadastrados");
        }
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "\n Data do atendimento: '" + dataAtendimento + '\'' +
                ", \n Atendente responsavel: " + atendenteResponsavel.getNome() +
                '}';
    }
}
