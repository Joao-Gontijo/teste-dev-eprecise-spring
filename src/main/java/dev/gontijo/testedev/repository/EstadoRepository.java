package dev.gontijo.testedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.gontijo.testedev.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
