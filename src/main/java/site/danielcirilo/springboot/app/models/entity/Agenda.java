package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
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
@Table (name="agendas")
public class Agenda implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String actividad;
	@Column (name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "fecha_finalizacion")
	private Date fechaFinalizacion;
	
	@JoinColumn(name = "licencia_abogado")
	@OneToOne(cascade = CascadeType.ALL)
	private Abogado agenda;
	
	@PrePersist
	public void prePersiste() {
		fechaCreacion = new Date();
	}

}
