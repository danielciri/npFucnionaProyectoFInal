package site.danielcirilo.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.ICitaService;
import site.danielcirilo.springboot.app.models.services.IClienteService;

@Controller
public class CitaController {
	@Autowired
	private ICitaService citaService;
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "/cita")
	public String listar(Model model) {
		
		model.addAttribute("citas",citaService.findAll());
		return "cita";
	}
	
	@RequestMapping(value = "/formCitas", method = RequestMethod.POST)
	public String guardar(Cita cita, BindingResult result,Model model) {
	
			model.addAttribute("titulo", "Anadir nueva cita");
	
			citaService.save(cita);
			return "vistas/citas/formCitas";
		

	}
	
	@RequestMapping(value = "/formCitas")
	public String crear(Model model) {
		Cita cita = new Cita();
		model.addAttribute("titulo", "Alta nueva cita");
		model.addAttribute("cita", cita);
		return "vistas/citas/formCitas";
	}
	
	@ModelAttribute("listaClientes")
	public List<Cliente> clientes() {
		System.out.println(clienteService.findAll().toString());
		return clienteService.findAll();
	}

}
