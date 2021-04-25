package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.danielcirilo.springboot.app.models.entity.Servicio;
import site.danielcirilo.springboot.app.models.repository.IServicioRepository;

@Service
public class ServicioImpl implements IServicioService{
	@Autowired
	private IServicioRepository repoServicio;
	@Override
	@Transactional
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return repoServicio.findAll() ;
	}

	@Override
	public void save(Servicio servicio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servicio findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
