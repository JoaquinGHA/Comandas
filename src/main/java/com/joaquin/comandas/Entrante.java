package com.joaquin.comandas;

import jakarta.persistence.Entity;

@Entity
public class Entrante extends Producto {
	
	public Entrante() {
		
	}
	public Entrante(String nombre, double precio) {
		super(nombre, precio);
	}

}
