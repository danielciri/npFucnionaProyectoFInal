package site.danielcirilo.springboot.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import site.danielcirilo.springboot.app.models.entity.Persona;

@NoRepositoryBean
public interface IPersonaRepository  extends JpaRepository<Persona, Long>{

}
