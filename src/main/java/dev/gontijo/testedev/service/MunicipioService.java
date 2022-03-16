package dev.gontijo.testedev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.gontijo.testedev.model.Municipio;
import dev.gontijo.testedev.repository.MunicipioRepository;

@Service
public class MunicipioService {
	
	@Autowired
	MunicipioRepository repository;

	public Page<Municipio> listar(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	public Page<Municipio> listarPorEstado(int page, int size, Long id){
		Pageable pageable = PageRequest.of(page, size);
		return repository.findByEstadoId(pageable, id);
	}

	public Page<Municipio> listarPorNome(int page, int size, String nome) throws Exception {
		Pageable pageable = PageRequest.of(page, size);
		if(nome.length() < 3) {
			throw new Exception("Nome não pode ser menor do que 3");
		}
		return repository.findByNomeContaining(pageable, nome);
	}
	
	public Long contarMunicipios() {
		return repository.count();
	}
	
	public Municipio salvar(Municipio municipio) {
		return repository.save(municipio);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

}
