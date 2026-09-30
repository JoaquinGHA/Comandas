package com.joaquin.comandas;

import jakarta.persistence.Entity;

@Entity
public class Postre extends Producto {
	
	public Postre(){
		
	}
	public Postre(String nombre, double precio){
		super(nombre, precio);
	}

}


