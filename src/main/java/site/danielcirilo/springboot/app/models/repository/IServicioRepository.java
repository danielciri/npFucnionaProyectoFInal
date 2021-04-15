package site.danielcirilo.springboot.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import site.danielcirilo.springboot.app.models.entity.Servicio;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {

}
