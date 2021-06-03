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
    private JFXButton logOutButton;
    
	private MainApp mainApp;
	Stage window;
	
    @FXML
    void handleLogOut(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showStartPageOverview(event, window);
    }

    @FXML
    void handleMainPage(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showMainPageOverview(event, window);
    }

    @FXML
    void handleProfile(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
    	mainApp.showProfileEditOverview(window);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}