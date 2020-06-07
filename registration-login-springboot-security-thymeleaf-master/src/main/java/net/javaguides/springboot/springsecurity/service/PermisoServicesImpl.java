package net.javaguides.springboot.springsecurity.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.springsecurity.mapper.impl.PermisoMapperImpl;
import net.javaguides.springboot.springsecurity.model.Permisos;
import net.javaguides.springboot.springsecurity.repository.PersmisosRepository;
import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;


@Service
@Transactional
public class PermisoServicesImpl implements PermisosServices{

	@Autowired
	private PersmisosRepository repo;
	
	@Autowired
	private PermisoMapperImpl mapper;
	
    @PersistenceContext
    private EntityManager em;
	
	@Override
	public PermisosDTO findByCedula(String cedula) {		
		return mapper.convertToDto(repo.findByCedula(cedula));
	}
	
	@Override
	public List<PermisosDTO> findIdentification(String identification, String tipoDocumento) {		
		return mapper.convertToDtoList(repo.findByIdentification(identification, tipoDocumento));
	}
	
	@Override
	public Page<PermisosDTO> paginated(Pageable pageable, PermisosDTO p) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<PermisosDTO> permission = findIdentification(p.getCedula(),p.getTipoDocumento());
        List<PermisosDTO> list;
        if (permission.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, permission.size());
            list = permission.subList(startItem, toIndex);
        }
        Page<PermisosDTO> permissionPage
        = new PageImpl<PermisosDTO>(list, PageRequest.of(currentPage, pageSize), permission.size());
        
		return permissionPage;
	}

	@Override
    @Transactional
	public PermisosDTO save(PermisosDTO pDTO) {
		PermisosDTO pDToResponse = null;
		try {
			Permisos pVo = mapper.toEntity(pDTO);
			if(pVo.getConsecutivo() == null) {
				em.persist(pVo);
			}else {
				em.merge(pVo);
			}
			pDToResponse = mapper.convertToDto(pVo);
		} catch (Exception e) {
			System.out.print(e);
		}
		return pDToResponse;
	}

	@Override
	public PermisosDTO findconsecutive(Integer cons) {
		return mapper.convertToDto(repo.findByConsecutive(cons));
	}



	
}
