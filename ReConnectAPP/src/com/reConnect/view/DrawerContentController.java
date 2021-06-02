package com.reConnect.view;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.reConnect.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DrawerContentController {
	
	@FXML
    private JFXButton mainPageButton;

    @FXML
    private JFXButton profileButton;

    @FXML
    private JFXButton messagesButton;

    @FXML
    private JFXButton logOutButton;
    
	private MainApp mainApp;
	Stage window;
	
    @FXML
    /*
     * Redirects the user into the login/register page
     */
    void handleLogOut(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showStartPageOverview(event, window);
    }

    @FXML
    /*
     * Redirects the user to the main page
     */
    void handleMainPage(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showMainPageOverview(event, window);
    }

    @FXML
    /*
     * Redirects the user to the message page
     */
    void handleMessages(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("UserListOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    /*
     * Redirects the user into the profile edit page
     */
    void handleProfile(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showProfileEditOverview(window);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
