package net.javaguides.springboot.springsecurity.mapper;

import java.util.List;

import net.javaguides.springboot.springsecurity.model.Permisos;
import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;


public interface PermisosMapper {

	PermisosDTO convertToDto(Permisos p);
	
	List<PermisosDTO> convertToDtoList(List<Permisos> permisos);
}
