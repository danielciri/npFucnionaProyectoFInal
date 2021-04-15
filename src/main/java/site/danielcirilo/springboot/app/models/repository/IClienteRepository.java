package site.danielcirilo.springboot.app.models.repository;

import org.springframework.stereotype.Repository;

import site.danielcirilo.springboot.app.models.entity.Cliente;

@Repository
public interface IClienteRepository extends IPersonaRepository<Cliente> {

}
