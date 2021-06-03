package com.reConnect;

import com.jfoenix.controls.JFXDrawer;
import com.reConnect.model.PostDAO;
import com.reConnect.model.PostVO;
import com.reConnect.view.DrawerContentController;
import com.reConnect.view.MainPageOverviewController;
import com.reConnect.view.PostOverviewController;
import com.reConnect.view.ProfileEditOverviewController;
import com.reConnect.view.SignInOverviewController;
import com.reConnect.view.SignUpOverviewController;
import com.reConnect.view.StartMenuOverviewController;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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

		for(int i=0; i< arraylist.size();i++) {
			personData.add(arraylist.get(i));
		}
	}

	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<PostVO> getPersonData() {
		return personData;
	}

	/**
	 * Returns the stage
	 */
	public Stage getStage() {
		return primaryStage;
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


			// Give the controller access to the main app.
			StartMenuOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void showStartPageOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/StartMenuOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		StartMenuOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}


	public void showSignUpOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/SignInOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		SignInOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}


	public void showSignInOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/SignUpOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		SignUpOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	public void showMainPageOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/MainPageOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		MainPageOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	public void showLateralMenu(JFXDrawer drawer) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/DrawerContent.fxml"));
		VBox box = (VBox) loader.load();

		drawer.setSidePane(box);

		DrawerContentController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	public void showPostOverview(Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/PostOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		PostOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	public void showProfileEditOverview(Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/ProfileEditOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		ProfileEditOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}
}
