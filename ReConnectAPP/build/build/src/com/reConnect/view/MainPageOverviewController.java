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
	
	/**
	 * Aquest metode serveix per definir els camps i objectes abans de que carregui el fxml
	 * @throws IOException
	 */
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

	/**
	 * Aquest metode es lencarregat denviar lusuari a la pantalla de les publicacions
	 * @throws IOException
	 */
    @FXML
    public void handlePosts() throws IOException{
    	window = mainApp.getStage();
    	mainApp.showPostOverview(window);
    }
    
    /**
     * Aquest metode sencarrega de obtenir acces a la MainApp.java aixi com carregar les dades de lusuari una 
     * vegada ha carregat la base de dades
     * @param mainApp
     * @throws IOException
     */
    public void setMainApp(MainApp mainApp) throws IOException {
    		this.mainApp = mainApp;
    		mainApp.showLateralMenu(drawer);
    		Image image = new Image(mainApp.getURL());
    	    usernameLabel.setText(mainApp.getName());
    	    surnameLabel.setText(mainApp.getSurname());
    		profileImageView.setImage(image);
    }
    
    /**
     * Aquest metode sencarrega devitar que es publiquin articles sense cos o titol
     */
    @FXML
    public void handleSubmitPost() {
    	if(titleTextField.getText().isEmpty() || bodyTextField.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Ni el titol ni el cos del missatge pot estar buit!");
		    alert.showAndWait();
    	} else {
    		PostVO newPost = new PostVO(mainApp.getCurrUser().getUid(), titleTextField.getText(), bodyTextField.getText());
    		PostDAO createPost = new PostDAO();
    		createPost.createPost(newPost);
		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Creacio correcte");
		    alert.setContentText("La noticia s'ha pujat correctament");
		    alert.showAndWait();
	
    		
    	}
    }
}