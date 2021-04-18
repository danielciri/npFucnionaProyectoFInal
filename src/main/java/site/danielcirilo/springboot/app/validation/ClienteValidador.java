package site.danielcirilo.springboot.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.utils.Lib;

@Component
public class ClienteValidador implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {

		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Cliente cliente = (Cliente) target;
		if (cliente.getDocumentoCliente().isEmpty()) {
			ValidationUtils.rejectIfEmpty(errors, "documentoCliente", "NotEmpty.cliente.documentoCliente");

		}

		else {
			switch (cliente.getTipoDocumento()) {
			case DNI:
				if (cliente.getDocumentoCliente().length() < 9) {
					ValidationUtils.rejectIfEmpty(errors, "documentoCliente", "NotEmpty.cliente.documentoCliente");
				} else {
					String dni = Lib.calcularletraDni(cliente.getDocumentoCliente());
					if (!cliente.getDocumentoCliente().matches(dni)) {
						errors.rejectValue("documentoCliente", "daniel.usuario.identificador");

					}

				}

				break;

			case NIE:
				String nie = cliente.getDocumentoCliente();
				if (Character.isLetter(nie.charAt(0)) == false || nie.length() < 9) {
					errors.rejectValue("documentoCliente", "nie.usuario.identificador");
				} else {
					Lib.calculaNie(nie);
					if (!cliente.getDocumentoCliente().matches(nie)) {
						errors.rejectValue("documentoCliente", "nie.usuario.identificador");
					}
				}

				break;

			default:
				break;
			}
		}
	}
}
