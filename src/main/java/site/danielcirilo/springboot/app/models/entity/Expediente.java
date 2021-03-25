package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Date fecha_apertura;
	
	@Column (name = "fecha_cerrado")
	private Date fecha_cerrado;
	
	@Column 
	private String observacion;
	
	@Column
	private Caso caso;
	
	
	private boolean estado;

}
