package com.coche.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coche.models.Carro;
import com.coche.repository.CarRepository;
import com.coche.service.CarService;

@Service
public class CarServiceImpl implements  CarService{

	@Autowired
	private CarRepository carRepo;
	
	@Override
	public Carro registrar(Carro car) {
		return carRepo.save(car);
	}

	@Override
	public List<Carro> listadoTodosLosCarros() {
		List<Carro> listadoCompleto = carRepo.findAll();
		return listadoCompleto;
	}

	@Override
	public Carro busquedaPorId(int id) {
		
		Optional<Carro> car = carRepo.findById(id);
				
		return car.isPresent() ? car.get() :  new Carro();
	}

	@Override
	public List<Carro> busquedaPorUsuarioId(int id) {
		
		return carRepo.findByUsuarioId(id);
	}

}
