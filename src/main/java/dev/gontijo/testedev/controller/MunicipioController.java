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

import dev.gontijo.testedev.model.Municipio;
import dev.gontijo.testedev.service.MunicipioService;
import io.swagger.annotations.Api;

@RestController
@Api("/municipios")
@RequestMapping("/municipios")
public class MunicipioController {
	
	@Autowired
	MunicipioService service;
	
	@GetMapping
	public Page<Municipio> listar(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size){
		return service.listar(page, size);
	}
	
	
	@GetMapping("/{id}")
	public Page<Municipio> listarPorEstado(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "id", required = true) Long id){
		return service.listarPorEstado(page, size, id);
	}
	
	@GetMapping("/quantidade")
	public Long quantidadeMunicipios() {
		return service.contarMunicipios();
	}
	
	
	@GetMapping("/{nome}")
	public Page<Municipio> listaPorNome(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "nome", required = true) String nome) throws Exception{
		return service.listarPorNome(page, size, nome);
	}
	
	@PostMapping
	public Municipio postMunicipio(@RequestBody Municipio municipio) {
		return service.salvar(municipio);
	}
	
	@PutMapping
	public Municipio putMunicipio(@RequestBody Municipio municipio) {
		return service.salvar(municipio);
	}
	
	@DeleteMapping
	public void deleteMunicipio(@RequestBody Long id) {
		service.deletar(id);
	}
	
}
