package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

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
@Table (name = "facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column
	private String descripcion;
	
	@Column
	private Date fecha;
	
	@Column
	private String observacion;
	

}
