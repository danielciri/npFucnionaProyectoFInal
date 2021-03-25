package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Cirilo
 *
 */
@Entity
@Table (name = "casos")
public class Caso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCaso;
	@Column(name ="nombre_servicio" )
	private Servicio nombreServicio;
	
	@Column(name ="fecha_inicio" )
	private Date fechaInicio;
	
	@Column(name ="fecha_inicio" )
	private Date fechaFinalizacion;
	
	@Column(name ="nombre_cliente" )
	private Cliente nombreCliente;
	
	@Column(name ="licencia" )
	@OneToOne
	private Abogado licencia;
	
	@Column(name ="titulo_caso" )
	private String titulo;
	

	

}
