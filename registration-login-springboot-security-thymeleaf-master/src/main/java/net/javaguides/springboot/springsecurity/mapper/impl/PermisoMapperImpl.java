package net.javaguides.springboot.springsecurity.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.mapper.PermisosMapper;
import net.javaguides.springboot.springsecurity.model.Permisos;
import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;

@Service
public class PermisoMapperImpl implements  PermisosMapper{

	@Override
	public PermisosDTO convertToDto(Permisos p) {
		PermisosDTO pDto  = null;
		if(p != null) {
			ModelMapper modelMapper = new ModelMapper();
			pDto = modelMapper.map(p, PermisosDTO.class);
		}
		return pDto;
	}

	@Override
	public List<PermisosDTO> convertToDtoList(List<Permisos> permisos) {
		ModelMapper modelMapper = new ModelMapper();
		List<PermisosDTO> listaPermisos = new ArrayList<>();
		for(Permisos p: permisos) {
			PermisosDTO permiso = modelMapper.map(p, PermisosDTO.class);
			listaPermisos.add(permiso);
		}
		return listaPermisos;
	}

	@Override
	public Permisos toEntity(PermisosDTO pDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Permisos pVO = modelMapper.map(pDTO, Permisos.class);		
		return pVO;
	}

}
