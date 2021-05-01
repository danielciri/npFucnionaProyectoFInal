package site.danielcirilo.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.IClienteService;
import site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento;
import site.danielcirilo.springboot.app.utils.PageRender;
import site.danielcirilo.springboot.app.validation.ClienteValidador;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private ClienteValidador validador;

	@RequestMapping(value = "/listadoClientes")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page ,Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		PageRender<Cliente> pageRender = new PageRender<>("/listadoClientes",clientes);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);

		return "vistas/clientes/clienteListar";
	}

	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Alta nuevo cliente");
		model.addAttribute("cliente", cliente);
		return "vistas/clientes/form";
	}

	@ModelAttribute("TipoDocumento")
	public TipoDocumento[] tipoDocumentos() {
		return TipoDocumento.values();
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) {
		validador.validate(cliente, result);

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Alta nuevo cliente");
			return "vistas/clientes/form";

		}
		String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con exito!" : "Cliente añadido con exito!";

		clienteService.save(cliente);
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listadoClientes";

	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Cliente cliente = null;
		if (id > 0) {
			flash.addFlashAttribute("error", "No hemos encontrado ninguna coincidencia");
			cliente = clienteService.findOne(id);
		} else {
			flash.addFlashAttribute("error", "No hemos encontrado ninguna coincidencia");

			return "redirect:listadoClientes";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		return "vistas/clientes/form";

	}

}
