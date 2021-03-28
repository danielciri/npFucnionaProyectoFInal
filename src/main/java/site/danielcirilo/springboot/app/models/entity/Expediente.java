package site.danielcirilo.springboot.app.models.entity;

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
@Table(name = "expedientes")
public class Expediente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "num_expediente")
	private Long num_expediente;
	
	@Column (name = "fecha_apertura")
	private Date fechaApertura;
	
	@Column (name = "fecha_cerrado")
	private Date fechaCerrado;
	
	@Column 
	private String observacion;
	
	@JoinColumn(name = "codigo_caso")
	@OneToOne (cascade = CascadeType.ALL)
	private Caso caso;
	
	@Column
	private boolean estado;
	
	@PrePersist
	public void prePersiste() {
		fechaApertura = new Date();
	}
	

}
