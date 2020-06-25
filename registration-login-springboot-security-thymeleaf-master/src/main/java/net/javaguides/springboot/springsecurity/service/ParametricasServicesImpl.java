package net.javaguides.springboot.springsecurity.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.springsecurity.mapper.impl.ParametricasMapperImpl;
import net.javaguides.springboot.springsecurity.model.Parametricas;
import net.javaguides.springboot.springsecurity.repository.ParametricasRepository;
import net.javaguides.springboot.springsecurity.web.dto.ParametricasDTO;

@Service
@Qualifier("parametros")
public class ParametricasServicesImpl implements ParametricasServices{
	
	@Autowired
	private ParametricasRepository repo;
	
	@Autowired
	private ParametricasMapperImpl mapper;
	
    @PersistenceContext
    private EntityManager em;

	@Override
	public Page<ParametricasDTO> paginated(Pageable pageable, ParametricasDTO p) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<ParametricasDTO> parametric = findAll();
        List<ParametricasDTO> list;
        if (parametric.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, parametric.size());
            list = parametric.subList(startItem, toIndex);
        }
        Page<ParametricasDTO> permissionPage
        = new PageImpl<ParametricasDTO>(list, PageRequest.of(currentPage, pageSize), parametric.size());
        
		return permissionPage;
	}

	@Override
	@Transactional
	public ParametricasDTO save(ParametricasDTO pDTO) {
		ParametricasDTO pDToResponse = null;
		try {
			Parametricas pVo = mapper.toEntity(pDTO);
			if(pVo.getId() == null) {
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
	public List<ParametricasDTO> findAll() {
		return  mapper.convertToDtoList(repo.findAll());
	}

	@Override
	public ParametricasDTO findById(Integer id) {
		return mapper.convertToDto(repo.findById(id));
	}

}
