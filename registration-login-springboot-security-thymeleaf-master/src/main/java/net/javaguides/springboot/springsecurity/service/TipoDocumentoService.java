package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import net.javaguides.springboot.springsecurity.model.TipoDocumento;

public interface TipoDocumentoService {

	List<TipoDocumento> findAllDocumentType();
}
