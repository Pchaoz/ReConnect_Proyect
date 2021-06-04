package com.reConnect.view;

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
	public static String url;
	private MainApp mainApp;
	
	Stage window;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
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
			mainApp.reloadUser(userLoged);
			
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
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleReturn(ActionEvent event) throws IOException  {
		window = mainApp.getStage();
		mainApp.showStartPageOverview(event, window);
	}
	
	/**
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	/**
	 * 
	 * @return
	 */
	public static int getUID() {
		return uid;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getUsername() {
		return username2;
	}
}