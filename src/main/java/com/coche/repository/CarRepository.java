package com.coche.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coche.models.Carro;

public interface CarRepository extends JpaRepository<Carro, Integer> {

		List<Carro> findByUsuarioId(int id);
}
