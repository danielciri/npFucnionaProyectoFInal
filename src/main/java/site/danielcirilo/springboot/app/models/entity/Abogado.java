package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "abogados")
@PrimaryKeyJoinColumn(referencedColumnName = "documento_persona")
public class Abogado extends Persona implements Serializable{


	
 
}
