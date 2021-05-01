package site.danielcirilo.springboot.app.models.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import site.danielcirilo.springboot.app.models.entity.Caso;

public interface ICasoService {
	public Page<Caso> casosEnProcesos(Pageable pageable);
	public void save(Caso caso);
	public Caso findOne(Long id);
	public void delete (Long id);
	public Page<Caso> casosCerrados(Pageable pageable);
	public Page<Caso> findAll(Pageable pageable);
		
}
