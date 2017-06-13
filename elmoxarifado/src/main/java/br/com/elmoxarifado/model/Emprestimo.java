package br.com.elmoxarifado.model;

public class Emprestimo {
    private int matriculaFuncionario;
    private int ferramentaId;
    private long inicio;
    private long validade;

    public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public int getFerramentaId() {
        return ferramentaId;
    }

    public void setFerramentaId(int ferramentaId) {
        this.ferramentaId = ferramentaId;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getValidade() {
        return validade;
    }

    public void setValidade(long validade) {
        this.validade = validade;
    }    
}

