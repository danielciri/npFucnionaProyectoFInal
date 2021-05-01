package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "abogados")
@DiscriminatorValue("abogado")
public class Abogado extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	
	@Column(name = "num_licencia", unique = true)
	@NotEmpty
	private String num_licencia;

	// Como es una relacion bireccional es decir ambos se corresponden, se debe
	// colocar el mapped by
	//@OneToMany(mappedBy = "abogado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Cita> citas;

	// Como es una relacion bireccional es decir ambos se corresponden, se debe
	// colocar el mapped by
	@OneToMany(mappedBy = "abogado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Caso> casos;

	public Abogado() {

	}

	public Abogado(Long id,String direccion, Date fecha_nacimiento, String nombre, String apellido, String email,
			long telefono, String num_licencia) {
		super(id,direccion, fecha_nacimiento,  nombre, apellido, email, telefono);
		this.num_licencia = num_licencia;

	}


	public List<Caso> getCasos() {
		return casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

}
