package site.danielcirilo.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Cirilo
 *
 */

@Entity
@Table (name = "linea_factura")
public class lineaFactura {
	
	@Column
	private float iva;
	
	@Column (name = "sub_total")
	private float subTotal;
	
	@Column
	private float total;

}
