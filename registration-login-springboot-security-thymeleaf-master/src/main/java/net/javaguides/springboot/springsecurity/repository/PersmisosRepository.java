package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.springsecurity.model.Permisos;


public interface PersmisosRepository extends JpaRepository<Permisos, Long>{
	
	Permisos findByCedula(String cedula);
	
	 @Query(value = "select * from movilidad.permisos where cedula = ?1 and tipo_documento =?2", nativeQuery = true)
	List<Permisos> findByIdentification(String identification, String tipoDocumento);

}
