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

import site.danielcirilo.springboot.app.models.entity.Caso;
import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.ICitaService;
import site.danielcirilo.springboot.app.models.services.IClienteService;
import site.danielcirilo.springboot.app.utils.PageRender;
import site.danielcirilo.springboot.app.validation.CitaValidation;

@Controller
public class CitaController {
	@Autowired
	private ICitaService citaService;

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private CitaValidation validadorCita;

	@RequestMapping(value = "/formCitas", method = RequestMethod.POST)
	public String guardar(@Valid Cita cita, BindingResult result, Model model, RedirectAttributes flash) {
		validadorCita.validate(cita, result);

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Anadir Nueva Cita");
			return "vistas/citas/formCitas";

		}
		String mensajeFlash = (cita.getIdCita() != null) ? "Cita editada con exito!" : "Cita añadida con exito!";

		System.out.println("Datos cita semana:" + cita.getHora());
		citaService.save(cita);
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listaCitas";

	}

	@RequestMapping(value = "/listaCitas")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cita> citas = citaService.findAll(pageRequest);
		PageRender<Cita> pageRender = new PageRender<>("/listaCitas",citas);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Citas pendientes");

		model.addAttribute("citas", citas);

		return "vistas/citas/listar";
	}

	@RequestMapping(value = "/listaMes")
	public String listaCitasMes(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cita> citas = citaService.citasMes(pageRequest);
		PageRender<Cita> pageRender = new PageRender<>("/listaMes",citas);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Citas del mes");
		model.addAttribute("citas", citas);

		return "vistas/citas/listar";
	}

	@RequestMapping(value = "/listaSemana")
	public String listaCitasSemana(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cita> citas = citaService.citaSemana(pageRequest);
		PageRender<Cita> pageRender = new PageRender<>("/listaSemana",citas);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Citas de la semana");
		model.addAttribute("citas", citas);

		return "vistas/citas/listar";
	}

	@RequestMapping(value = "/listaDias")
	public String listaCitasDia(@RequestParam(name = "page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cita> citas = citaService.citasDia(pageRequest);
		PageRender<Cita> pageRender = new PageRender<>("/listaDias",citas);
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Citas del dia");
		model.addAttribute("citas", citas);
		return "vistas/citas/listar";
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

		return clienteService.findAll();
	}

	@RequestMapping(value = "/formCitas/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Cita cita = null;
		if (id > 0) {
			flash.addFlashAttribute("error", "No se han encontrado coincidencias");
			cita = citaService.findOne(id);
		} else {
			flash.addFlashAttribute("error", "No se han encontrado coincidencias");
			return "redirect:menu";
		}
		model.addAttribute("cita", cita);
		model.addAttribute("titulo", "Editar cita");

		return "vistas/citas/formCitas";

	}

}