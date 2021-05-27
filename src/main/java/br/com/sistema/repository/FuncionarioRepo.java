package br.com.sistema.repository;

import br.com.sistema.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);

    Funcionario findByTelefone(String telefone);

    @Query(value = "SELECT * FROM funcionario f WHERE f.projeto_id = ?1", nativeQuery = true)
    List<Funcionario> findByProjeto(long id);
}
