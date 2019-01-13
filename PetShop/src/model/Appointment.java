package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idappointment;

	private Animal idAnimal;

	private String type;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="idDoctor")
	private Doctor doctor;

	public Appointment() {
	}

	public int getIdappointment() {
		return this.idappointment;
	}

	public void setIdappointment(int idappointment) {
		this.idappointment = idappointment;
	}

	public Animal getIdAnimal() {
		return this.idAnimal;
	}
	
	public void setIdAnimal(Animal animal) {
		this.idAnimal = animal;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}