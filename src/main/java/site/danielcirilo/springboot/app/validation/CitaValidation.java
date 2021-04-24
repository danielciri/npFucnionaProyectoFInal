package site.danielcirilo.springboot.app.validation;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import site.danielcirilo.springboot.app.models.entity.Cita;

@Component
public class CitaValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {

		return Cita.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Cita cita = (Cita) target;
		Date date = new Date();

		ValidationUtils.rejectIfEmpty(errors, "hora", "incorrecta.cita.hora");

	}
}
