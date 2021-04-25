package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.entity.Servicio;

public interface IServicioService {
	public List<Servicio> findAll();
	public void save(Servicio servicio);
	public Servicio findOne(Long id);
	public void delete (Long id);
}
