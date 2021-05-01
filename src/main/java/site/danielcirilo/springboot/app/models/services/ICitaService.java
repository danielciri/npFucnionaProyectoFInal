package site.danielcirilo.springboot.app.models.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import site.danielcirilo.springboot.app.models.entity.Cita;



public interface ICitaService {
	public Page<Cita> findAll(Pageable pageable);
	public List<Cita> findAll();
	public void save(Cita cita);
	public Cita findOne(Long id);
	public void delete (Long id);
	public Page<Cita>citasDia(Pageable pageable);
	public Page<Cita>citasMes(Pageable pageable);
	public Page<Cita>citaSemana(Pageable pageable);
	
		
}
