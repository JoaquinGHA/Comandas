package com.joaquin.comandas;

import jakarta.persistence.Entity;

@Entity
public class Bebida extends Producto{
	
	public Bebida () {
		
	}
	
	public Bebida (String nombre, double precio) {
		
		super(nombre, precio);
	}

}
