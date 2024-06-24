package com.coche.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coche.models.Carro;
import com.coche.serviceImplementation.CarServiceImpl;

@RestController
@RequestMapping("/coche")
public class CarController {

	@Autowired
	private CarServiceImpl carServiceImpl;

	//Api Rest para ingresar registro de automovil a la base de datos microservice_coche
	@PostMapping("/ingresar")
	public ResponseEntity<Carro> registrarVehiculo(@RequestBody Carro carbody){
				
		Carro brandNewCar = carServiceImpl.registrar(carbody);	
		
		return new ResponseEntity<Carro>(brandNewCar, HttpStatus.CREATED);
	}

	
	//Api Rest para ubicar por id del coche de la base de datos microservice_coche
	@GetMapping("/{id}")
	public ResponseEntity<List<Carro>> buscarPorId(@PathVariable("id") int id){
		
		Carro car = carServiceImpl.busquedaPorId(id);
		
		if(car != null) {
		 
		List<Carro> car2 = Arrays.asList(carServiceImpl.busquedaPorId(id));
		
		  return new ResponseEntity<List<Carro>>(car2, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Carro>>(HttpStatus.NOT_FOUND);
	}
	
	//Api Rest para obtener el listado general de TODOS los automoviles de la base de datos microservice_coche
	@GetMapping("/busqueda_general")
	public ResponseEntity<List<Carro>> listadoCompleto(){
		
		List<Carro> listaTotalInventario = carServiceImpl.listadoTodosLosCarros();
		return new ResponseEntity<List<Carro>>(listaTotalInventario, HttpStatus.OK);
	}
	
	
	@GetMapping("/busquedaPorUsuarioId/{usuarioId}")
	public ResponseEntity<List<Carro>> listadoCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
		
		List<Carro> listaTodosLosCarrosDeUnUsuario = carServiceImpl.busquedaPorUsuarioId(usuarioId);
		
	return new ResponseEntity<List<Carro>>(listaTodosLosCarrosDeUnUsuario, HttpStatus.OK);
	}
	
	
	
}
