package site.danielcirilo.springboot.app.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import site.danielcirilo.springboot.app.models.entity.Caso;

public interface ICasoRepository extends JpaRepository<Caso, Long>{
	
	@Query(value = "select * from casos where casos.fecha_finalizacion is not null", nativeQuery = true)
	Page<Caso> casosCerrado(Pageable pageable);
	@Query(value = "select * from casos where casos.fecha_finalizacion is null", nativeQuery = true)
	Page<Caso> casosEnProcesos(Pageable pageable);

}
