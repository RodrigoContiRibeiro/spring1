package br.com.sistema.repository;

import br.com.sistema.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);

    Funcionario findByTelefone(String telefone);
}
