package com.joaquin.comandas;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "tipo"
		)
@JsonSubTypes({
	@JsonSubTypes.Type(value = Hamburguesa.class, name = "hamburguesa"),
	@JsonSubTypes.Type(value = Bebida.class, name = "bebida"),
	@JsonSubTypes.Type(value = Entrante.class, name = "entrante"),
	@JsonSubTypes.Type(value = Guarnicion.class, name = "guarnicion"),
	@JsonSubTypes.Type(value = Postre.class, name = "postre"),
})
public abstract class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private double precio;
	
	public Producto() {
		
	}
	
	public Producto (String nombre,double precio ){
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
