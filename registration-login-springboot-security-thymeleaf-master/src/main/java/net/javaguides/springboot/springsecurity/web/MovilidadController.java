package net.javaguides.springboot.springsecurity.web;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.javaguides.springboot.springsecurity.service.PermisosServices;
import net.javaguides.springboot.springsecurity.service.TipoDocumentoService;
import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;

@Controller
public class MovilidadController {

    @Autowired
    private PermisosServices pService;
    
    @Autowired
    private TipoDocumentoService tdService;
	
    @GetMapping("/movilidad")
    public String root(
    		Model model, @ModelAttribute PermisosDTO bussines) {
    	
    	model.addAttribute("permiso", new PermisosDTO());
    	model.addAttribute("tipoDocumento", tdService.findAllDocumentType());
        return "index";
    }

    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("permiso", new PermisosDTO());
    	model.addAttribute("tipoDocumento", tdService.findAllDocumentType());
        return "index";
    }
    
    @RequestMapping(value = "/find-permission", method = RequestMethod.POST)
    public String findPermission(Model model, @ModelAttribute PermisosDTO p) {
        final int currentPage = p.getPage() != null ? p.getPage() : 1;
        final int pageSize = p.getSize() != null ? p.getSize() : 15;
        Page<PermisosDTO> permission = pService.paginated(PageRequest.of(currentPage - 1, pageSize), p);
        
        int totalPages = permission.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("permisos", permission);
        }else {
        	
        }
    	return "fragments/table-permissions";
    }

}
