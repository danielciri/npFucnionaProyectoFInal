package site.danielcirilo.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.danielcirilo.springboot.app.models.entity.Cliente;
import site.danielcirilo.springboot.app.models.repository.IClienteRepository;

@Service
public class ClienteImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepo;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteRepo.save(cliente);
		
	}

	@Override
	@Transactional
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepo.deleteById(id);
		
	}



}
