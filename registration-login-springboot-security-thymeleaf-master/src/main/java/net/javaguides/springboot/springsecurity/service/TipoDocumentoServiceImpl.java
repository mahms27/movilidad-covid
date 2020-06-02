package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.TipoDocumento;
import net.javaguides.springboot.springsecurity.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	private TipoDocumentoRepository repo;
	
	
	@Override
	public List<TipoDocumento> findAllDocumentType() {		
		return repo.findAll();
	}

}
