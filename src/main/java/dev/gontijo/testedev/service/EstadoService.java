package dev.gontijo.testedev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gontijo.testedev.model.Estado;
import dev.gontijo.testedev.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	
	public Estado salvar(Estado estado) {
		return repository.save(estado);
	}
	
	public void deletar(Estado estado) {
		repository.delete(estado);
	}
	
	public List<Estado> listar(){
		return repository.findAll();
	}
}
