package com.reConnect.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ProfileEditOverviewController {

	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField emailField;
	
	@FXML	
	private PasswordField passwordField;
	
	@FXML
	private TextField nameField;	
	 
	@FXML
	private TextField surrnameField;	
	
	@FXML
	private TextField imgurlField;
	
	@FXML
	private Button updateButton;
	
	public void handleUpdate(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		
		/* VARIABLES THAT GET THE DATA */
		
		HashPassword hash = new HashPassword();
		
		String username = usernameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();
		String name = nameField.getText();
		String surname = surrnameField.getText();
		String imgurl = imgurlField.getText();
		String hashedPassword = hash.hashPassword(password);
		
		UserDAO updater = new UserDAO();
		UserVO updateUser = new UserVO(username, email, hashedPassword, name, surname, imgurl);
		
		/* UPDATES THE USER */
		
		if (updater.userUpdater(updateUser)) {
			
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
			 alert.setHeaderText(null);
			 alert.setTitle("Info");
			 alert.setContentText("Usuari actualitzat amb exit");
			 alert.showAndWait();
		}else {
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Error a la hora d'actualitzar el usuari");
		    alert.showAndWait();
		}
	}
	
}
