package dev.gontijo.testedev.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gontijo.testedev.model.Estado;
import dev.gontijo.testedev.service.EstadoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Estados")
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoService service;
	
	@GetMapping
	public Page<Estado> getEstados(
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "page", defaultValue = "0") int page
			){
		
		return service.listar(page, size);
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
