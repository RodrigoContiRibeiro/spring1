package br.com.sistema.repository;

import br.com.sistema.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);

    Funcionario findByTelefone(String telefone);

    @Query(value = "select f.* from funcionario f inner join cargo c on f.cargo_id=c.id where c.nome regexp '(Gerente)'", nativeQuery = true)
    List<Funcionario> findGerentes();

    @Query(value = "select f.* from funcionario f inner join cargo c on f.cargo_id=c.id where c.nome not regexp '(Gerente)'", nativeQuery = true)
    List<Funcionario> findNotGerentes();

    @Query(value = "SELECT f.* FROM projeto_funcionario pf inner join funcionario f on pf.funcionario_id=f.id WHERE projeto_id = ?1 order by f.id", nativeQuery = true)
    List<Funcionario> findByProjeto(long id);
}
