package com.reConnect.view;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.reConnect.MainApp;
import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;	

public class SignInOverviewController {

	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button signInButton;
	
	@FXML
	private Button returnButton;
	
	public static int uid;
	public static String username2;
	private MainApp mainApp;
	Stage window;

	/** METHODS **/
	
	@FXML
	public void initialize() {
	}

	/*
	 * Method that validates the user to log in
	 */
	@FXML
	public void handleLogin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		window = mainApp.getStage();
		/* VARIABLES THAT GET THE DATA */
		HashPassword hash = new HashPassword();
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		String hashedPassword = hash.hashPassword(password);
		
		UserVO userLoged = new UserVO(username, hashedPassword);
		UserDAO validateUser = new UserDAO();
		
		
		/* VALIDATES THE USER  */
		if (validateUser.validateUser(userLoged)) {
		
			validateUser.loadUser(userLoged);
			
			uid = userLoged.getUid();
			username2 = userLoged.getUsername();
			 // Give the controller access to the main app.
			mainApp.showMainPageOverview(event, window);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Usuari o contrasenya incorrectes");
		    alert.showAndWait();
		}
	}
	
	@FXML
	/*
	 * Method to returns to the login/register page
	 */
	public void handleReturn(ActionEvent event) throws IOException  {
		window = mainApp.getStage();
		mainApp.showStartPageOverview(event, window);
	}
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

	
	public static int getUID() {
		return uid;
	}
	
	public static String getUsername() {
		return username2;
	}
}