package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.danielcirilo.springboot.app.models.entity.Caso;
import site.danielcirilo.springboot.app.models.repository.ICasoRepository;

@Service
public class CasoImpl implements ICasoService{
	
	@Autowired
	private ICasoRepository casosRepo;
	
	@Override
	@Transactional
	public Page<Caso> casosEnProcesos(Pageable pageable) {
		// TODO Auto-generated method stub
		return casosRepo.casosEnProcesos(pageable) ;
	}

	@Override
	@Transactional
	public void save(Caso caso) {
		casosRepo.save(caso);
		
	}

	@Override
	@Transactional
	public Caso findOne(Long id) {
	
		return casosRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		casosRepo.deleteById(id);
		
	}



	@Override
	@Transactional
	public Page<Caso> findAll(Pageable pageable) {
		return casosRepo.findAll(pageable);
	}

	@Override
	@Transactional
	public Page<Caso> casosCerrados(Pageable pageable) {
		return casosRepo.casosCerrado(pageable);
	}
	
}
