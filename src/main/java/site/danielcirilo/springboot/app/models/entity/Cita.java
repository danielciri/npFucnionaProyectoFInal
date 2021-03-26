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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name = "citas")
public class Cita implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	
	@JoinColumn(name = "licencia_abogado")
	@OneToOne (cascade = CascadeType.ALL)
	private Cliente nomCliente;
	
	@Column(name = "hora_cita")
	private Date hora;
	
	@Column
	private String asunto;
	

	@JoinColumn(name = "nombre_abogado")
	@OneToOne (cascade = CascadeType.ALL)
	private Abogado nomAbogado;
	
	@Column(name = "estado_cita")
	private boolean estadoCita;
	
	@Column(name = "fecha_programada")
	private Date fechaProgramada;
	
	

}
