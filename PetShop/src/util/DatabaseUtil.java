package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.Appointment;
import model.Doctor;


public class DatabaseUtil {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("PetShop");// face conexiunea
		entityManager = entityManagerFactory.createEntityManager();// face operatiile
	}

	public void saveAnimal(Animal animal) {
		entityManager.persist(animal);
	}

	public void saveAppointment(Appointment appointment) {
		entityManager.persist(appointment);
	}
	
	public void saveDoctor(Doctor doctor) {
		entityManager.persist(doctor);
	}
	public void startTransaction() {// este pregatit sa faca operatii in baza de date
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {// salveaza in baza de date
		entityManager.getTransaction().commit();
	}

	public void closeEntityManager() {
		entityManager.close();
	}
	
	public List<Animal> animalList(){
		
		List<Animal> animalList = (List<Animal>) entityManager.createQuery("Select animal FROM Animal animal", Animal.class).getResultList();
		return animalList;
	}

	public List<Animal> getAllAnimals() {
		List<Animal> animalList = (List<Animal>) entityManager.createNativeQuery("SELECT * FROM petshop.animal", Animal.class).getResultList();
		return animalList;
	}
	public void printAllAnimalsFromDB() {
		List<Animal> results = entityManager.createNativeQuery("Select * from petshop.Animal", Animal.class).getResultList();
		for (Animal animal : results) {
			System.out.println("Animal :" + animal.getName() + " has ID: " + animal.getIdAnimal());
		}
	}
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctorList = (List<Doctor>)entityManager.createNativeQuery("Select * from petshop.Doctor", Doctor.class).getResultList();
		return doctorList;
	}
	
	public List<Appointment> getAllAppointment(){
		List<Appointment> Appointment = (List<Appointment>)entityManager.createNativeQuery("Select * from petshop.Appointment", Appointment.class).getResultList();
		return Appointment;
	}
}
