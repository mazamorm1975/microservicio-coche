package com.coche.service;

import java.util.List;

import com.coche.models.Carro;



public interface CarService {

	Carro registrar(Carro car);
	List<Carro> listadoTodosLosCarros();
	Carro busquedaPorId(int id);
	List<Carro> busquedaPorUsuarioId(int id);
}
