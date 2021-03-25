package site.danielcirilo.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "abogados")
@PrimaryKeyJoinColumn(referencedColumnName = "abogados")
public class Abogado extends Persona{
	@Column
	@OneToOne
	private Agenda agenda;
	
 
}
