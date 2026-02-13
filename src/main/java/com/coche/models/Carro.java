package com.coche.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Coche")
public class Carro {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modelo")
	private String modelo;
	
	//Se implementa el atributo usuarioId
	@Column(name="usuarioId")
	private int usuarioId;
	
}
