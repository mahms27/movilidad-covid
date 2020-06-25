package net.javaguides.springboot.springsecurity.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.mapper.ParametricasMapper;
import net.javaguides.springboot.springsecurity.model.Parametricas;
import net.javaguides.springboot.springsecurity.web.dto.ParametricasDTO;

@Service
public class ParametricasMapperImpl implements ParametricasMapper{

	@Override
	public ParametricasDTO convertToDto(Parametricas p) {
		ParametricasDTO pDto  = null;
		if(p != null) {
			ModelMapper modelMapper = new ModelMapper();
			pDto = modelMapper.map(p, ParametricasDTO.class);
		}
		return pDto;
	}

	@Override
	public List<ParametricasDTO> convertToDtoList(List<Parametricas> pa) {
		ModelMapper modelMapper = new ModelMapper();
		List<ParametricasDTO> lista = new ArrayList<>();
		for(Parametricas p: pa) {
			ParametricasDTO pDTO = modelMapper.map(p, ParametricasDTO.class);
			lista.add(pDTO);
		}
		return lista;
	}

	@Override
	public Parametricas toEntity(ParametricasDTO pDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Parametricas pVO = modelMapper.map(pDTO, Parametricas.class);		
		return pVO;
	}

}
