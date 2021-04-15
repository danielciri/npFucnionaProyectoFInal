package site.danielcirilo.springboot.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import site.danielcirilo.springboot.app.models.entity.Caso;

public interface ICasoRepository extends JpaRepository<Caso, Long>{
	

}
