package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.TipoDocumento;


public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{

	List<TipoDocumento> findAll();
}
