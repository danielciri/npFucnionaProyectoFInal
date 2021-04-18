package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Cirilo
 *
 */
@Entity
@Table(name = "agendas")
public class Agenda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String actividad;
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "fecha_finalizacion")
	private Date fechaFinalizacion;

	// Como es una relacion unidireccional es decir ambos se corresponden, se debe
	// colocar el mapped by
	@JoinColumn(name = "licencia_abogado")
	@OneToOne(cascade = CascadeType.ALL)
	private Abogado agenda;

	@PrePersist
	public void prePersiste() {
		fechaCreacion = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Abogado getAgenda() {
		return agenda;
	}

	public void setAgenda(Abogado agenda) {
		this.agenda = agenda;
	}

}
