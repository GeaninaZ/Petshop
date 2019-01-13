package controllers

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Animal;
import util.DatabaseUtil;

public class MainController implements Initializable {

	@FXML
	private ListView<String> mainListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			populateListView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void populateListView() throws Exception {
		DatabaseUtil dbUtil = new DatabaseUtil();
		dbUtil.setUp();
		dbUtil.startTransaction();
		ObservableList<String> names = FXCollections.observableArrayList();

		for (Animal animal : dbUtil.getAllAnimals()) {
			String appName = animal.getAppointments().get(0).getType();
			names.add("Animal name: " + animal.getName() + " has appointment: " + appName);
		}
		mainListView.setItems(names);
		mainListView.refresh();
		dbUtil.closeEntityManager();
	}

}


/*




package controllers;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import util.DatabaseUtil;
import model.Animal;

public class MainController implements Initializable{

	
	@FXML
	private ListView<String> listView; 
	
		
	public void populateMainListView() throws Exception {
		DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
		List<Animal> animalDBList =(List<Animal>) db.animalList();
		ObservableList<String> animalNamesList = getAnimalName(animalDBList);
		listView.setItems(animalNamesList);
		listView.refresh();
		db.closeEntityManager();
	}
	
	
	public ObservableList<String> getAnimalName(List<Animal> animals) {
		ObservableList<String> names = FXCollections.observableArrayList();
		for (Animal a : animals) {
			names.add(a.getName());
		}
		return names;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			populateMainListView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	     
	}


}*/
