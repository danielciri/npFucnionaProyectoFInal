package site.danielcirilo.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.IClienteService;

@Controller
public class ClienteController {
	
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "menu")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado clientes");
	
		return "clienteListar";
	}
	
	@RequestMapping(value="/form" )
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Formulario cliente");
		model.put("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value ="form",method = RequestMethod.POST )
	public String guardar(Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:listar";
	}

}
