package com.reConnect.view;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

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

    @FXML
    void handleLogOut(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("StartMenuOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void handleMainPage(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("MainPageOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void handleMessages(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("UserListOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void handleProfile(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("ProfileEditOverview.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}
