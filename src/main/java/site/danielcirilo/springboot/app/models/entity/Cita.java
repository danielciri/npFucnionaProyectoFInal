package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name = "citas")
public class Cita implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	
	@OneToOne (fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_cita", unique = true)
	private Date hora;
	
	@Column
	private String asunto;
	

	@OneToOne (fetch = FetchType.LAZY)
	private Abogado abogado;
	
	@Column(name = "estado_cita")
	private boolean estadoCita;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_programada")
	private Date fechaProgramada;
	
	
	
	

}
