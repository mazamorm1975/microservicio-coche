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
import com.coche.service.CarService;
import com.coche.serviceImplementation.CarServiceImpl;

@RestController
@RequestMapping("/coche")
public class CarController {

	// se establece el id para identificador
	private static final String ID = "id";
	@Autowired
	private CarService carService;

	// Api Rest para ingresar registro de automovil a la base de datos
	// microservice_coche
	@PostMapping("/ingresar")
	public ResponseEntity<Carro> registrarVehiculo(@RequestBody Carro carbody) {
     
		Carro brandNewCar = carService.registrar(carbody);

		return new ResponseEntity<Carro>(brandNewCar, HttpStatus.CREATED);
	}

	
	//Api Rest para ubicar por id del coche de la base de datos microservice_coche
	//SE AGREGA LINEA DE TEST TERCIArioxxx
	@GetMapping("/{id}")
	public ResponseEntity<List<Carro>> buscarPorId(@PathVariable(ID) int id) {

		Carro car = carService.busquedaPorId(id);

		if (car != null) {

			// Se convierte a lista lo que devuelve el metodo busquedaPorId en el que se
			// implementa un optional
			List<Carro> car2 = Arrays.asList(carService.busquedaPorId(id));

			return new ResponseEntity<List<Carro>>(car2, HttpStatus.OK);
		}

		return new ResponseEntity<List<Carro>>(HttpStatus.NOT_FOUND);
	}

	// Api Rest para obtener el listado general de TODOS los automoviles de la base
	// de datos microservice_coche
	@GetMapping("/busqueda_general")
	public ResponseEntity<List<Carro>> listadoCompleto() {
		List<Carro> listaTotalInventario = carService.listadoTodosLosCarros();
		return new ResponseEntity<List<Carro>>(listaTotalInventario, HttpStatus.OK);
	}

	@GetMapping("/busquedaPorUsuarioId/{usuarioId}")
	public ResponseEntity<List<Carro>> listadoCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId) {

		List<Carro> listaTodosLosCarrosDeUnUsuario = carService.busquedaPorUsuarioId(usuarioId);

		return new ResponseEntity<List<Carro>>(listaTodosLosCarrosDeUnUsuario, HttpStatus.OK);
	}

}
