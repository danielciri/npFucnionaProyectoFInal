package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import site.danielcirilo.springboot.app.models.entity.Abogado;

public interface IAbogadoService {
	public List<Abogado> findAll();
	public void save(Abogado abogado);
	public Abogado findOne(Long id);
	public void delete (Long id);
	
		
}
