package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name="personas")
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Persona {
	
	

	@Id
	@Column(name = "documento_persona")
	protected String numeroDocumento;
	
	@Column
	protected String nombre;
	@Column
	protected String apellido;
	@Column
	protected String email;
	@Column
	protected long numeroTelefono;


}
