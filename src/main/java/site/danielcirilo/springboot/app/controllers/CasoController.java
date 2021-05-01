package site.danielcirilo.springboot.app.controllers;

import java.util.List;

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

import site.danielcirilo.springboot.app.models.entity.Abogado;
import site.danielcirilo.springboot.app.models.entity.Caso;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.entity.Servicio;
import site.danielcirilo.springboot.app.models.services.IAbogadoService;
import site.danielcirilo.springboot.app.models.services.ICasoService;
import site.danielcirilo.springboot.app.models.services.IClienteService;
import site.danielcirilo.springboot.app.models.services.IServicioService;
import site.danielcirilo.springboot.app.utils.PageRender;

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
	public String listarCasos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 1);

		Page<Caso> casos = casoService.findAll(pageRequest);
		PageRender<Caso> pageRender = new PageRender<>("/listaCasos",casos);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Listado casos");
		model.addAttribute("casos", casos);
		
		return "/vistas/casos/listar";
	}

	@RequestMapping(value = "/casosCerrados")
	public String casosCerrados(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 1);

		Page<Caso> casos = casoService.casosCerrados(pageRequest);
		PageRender<Caso> pageRender = new PageRender<>("/casosCerrados",casos);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Casos cerrados");
		model.addAttribute("casos", casos);
		return "/vistas/casos/listar";
	}

	@RequestMapping(value = "/registrarCaso")
	public String crear(Model model) {
		Caso caso = new Caso();
		model.addAttribute("titulo", "Registro nuevo caso");
		model.addAttribute("caso", caso);
		return "vistas/casos/form";
	}

	@ModelAttribute("listadoClientes")
	public List<Cliente> listaClientes() {
		return clienteService.findAll();
	}

	@ModelAttribute("listadoAbogados")
	public List<Abogado> listaAbogados() {
		return abogadoService.findAll();
	}

	@ModelAttribute("servicios")
	public List<Servicio> servicios() {
		return servicioService.findAll();
	}

	@RequestMapping(value = "/registrarCaso", method = RequestMethod.POST)
	public String guardar(@Valid Caso caso, BindingResult result, Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Registro nuevo caso");
			return "vistas/casos/form";
		}

		String mensajeFlash = (caso.getId() != null) ? "Caso editado con exito!" : "Caso añadido con exito!";

		casoService.save(caso);
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listaCasos";

	}

	@RequestMapping(value = "/registrarCaso/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Caso caso = null;
		if (id > 0) {
			caso = casoService.findOne(id);
			flash.addFlashAttribute("error", "Lo siento el caso no existe");

		} else {
			flash.addFlashAttribute("error", "Lo siento el caso no existe");
			return "redirect:listaCasos";
		}
		model.addAttribute("caso", caso);
		model.addAttribute("titulo", "Editar caso");
		return "vistas/casos/form";

	}

}
