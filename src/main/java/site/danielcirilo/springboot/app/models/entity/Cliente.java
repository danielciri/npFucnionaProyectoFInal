package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "documento_persona")
public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column
	private String direccion;
	
	@Column
	private char sexo;
	
	@Column (name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column (name = "facturas")
	@OneToMany
	private ArrayList<Factura> facturas;
	
	

}
