package main;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Animal;
import model.Appointment;
import model.Doctor;
import javafx.collections.FXCollections;
import java.lang.String;

import util.DatabaseUtil;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/controllers/MainView.fxml"));
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			
			e.printStackTrace();		}
		
	}


	public static void main(String[] args) throws Exception {
		launch(args);
		/*DatabaseUtil dbUtil = new DatabaseUtil();
		Animal bob = new Animal();
		bob.setIdAnimal(3);
		bob.setName("Bijou");
		Doctor d = new Doctor();
		d.setName("Dr. Doolitle");
		
		List<Appointment> bobsAppointment = new ArrayList();
		Appointment a = new Appointment();	
		a.setType("Consultatie");
		a.setIdappointment(1);
		bobsAppointment.add(a);
		
		d.setAppointments(bobsAppointment);
		dbUtil.setUp();
		dbUtil.startTransaction();
		
		dbUtil.saveAnimal(bob);
		dbUtil.saveDoctor(d);
		dbUtil.saveAppointment(a);
		dbUtil.commitTransaction();
		dbUtil.printAllAnimalsFromDB();
		dbUtil.closeEntityManager(); */
	}


}
