package br.com.sistema.repository;

import br.com.sistema.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepo extends JpaRepository<Cargo, Long> {
    public Cargo findByNome(String nome);
}
