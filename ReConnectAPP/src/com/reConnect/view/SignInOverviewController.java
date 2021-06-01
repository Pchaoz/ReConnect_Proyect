package com.reConnect.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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

	/** METHODS **/
	
	@FXML
	public void initialize() {
		System.out.println("testtttt");
	}

	@FXML
	public void handleLogin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		
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
			
			Parent root = FXMLLoader.load(getClass().getResource("MainPageOverview.fxml"));
	        Scene newScene = new Scene(root);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(newScene);
	        window.show();
		}else {
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Usuari o contrasenya incorrectes");
		    alert.showAndWait();
		}
	}
	
	@FXML
	public void handleReturn(ActionEvent event) throws IOException  {
		Parent root = FXMLLoader.load(getClass().getResource("StartMenuOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
	}

	
	public static int getUID() {
		return uid;
	}
	
	public static String getUsername() {
		return username2;
	}
}