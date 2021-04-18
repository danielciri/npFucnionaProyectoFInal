package site.danielcirilo.springboot.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import site.danielcirilo.springboot.app.models.entity.Abogado;
import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.entity.Persona;
import site.danielcirilo.springboot.app.models.repository.IAbogadoRepository;
import site.danielcirilo.springboot.app.models.repository.IClienteRepository;
import site.danielcirilo.springboot.app.models.repository.IPersonaRepository;
import site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento;
import site.danielcirilo.springboot.app.utils.Lib;

@SpringBootApplication
public class AgilizadoLegalSpringBootJpaApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(AgilizadoLegalSpringBootJpaApplication.class, args);
		
		
		
	}

}
