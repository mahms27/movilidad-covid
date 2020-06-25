package net.javaguides.springboot.springsecurity.mapper;

import java.util.List;

import net.javaguides.springboot.springsecurity.model.Parametricas;
import net.javaguides.springboot.springsecurity.web.dto.ParametricasDTO;


public interface ParametricasMapper {
	
	ParametricasDTO convertToDto(Parametricas p);
	
	List<ParametricasDTO> convertToDtoList(List<Parametricas> permisos);
	
	Parametricas toEntity(ParametricasDTO pDTO); 

}
