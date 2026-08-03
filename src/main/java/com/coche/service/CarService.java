package com.coche.service;

import java.io.IOException;
import java.util.List;

import com.coche.models.Carro;
import org.springframework.stereotype.Service;


@Service
public interface CarService {

	Carro registrar(Carro car) throws IOException;
	List<Carro> listadoTodosLosCarros();
	Carro busquedaPorId(int id);
	List<Carro> busquedaPorUsuarioId(int id);
}
