package br.com.sistema.service;

import br.com.sistema.models.Cargo;
import br.com.sistema.repository.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepo cargoRepo;

    @Override
    public List<Cargo> findAll() {
        return cargoRepo.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    @Override
    public Cargo findById(Long id) {
        return cargoRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        cargoRepo.deleteById(id);
    }

    @Override
    public Cargo findByNome(String nome) {
        return cargoRepo.findByNome(nome);
    }

    @Override
    public String validarCargo(Cargo cargo) {
        ArrayList<String> erros = new ArrayList<>();
        String erro = "";
        if (cargo.getId() != null) {
            if (!findById(cargo.getId()).getNome().equals(cargo.getNome())) {
                if (findByNome(cargo.getNome()) != null) {
                    erros.add("Cargo já cadastrado");
                }
            }
        } else {
            if (findByNome(cargo.getNome()) != null) {
                erros.add("Cargo ja cadastrado");
            }
        }
        erro = StringUtils.join(erros, ",");
        return erro;
    }

    @Override
    public boolean save(Cargo cargo) {
        try {
            if (cargo != null) {
                cargoRepo.save(cargo);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
