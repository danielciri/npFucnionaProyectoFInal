package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "abogados")
@PrimaryKeyJoinColumn(referencedColumnName = "documento_persona")
public class Abogado extends Persona implements Serializable{

	//Como es una relacion bireccional es decir ambos se corresponden, se debe colocar el mapped by
	@OneToMany(mappedBy = "abogado",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private  List<Cita>   citas;
	
	@OneToMany(mappedBy = "licencia",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Caso> casos;
	
 
}
