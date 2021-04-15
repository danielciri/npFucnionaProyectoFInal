package site.danielcirilo.springboot.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.danielcirilo.springboot.app.models.entity.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Long>{
	

}
