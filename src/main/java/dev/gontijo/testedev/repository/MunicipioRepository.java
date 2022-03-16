package dev.gontijo.testedev.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.gontijo.testedev.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

	Page<Municipio> findByEstadoId(Pageable page, Long id);

	Page<Municipio> findByNomeContaining(Pageable pageable, String nome);

}
