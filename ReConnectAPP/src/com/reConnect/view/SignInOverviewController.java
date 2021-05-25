package com.reConnect.view;

import java.security.NoSuchAlgorithmException;

import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
	private void handleLogin() throws NoSuchAlgorithmException {
		
		/* VARIABLES */
		
		HashPassword hash = new HashPassword();
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		String hashedPassword = hash.hashPassword(password);
		
		UserVO loginUser = new UserVO(username, hashedPassword);
		UserDAO validateUser = new UserDAO();
		
		/* VALIDATES THE USER */
		
		validateUser.validateUser(loginUser);
		
		
		
	}
	
	
	
}



