package com.joaquin.comandas;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Hamburguesa extends Producto {
	
	private String puntoCarne;
	private String tipoPan;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Extra> extras;
	@ManyToOne
	private Guarnicion guarnicion;
	
	
	public Hamburguesa() {}
	
	public Hamburguesa(String nombre, double precio, String puntoCarne, String tipoPan, List<Extra> extras, Guarnicion guarnicion) {
		super(nombre, precio);
		this.puntoCarne = puntoCarne;
		this.tipoPan = tipoPan;
		this.extras = extras;
		this.guarnicion = guarnicion;
	}
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}
	public String getPuntoCarne() {
		return puntoCarne;
	}
	public void setPuntoCarne(String puntoCarne) {
		this.puntoCarne = puntoCarne;
	}
	public String getTipoPan() {
		return tipoPan;
	}
	public void setTipoPan(String tipoPan) {
		this.tipoPan = tipoPan;
	}
	public Guarnicion getGuarnicion() {
		return guarnicion;
	}
	public void setGuarnicion(Guarnicion guarnicion) {
		this.guarnicion = guarnicion;
	}
	
	
	
	

}
