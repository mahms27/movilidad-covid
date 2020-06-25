package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.javaguides.springboot.springsecurity.web.dto.ParametricasDTO;



public interface ParametricasServices {

	Page<ParametricasDTO> paginated(Pageable pageable,ParametricasDTO p);
	
	ParametricasDTO save(ParametricasDTO pDTO);
	
	List<ParametricasDTO>  findAll();
	
	ParametricasDTO findById(Integer id);
	
	
}
