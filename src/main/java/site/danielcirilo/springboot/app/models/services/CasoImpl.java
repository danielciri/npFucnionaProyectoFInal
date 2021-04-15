package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Caso> findAll() {
		// TODO Auto-generated method stub
		return (List<Caso>) casosRepo.findAll() ;
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
	
}
