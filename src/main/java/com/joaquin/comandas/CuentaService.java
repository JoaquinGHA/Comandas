package com.joaquin.comandas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CuentaService {
	
	private final CuentaRepository cuentaRepo;
	private final ProductoRepository productoRepo;
	
	public CuentaService (CuentaRepository cuentaRepo, ProductoRepository productoRepo) {
		this.cuentaRepo = cuentaRepo;
		this.productoRepo = productoRepo;
	}
	
	
	public List<Cuenta> listar(){
		return cuentaRepo.findAll();
	}
	
	
	public Cuenta buscarPorId(int id) {
		return cuentaRepo.findById(id).orElseThrow();
	}
	
	public double calcularTotal(int id) {
		Cuenta cuenta = cuentaRepo.findById(id).orElseThrow();
		
		double total = 0;
		for(Producto p : cuenta.getProductos()) {
			
			total = total + p.getPrecio();
			
			if(p instanceof Hamburguesa h) {
				for(Extra e : h.getExtras()) {
					total = total + e.getPrecio();
				}
			}
			
		}
		
		
		
		return total;
	}
	
	public void eliminarPorId(int id) {
		cuentaRepo.deleteById(id);
	} 
	
	
	public Cuenta crear (List<Integer> idsProductos) {
		
		Cuenta cuenta = new Cuenta();
		List<Producto> productos = new ArrayList<>();
		
		
		
		for(Producto p : productoRepo.findAllById(idsProductos)) {
			
			productos.add(p);
			
		
		}
		cuenta.setProductos(productos);
		return cuentaRepo.save(cuenta);
		
		
		
		
	}
	
	public Cuenta añadirProductos (int idCuenta, int idProducto) {
		Cuenta cuenta = cuentaRepo.findById(idCuenta).orElseThrow();
		Producto producto = productoRepo.findById(idProducto).orElseThrow();
		 
		cuenta.getProductos().add(producto);
		
		return cuentaRepo.save(cuenta);
		
		
	}

}
