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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartMenuOverviewController {

	@FXML
	private Label welcomeText;
	
	@FXML
	private Button signInButton;
	
	@FXML
	private Button signUpButton;
	
	private MainApp mainApp;
	private Stage window;
	
	@FXML
	private void initialize() {		
	}
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	/*
	 * Botó per a iniciar sessió
	 */
	@FXML
    private void handleChangeLogin(ActionEvent event) throws IOException{
		window = mainApp.getStage();
        mainApp.showSignUpOverview(event, window);
         // Give the controller access to the main app.
    }
	
	@FXML
    private void handleChangeSignUp(ActionEvent event) throws IOException{
		window = mainApp.getStage();
        mainApp.showSignInOverview(event, window);
    }
}

