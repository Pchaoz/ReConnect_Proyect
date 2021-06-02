package com.reConnect.view;

import java.io.IOException;

import com.reConnect.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartMenuOverviewController {

	@FXML
	private Label welcomeText;
	
	@FXML
	private Button signInButton;
	
	@FXML
	private Button signUpButton;
	
	@FXML
	private void initialize() {		
		
	}
	
	
	@FXML
	/*
	 * Method that redirects the user to the login page
	 */
    private void handleChangeLogin(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("SignInOverview.fxml"));
            Scene newScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
    }
	
	@FXML
	/*
	 * Method that redirects the user to the register page
	 */
    private void handleChangeSignUp(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("SignUpOverview.fxml"));
            Scene newScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
    }


}

