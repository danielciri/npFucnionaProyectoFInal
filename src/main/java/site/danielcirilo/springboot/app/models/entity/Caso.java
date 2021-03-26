package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name ="nombre_servicio" )
	@OneToOne (cascade = CascadeType.ALL)
	private Servicio nombreServicio;
	
	@Column(name ="fecha_inicio"  )
	private Date fechaInicio;
	
	@Column(name ="fecha_finalizacion" )
	private Date fechaFinalizacion;
	
	@JoinColumn(name ="nombre_cliente" )
	@OneToOne (cascade = CascadeType.ALL)
	private Cliente nombreCliente;
	
	@JoinColumn(name ="licencia" )
	@OneToOne(cascade = CascadeType.ALL)
	private Abogado licencia;
	
	@Column(name ="titulo_caso" )
	private String titulo;
	

	

}
