package site.danielcirilo.springboot.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.services.ICitaService;
import site.danielcirilo.springboot.app.models.services.IClienteService;
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
	public String guardar(@Valid Cita cita, BindingResult result, Model model) {
		validadorCita.validate(cita, result);
			
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Anadir Nueva Cita");
			return "vistas/citas/formCitas";

		} else {
			System.out.println("Datos cita semana:" + cita.getHora());
			citaService.save(cita);
			return "redirect:listaCitas";
		}

	}

	@RequestMapping(value = "listaCitas")
	public String listar(Model model) {
		model.addAttribute("titulo", "Citas pendientes");

		
		model.addAttribute("citas", citaService.findAll());


		return "vistas/citas/listar";
	}
	@RequestMapping(value = "listaMes")
	public String listaCitasMes(Model model) {
		model.addAttribute("titulo", "Citas del mes");
		model.addAttribute("citas", citaService.findAll());



		return "vistas/citas/listar";
	}
	@RequestMapping(value = "listaSemana")
	public String listaCitasSemana(Model model) {
		model.addAttribute("titulo", "Citas de la semana");
		model.addAttribute("citas", citaService.citaSemana());


		return "vistas/citas/listar";
	}
	@RequestMapping(value = "listaDias")
	public String listaCitasDia(Model model) {
		model.addAttribute("titulo", "Citas del dia");
		model.addAttribute("citas", citaService.citasDia());
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
			cita = citaService.findOne(id);
		} else {
			return "redirect:menu";
		}
		model.addAttribute("cita", cita);
		model.addAttribute("titulo", "Editar cita");

		return "vistas/citas/formCitas";

	}

}