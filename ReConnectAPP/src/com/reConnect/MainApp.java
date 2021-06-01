package com.reConnect;

import com.reConnect.model.PostDAO;
import com.reConnect.model.PostVO;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {
	private Stage primaryStage;
	
    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<PostVO> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
    	PostDAO daoProva = new PostDAO();
		ArrayList<PostVO> arraylist = daoProva.obtainAllPosts();
		
		for(int i =0 ; i<arraylist.size(); i++) {
		     personData.add(arraylist.get(i));
		}
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<PostVO> getPersonData() {
	     System.out.println(personData.size());
        return personData;
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("reConnect");        
        showAppOverview();
	}
	
	public void showAppOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StartMenuOverview.fxml"));
            AnchorPane appOverview = (AnchorPane) loader.load();
            Scene scene = new Scene(appOverview);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
	        return primaryStage;
	}
}
