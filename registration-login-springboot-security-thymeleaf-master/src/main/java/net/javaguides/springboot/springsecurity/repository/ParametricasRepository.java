package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.springsecurity.model.Parametricas;

public interface ParametricasRepository extends JpaRepository<Parametricas, Long>{
	 @Query(value = "select * from movilidad.parametricas ", nativeQuery = true)
	List<Parametricas> findAll();

	 @Query(value = "select * from movilidad.parametricas where id = ?1", nativeQuery = true)
	 Parametricas findById(Integer id);

}
