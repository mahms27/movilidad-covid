package net.javaguides.springboot.springsecurity.web;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.springboot.springsecurity.service.ParametricasServices;
import net.javaguides.springboot.springsecurity.service.PermisosServices;
import net.javaguides.springboot.springsecurity.service.TipoDocumentoService;
import net.javaguides.springboot.springsecurity.web.dto.ParametricasDTO;
import net.javaguides.springboot.springsecurity.web.dto.PermisosDTO;
import net.javaguides.springboot.springsecurity.web.dto.ResponseDTO;

@Controller
@RequestMapping("/movilidad")
public class MovilidadController {

    @Autowired
    private PermisosServices pService;
    
    @Autowired
    @Qualifier("parametros")
    private ParametricasServices paService;
    
    @Autowired
    private TipoDocumentoService tdService;

    @GetMapping("/permisos")
    public String index(Model model) {
    	model.addAttribute("permiso", new PermisosDTO());
    	model.addAttribute("tipoDocumento", tdService.findAllDocumentType());
    	model.addAttribute("texto", paService.findById(1).getValor());
        return "index";
    }
    
    @GetMapping("/parametros")
    public String parametric(Model model,@ModelAttribute ParametricasDTO p) {
    	final int currentPage = p.getPage() != null ? p.getPage() : 1;
        final int pageSize = p.getSize() != null ? p.getSize() : 15;
        Page<ParametricasDTO> parametric = paService.paginated(PageRequest.of(currentPage - 1, pageSize), p);
        
        int totalPages = parametric.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("parametric", parametric);
        }else {
        	
        }
        return "parametros";
    }
    
    @RequestMapping(value = "/find-all-parametric", method = RequestMethod.POST)
    public String findParametric(Model model, @ModelAttribute ParametricasDTO p) {
        final int currentPage = p.getPage() != null ? p.getPage() : 1;
        final int pageSize = p.getSize() != null ? p.getSize() : 15;
        Page<ParametricasDTO> parametric = paService.paginated(PageRequest.of(currentPage - 1, pageSize), p);
        
        int totalPages = parametric.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("parametrics", parametric);
        }else {
        	
        }
    	return "fragments/table-parametric";
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
        	model.addAttribute("identificationNumbers", p.getCedula());
        }
    	return "fragments/table-permissions";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String create(Model model, @ModelAttribute PermisosDTO p) {
    	model.addAttribute("permiso", new PermisosDTO());
    	model.addAttribute("tipoDocumento", tdService.findAllDocumentType());
    	 return "create-update";
    }
    
    @RequestMapping(value = "/actualizar-parametro", method = RequestMethod.GET)
    public String updateParametric(Model model, @RequestParam("id") Integer id) {
    	model.addAttribute("parametrica", paService.findById(id));
    	 return "create-update-parameter";
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.GET)
    public String update(Model model, @RequestParam("id") Integer id) {
    	model.addAttribute("permiso", pService.findconsecutive(id));
    	model.addAttribute("tipoDocumento", tdService.findAllDocumentType());
    	 return "create-update";
    }
    
    @RequestMapping(value = "/create-permission", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO create_bussines(@Valid @ModelAttribute PermisosDTO pDTO,
                                BindingResult bindingResult, Model model, HttpServletRequest request) {
    	ResponseDTO response = new ResponseDTO();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
            response.setStatus("-1");
            response.setMessage(bindingResult.getFieldError().getDefaultMessage());
        }else {
        	PermisosDTO permiso = pService.save(pDTO);
            response.setStatus("0");
            response.setMessage("operacion exitosa");
            response.setData(permiso);
        }
        return response;
    }
    
    @RequestMapping(value = "/create-parameter", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO create_parameter(@Valid @ModelAttribute ParametricasDTO pDTO,
                                BindingResult bindingResult, Model model, HttpServletRequest request) {
    	ResponseDTO response = new ResponseDTO();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
            response.setStatus("-1");
            response.setMessage(bindingResult.getFieldError().getDefaultMessage());
        }else {
        	ParametricasDTO permiso = paService.save(pDTO);
            response.setStatus("0");
            response.setMessage("operacion exitosa");
            response.setData(permiso);
        }
        return response;
    }
}
