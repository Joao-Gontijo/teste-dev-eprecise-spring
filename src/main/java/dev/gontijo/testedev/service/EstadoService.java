package dev.gontijo.testedev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Estado> listar(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
}
