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

@SpringBootApplication
public class AgilizadoLegalSpringBootJpaApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AgilizadoLegalSpringBootJpaApplication.class, args);
		
		IPersonaRepository clienteRepository = configurableApplicationContext.getBean(IClienteRepository.class);
		IPersonaRepository abogadoRepository = configurableApplicationContext.getBean(IAbogadoRepository.class);
		
		String currentDateString = "02/27/2012 17:00:00";
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date currentDate = sd.parse(currentDateString);

		String yourDateString = "02/28/2012 15:00:00";
		SimpleDateFormat yourDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date yourDate = yourDateFormat.parse(yourDateString);
		
		Persona cliente = new Cliente("sdas", yourDate, 's', "fasdas", "asdasd", "sadasd", 2342343, "asdasd", "asdasd", TipoDocumento.DNI);
		Persona abogado = new Abogado("asdasd", yourDate, 'd', "asdasd", "sadas", "asdsad",32432,  "asdasd");
		
		clienteRepository.save(cliente);
		abogadoRepository.save(abogado);
		
		
	}

}
