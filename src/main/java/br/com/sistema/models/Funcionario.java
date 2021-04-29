package br.com.sistema.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "funcionario")
public class Funcionario {
    //Usando validataion para criar atributos tipados e modelados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=80)
    @NotNull
    private String nome;

    @Size(max=100)
    @NotNull
    private String email;

    @Size(max=50)
    @NotNull
    private String telefone;

    //Getters & Setters
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    //ToString sobrecarregado
    @Override
    public String toString() {
        return "Funcionario: " +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nEmail: " + email +
                "\nTelefone: " + telefone;

    }
}
