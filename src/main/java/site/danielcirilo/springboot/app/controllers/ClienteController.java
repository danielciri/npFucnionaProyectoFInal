package site.danielcirilo.springboot.app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.IClienteService;
import site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento;
import site.danielcirilo.springboot.app.validation.ClienteValidador;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private ClienteValidador validador;

	@RequestMapping(value = "menu")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());

		return "clienteListar";
	}

	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Alta nuevo cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}

	@ModelAttribute("TipoDocumento")
	public TipoDocumento [] tipoDocumentos() {
		return TipoDocumento.values();
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		validador.validate(cliente, result);
			
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Alta nuevo cliente");
			return "form";
		} else {
			clienteService.save(cliente);
			return "redirect:menu";
		}

	}

}
