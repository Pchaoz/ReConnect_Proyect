package com.reConnect.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import com.reConnect.MainApp;
import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;
import javafx.fxml.FXML;
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
	private Stage window;

	MainApp mainApp;

	public static int uid;

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
		//window = mainApp.getStage();
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

			createUser.loadUser(newUser);

			mainApp.reloadUser(newUser);

			//Controller used to change screen
			mainApp.showMainPageOverview(event, window);
		}
	}


	/**
	 * Metode encarregat de comprovar que les contrasenyes coincideixin
	 * @param password
	 * @param confirmP
	 * @return
	 */
	private boolean isInputCorrect(String password, String confirmP) {
		boolean isCorrect;
		if(password.equals(confirmP)) {
			isCorrect = true;
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

	/**
	 * Metode encarregat de enviar lusuari a la pantalla anterior
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
		window = mainApp.getStage();
	}
}