package site.danielcirilo.springboot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.danielcirilo.springboot.app.models.entity.Abogado;
import site.danielcirilo.springboot.app.models.entity.Caso;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.entity.Servicio;
import site.danielcirilo.springboot.app.models.services.IAbogadoService;
import site.danielcirilo.springboot.app.models.services.ICasoService;
import site.danielcirilo.springboot.app.models.services.IClienteService;
import site.danielcirilo.springboot.app.models.services.IServicioService;

@Controller
public class CasoController {
	
	@Autowired
	private ICasoService casoService;
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IAbogadoService abogadoService;
	
	@RequestMapping(value = "/listaCasos")
	public String listarCasos(Model model) {
		model.addAttribute("titulo", "Listado casos");
		model.addAttribute("casos", casoService.findAll());
		return "/vistas/casos/listar";
	}
	
	
	@RequestMapping(value = "/registrarCaso")
	public String crear(Model model) {
		Caso caso = new Caso();
		model.addAttribute("titulo","Registro nuevo caso");
		model.addAttribute("caso", caso);
		return "vistas/casos/form";
	}
	
	@ModelAttribute("listadoClientes")
	public List<Cliente> listaClientes(){
		return clienteService.findAll();
	}
	@ModelAttribute("listadoAbogados")
	public List<Abogado> listaAbogados(){
		return abogadoService.findAll();
	}
	@ModelAttribute("servicios")
	public List<Servicio> servicios(){
		return servicioService.findAll();
	}
	
	
	@RequestMapping(value = "/registrarCaso", method = RequestMethod.POST)
	public String guardar(@Valid Caso caso, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Registro nuevo caso");
			return "vistas/casos/form";
		}else {
			casoService.save(caso);
			return "redirect:listaCasos";
		}
		
	}
	
	@RequestMapping(value = "/registrarCaso/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model,RedirectAttributes flash) {
		Caso caso= null;
		if(id > 0 ) {
			caso = casoService.findOne(id);
			
		}else {
			return "redirect:listaCasos";
		}
		model.addAttribute("caso", caso);
		model.addAttribute("titulo", "Editar caso");
		return "vistas/casos/form";
		
		
	}
	
	

}
