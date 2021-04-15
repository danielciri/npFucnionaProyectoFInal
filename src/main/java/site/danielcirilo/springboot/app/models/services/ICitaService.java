package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import site.danielcirilo.springboot.app.models.entity.Cita;


public interface ICitaService {
	public List<Cita> findAll();
	public void save(Cita cita);
	public Cita findOne(Long id);
	public void delete (Long id);
	
		
}