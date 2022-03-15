package dev.gontijo.testedev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gontijo.testedev.model.Estado;
import dev.gontijo.testedev.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoService service;
	
	@GetMapping
	public List<Estado> getEstados(){
		return service.listar();
	}
	
	@PostMapping
	public Estado postEstado(@RequestBody Estado estado) {
		return service.salvar(estado);
	}
	
	@PutMapping
	public Estado updateEstado(@RequestBody Estado estado) {
		return service.salvar(estado);
	}
	
	@DeleteMapping
	public void deleteEstado(@RequestBody Estado estado) {
		service.deletar(estado);
	}
}
