package site.danielcirilo.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Daniel Cirilo
 *
 */

@Entity
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private float costo;
	
	@Column
	private String descripcion;
	
	

}
