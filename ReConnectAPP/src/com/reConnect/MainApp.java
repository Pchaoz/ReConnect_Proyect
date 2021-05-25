package com.reConnect;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	
	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("reConnect");        
        showAppOverview();
	}
	
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
	        return primaryStage;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
