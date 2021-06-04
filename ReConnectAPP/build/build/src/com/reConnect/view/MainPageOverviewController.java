package com.reConnect.view;

import java.io.IOException;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.reConnect.MainApp;
import com.reConnect.model.PostDAO;
import com.reConnect.model.PostVO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainPageOverviewController {
	@FXML
	TextField titleTextField;
	@FXML
	TextField bodyTextField;
	@FXML
	Label usernameLabel;
	@FXML
	Label surnameLabel;
	@FXML
	ImageView profileImageView;
	@FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    private MainApp mainApp;
    private Stage window; 
	SignInOverviewController userController;
	
	@FXML
	public void initialize() throws IOException {
		try {
			/* LOADS THE SCROLL MENU */
		   	HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(hamburger);
		   	burger.setRate(-1);
		   	hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
		   		burger.setRate(burger.getRate() * -1);
		   		burger.play();
		   		if (drawer.isOpened()) {
		   	        drawer.close();
		   	    } else {
		   	        drawer.open();
		   	    }
		   	});
			
		   	
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}

    @FXML
    public void handlePosts() throws IOException{
    	window = mainApp.getStage();
    	mainApp.showPostOverview(window);
    }
    
    public void setMainApp(MainApp mainApp) throws IOException {
        this.mainApp = mainApp;
		mainApp.showLateralMenu(drawer);
		Image image = new Image(mainApp.getURL());
	    usernameLabel.setText(mainApp.getName());
	    surnameLabel.setText(mainApp.getSurname());
		profileImageView.setImage(image);
    }
    
    @FXML
    public void handleSubmitPost() {
    	if(titleTextField.getText().isEmpty() || bodyTextField.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Ni el titol ni el cos del missatge pot estar buit!");
		    alert.showAndWait();
    	} else {
    		PostVO newPost = new PostVO(SignInOverviewController.getUID(), titleTextField.getText(), bodyTextField.getText());
    		PostDAO createPost = new PostDAO();
    		createPost.createPost(newPost);
    	}
    }
}