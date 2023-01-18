package model.endereco;

public class Endereco {

    private String enderecoCompleto;
    private String tipoDaResidencia;
    private String estado;

    public Endereco() {

    }

    public Endereco(String enderecoCompleto, String tipoDaResidencia, String estado) {
        this.enderecoCompleto = enderecoCompleto;
        this.tipoDaResidencia = tipoDaResidencia;
        this.estado = estado;
    }

    public String getenderecoCompleto() {
        return enderecoCompleto;
    }

    public void setenderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getTipoDaResidencia() {
        return tipoDaResidencia;
    }

    public void setTipoDaResidencia(String tipoDaResidencia) {
        this.tipoDaResidencia = tipoDaResidencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return
                "  Endereço completo do paciente: " + enderecoCompleto + '\'' +
                        ", Tipo da residência do paciente: " + tipoDaResidencia + '\'' +
                        ", Estado de origem do paciente: " + estado + '\'' +
                        '}';
    }
}
