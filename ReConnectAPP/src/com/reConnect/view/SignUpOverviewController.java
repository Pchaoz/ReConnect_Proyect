package com.reConnect.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import com.reConnect.MainApp;
import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
public class SignUpOverviewController {

	@FXML
	private TextField usernameField;
	@FXML
	private TextField emailField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField surnameField;
	MainApp main;

	@FXML
	public void initialize() {

	}

	/**
	 * Check if username exists or not
	 * Hash password
	 * Check if email is valid
	 * Check if passwords are the same
	 * @throws NoSuchAlgorithmException 
	 */
	@FXML
	private void handleNewUser(ActionEvent event) throws NoSuchAlgorithmException, IOException {
		String username = usernameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();
		String confirmP = confirmPasswordField.getText();
		String name = nameField.getText();
		String surname = surnameField.getText();
		UserDAO createUser = new UserDAO();
		HashPassword hashPassword = new HashPassword();
		String hashedPassword = hashPassword.hashPassword(password);
		if(isInputCorrect(password, confirmP)) {
			UserVO newUser = new UserVO(username, email, hashedPassword, name, surname);
			createUser.createUser(newUser);
			//Controller used to change screen
			Parent root = FXMLLoader.load(getClass().getResource("MainPageOverview.fxml"));
			Scene newScene = new Scene(root);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(newScene);
	        window.show();
		}
	}

	

	private boolean isInputCorrect(String password, String confirmP) {
		boolean isCorrect;
		if(password.equals(confirmP)) {
			isCorrect = true;
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}
}