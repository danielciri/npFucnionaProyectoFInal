package site.danielcirilo.springboot.app.models.services;


import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import site.danielcirilo.springboot.app.models.entity.Cita;
import site.danielcirilo.springboot.app.models.repository.ICitaRepository;

@Service
public class CitaImpl implements ICitaService{
	
	@Autowired
	private ICitaRepository citaRepo;

	@Override
	public List<Cita> findAll() {
		// TODO Auto-generated method stub

		return (List<Cita>) citaRepo.findAll() ;
	}

	@Override
	public void save(Cita cita) {
		citaRepo.save(cita);
		
	}

	@Override
	public Cita findOne(Long id) {
		// TODO Auto-generated method stub
		return citaRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {

		citaRepo.deleteById(id);
		
	}

	@Override
	public Page<Cita> citasDia(Pageable pageable) {
	
		return citaRepo.citasDia(pageable,new Date(System.currentTimeMillis()));
	}

	@Override
	public Page<Cita> citasMes(Pageable pageable) {
	
		return citaRepo.citasMes(pageable);
	}

	@Override
	public Page<Cita> citaSemana(Pageable pageable) {
		// TODO Auto-generated method stub
		return citaRepo.citasMes(pageable);
	}

	@Override
	public Page<Cita> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return citaRepo.findAll(pageable);
	}




	


}
