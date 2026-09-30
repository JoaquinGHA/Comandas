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
@RequestMapping ("/productos")
public class ProductoController {
	
private final ProductoService service;
	
	public ProductoController (ProductoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Producto> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Producto buscarPorid(@PathVariable int id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public Producto crear(@RequestBody Producto producto) {
		return service.guardar(producto);
	}
	
	@PutMapping("/{id}")
	public Producto actualizar(@PathVariable int id, @RequestBody Producto producto) {
		return service.actualizar(id, producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminarPorId(id);
	}

}
