 package com.coche.serviceImplementation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coche.models.Carro;
import com.coche.repository.CarRepository;
import com.coche.service.CarService;

@Service
public class CarServiceImpl implements  CarService{

	@Autowired
	private CarRepository carRepo;

	private final ElasticsearchClient client;

	public CarServiceImpl(ElasticsearchClient client){
		this.client = client;
	}


		@Override
	public Carro registrar(Carro car) throws IOException {

			Carro dataInMySQL = carRepo.save(car);
			
			client.index( i -> i
					.index("coches")
					.id(String.valueOf(dataInMySQL.getId()))
					.document(dataInMySQL)
			);


			return dataInMySQL;
	}

	@Override
	public List<Carro> listadoTodosLosCarros() {
		List<Carro> listadoCompleto = (List<Carro>) carRepo.findAll();
		return listadoCompleto;
	}

	//Se genera metodo como Optional
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
