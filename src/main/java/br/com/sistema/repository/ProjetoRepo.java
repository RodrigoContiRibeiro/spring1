package br.com.sistema.repository;

import br.com.sistema.models.Funcionario;
import br.com.sistema.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepo extends JpaRepository<Projeto, Long> {
    Projeto findByNome(String nome);
}
