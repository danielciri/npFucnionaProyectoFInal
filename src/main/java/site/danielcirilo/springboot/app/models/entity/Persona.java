package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
public abstract class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column
	protected String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Column
	protected char sexo;

	@Column
	protected String nombre;
	@Column
	protected String apellido;
	@Column
	protected String email;
	@Column
	protected long telefono;

	public Persona(String direccion, Date fecha_nacimiento, char sexo, String nombre, String apellido, String email,
			long telefono) {
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Persona() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

}
