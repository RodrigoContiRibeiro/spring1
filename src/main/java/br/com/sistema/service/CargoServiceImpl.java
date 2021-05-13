package br.com.sistema.service;

import br.com.sistema.models.Cargo;
import br.com.sistema.repository.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepo cargoRepo;

    @Override
    public List<Cargo> findAll() {
        return cargoRepo.findAll();
    }

    @Override
    public boolean save(Cargo cargo) {
        cargoRepo.save(cargo);
        return true;
    }
}
