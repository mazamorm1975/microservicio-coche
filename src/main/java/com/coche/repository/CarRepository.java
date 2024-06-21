package com.coche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.coche.models.Carro;

public interface CarRepository extends JpaRepository<Carro, Integer> {

		List<Carro> findByUsuarioId(int id);
}
