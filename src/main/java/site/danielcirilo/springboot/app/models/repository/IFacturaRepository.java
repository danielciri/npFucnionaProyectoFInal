package site.danielcirilo.springboot.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import site.danielcirilo.springboot.app.models.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {

}
