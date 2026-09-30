package com.joaquin.comandas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
private final CuentaService service;
	
	public CuentaController(CuentaService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Cuenta> listar(){
		return service.listar();
	}
	
	@PutMapping("/{idCuenta}/productos/{idProducto}")
	public Cuenta añadirProducto(@PathVariable int idCuenta, @PathVariable int idProducto) {
		return service.añadirProductos(idCuenta, idProducto);
	}
	
	
	
	@PostMapping
	public Cuenta crear (@RequestBody List<Integer> ids) {
		return service.crear(ids);
	}
	
	@GetMapping("/{id}")
	public Cuenta buscarPorId(@PathVariable int id) {
		return service.buscarPorId(id);
	}
	
	@GetMapping("/{id}/total")
	public double total(@PathVariable int id) {
		return service.calcularTotal(id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPorId(@PathVariable int id) {
		service.eliminarPorId(id);
	}

}
