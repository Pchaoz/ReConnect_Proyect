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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInOverviewController {

	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Button signInButton;

	/** METHODS **/
	
	@FXML
	public void initialize() {

	}

	@FXML
	public void handleLogin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		
	/* VARIABLES */

		HashPassword hash = new HashPassword();
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		String hashedPassword = hash.hashPassword(password);
		
		UserVO loginUser = new UserVO(username, hashedPassword);
		UserDAO validateUser = new UserDAO();
		
		
		/* VALIDATES THE USER  */
		
		
		if (validateUser.validateUser(loginUser)) {
		
			Parent root = FXMLLoader.load(getClass().getResource("StartMenuOverview.fxml"));
	        Scene newScene = new Scene(root);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(newScene);
	        window.show();
		}
		
	}
}



