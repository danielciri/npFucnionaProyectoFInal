package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.danielcirilo.springboot.app.models.entity.Abogado;
import site.danielcirilo.springboot.app.models.repository.IAbogadoRepository;

@Service
public class AbogadoImpl implements IAbogadoService{
	
	@Autowired
	private IAbogadoRepository abogadoRepo;

	@Override
	@Transactional
	public List<Abogado> findAll() {
		// TODO Auto-generated method stub
		return (List<Abogado>) abogadoRepo.findAll() ;
	}

	@Override
	@Transactional
	public void save(Abogado abogado) {
		abogadoRepo.save(abogado);
		
	}

	@Override
	@Transactional
	public Abogado findOne(Long id) {
		// TODO Auto-generated method stub
		return abogadoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		abogadoRepo.deleteById(id);
		
	}



	
}
