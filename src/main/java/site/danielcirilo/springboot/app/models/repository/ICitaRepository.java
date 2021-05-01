package site.danielcirilo.springboot.app.models.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import site.danielcirilo.springboot.app.models.entity.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Long>{

	 @Query(value = "select * from citas where citas.fecha_programada=?1", nativeQuery = true)
	 Page<Cita> citasDia(Pageable pageable,Date fecha);
	 
	 @Query(value = "select * from citas where Month(citas.fecha_programada)= MONTH(CURRENT_DATE()) AND YEAR(citas.fecha_programada) = YEAR(CURRENT_DATE()) ", nativeQuery = true)
	 Page<Cita> citasMes(Pageable pageable);
	 
	 @Query(value = "SELECT * FROM citas WHERE YEARWEEK(citas.fecha_programada) = YEARWEEK(CURDATE())", nativeQuery = true)
	 Page<Cita> citaSemana(Pageable pageable);
	 
	 

}
