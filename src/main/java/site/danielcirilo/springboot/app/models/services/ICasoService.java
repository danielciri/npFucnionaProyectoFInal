package site.danielcirilo.springboot.app.models.services;

import java.util.List;


import site.danielcirilo.springboot.app.models.entity.Caso;

public interface ICasoService {
	public List<Caso> findAll();
	public void save(Caso caso);
	public Caso findOne(Long id);
	public void delete (Long id);
	
		
}
