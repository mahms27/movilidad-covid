package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;


public interface PermisosServices {
	
	PermisosDTO findByCedula(String cedula);
	
	List<PermisosDTO> findIdentification(String idenNum, String docType);
	
	Page<PermisosDTO> paginated(Pageable pageable,PermisosDTO p);
	
	PermisosDTO save(PermisosDTO pDTO);
	
	PermisosDTO  findconsecutive(Integer cons);
}
