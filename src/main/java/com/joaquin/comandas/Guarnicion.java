package com.joaquin.comandas;

import jakarta.persistence.Entity;

@Entity
public class Guarnicion extends Producto {
	
	public Guarnicion () {
		
	}
	public Guarnicion (String nombre, double precio) {
		super(nombre, precio);
	}
	
	

}
