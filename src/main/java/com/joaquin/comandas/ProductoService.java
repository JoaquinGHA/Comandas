package com.joaquin.comandas;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	private final ProductoRepository repo;
	
	public ProductoService(ProductoRepository repo) {
		this.repo = repo;
	}
	
	public List<Producto> listar(){
		
		return repo.findAll();
	}
	
	
	public Producto guardar (Producto p) {
		if(p.getPrecio() < 0) {
			throw new IllegalArgumentException("El precio del producto no puede ser menor que cero");
		}
		return repo.save(p);
	}
	
	public Producto buscarPorId(int id) {
		return repo.findById(id).orElseThrow();
	}
	
	public void eliminarPorId(int id){
		repo.deleteById(id);
	}
	
	public Producto actualizar(int id, Producto datosNuevos) {
		if(datosNuevos.getPrecio() < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		Producto existente = repo.findById(id).orElseThrow();
		
		existente.setPrecio(datosNuevos.getPrecio());
		
		
		return repo.save(existente);
	}
	
	
}
