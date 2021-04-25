package site.danielcirilo.springboot.app.validation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.services.ICitaService;

@Component
public class CitaValidation implements Validator {

	@Autowired
	private ICitaService citaService;

	@Override
	public boolean supports(Class<?> clazz) {

		return Cita.class.isAssignableFrom(clazz);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object target, Errors errors) {
		Cita cita = (Cita) target;

		if(cita.getFechaProgramada().getTime() < System.currentTimeMillis()) {
			errors.rejectValue( "fechaProgramada", "fechaMenor.cita.fechaProgramada");
		}
		
		if(cita.getFechaProgramada() == null) {
			ValidationUtils.rejectIfEmpty(errors, "fechaProgramada", "typeMismatch.cita.fechaProgramada");
		}else {
			for (int i = 0; i < citaService.findAll().size(); i++) {
				if (cita.getFechaProgramada().getTime()== citaService.findAll().get(i).getFechaProgramada().getTime()) {
					if(cita.getHora().getHours() == citaService.findAll().get(i).getHora().getHours()) {
						errors.rejectValue( "hora", "coincidencia.cita.hora");
						
					}
					
				
				}
			
			}
			
		}
	

		

	}
}
