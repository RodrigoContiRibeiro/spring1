package br.com.sistema.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    @NotNull
    private String nome;

    @Size(max = 150)
    @NotNull
    private String descricao;

    @NotNull
    private String status;

    @NotNull
    private String risco;

    @NotNull
    private double orcamento;

    @NotNull
    private Date dtInicio;

    @NotNull
    private Date dtFim;

    @OneToOne
    @JoinColumn(name = "gerente_id", referencedColumnName = "id")
    private Funcionario gerente;

    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "id"))
    private List<Funcionario> funcionarios;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRisco() {
        return risco;
    }
    public void setRisco(String risco) {
        this.risco = risco;
    }
    public double getOrcamento() {
        return orcamento;
    }
    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }
    public Date getDtInicio() {
        return dtInicio;
    }
    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }
    public Date getDtFim() {
        return dtFim;
    }
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }
    public Funcionario getGerente() {
        return gerente;
    }
    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", risco='" + risco + '\'' +
                ", orcamento=" + orcamento +
                ", dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                ", gerente=" + gerente +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
