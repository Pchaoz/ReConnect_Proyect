package com.reConnect.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.util.HashPassword;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
	
	@FXML
    private JFXDrawer drawer;
	
	@FXML
	private JFXHamburger hamburger;

	
	SignInOverviewController dataL; 
	
	SignUpOverviewController dataR; 
	
	@FXML
    public void initialize() throws IOException {
		 
		 /* LOADS THE SCROLL MENU */
    	
    	VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
    	drawer.setSidePane(box);
    	
    	HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(hamburger);
    	burger.setRate(-1);
    	hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
    		burger.setRate(burger.getRate() * -1);
    		burger.play();
    		
    		if (drawer.isOpened()) {
    			/* CLOSE THE SCROLL MENU */
    			
    	        drawer.close();
    	    } else {
    	    	/* OPENS THE SCROLL MENU */
    	    	
    	        drawer.open();
    	    }
    	});
    	
	 }
	/*
	 * Method that updates the user
	 */
	public void handleUpdate(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		
		/* VARIABLES THAT GET THE DATA */
		HashPassword hash = new HashPassword();
		
		boolean logIn = false;
		boolean SignUp = false;
		
		String username = usernameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();
		String name = nameField.getText();
		String surname = surrnameField.getText();
		String imgurl = imgurlField.getText();
		String hashedPassword = hash.hashPassword(password);
		
		UserDAO updater = new UserDAO();
		UserVO updateUser = new UserVO(username, email, hashedPassword, name, surname, imgurl);

		/* TAKE THE DATA FROM LOG IN OR REGISTER (uid) */
		
			if (logIn = true) {
				
				updateUser.setUid(SignInOverviewController.getUID());
				
			}else if (SignUp = true){
				
				
				updateUser.setUid(SignUpOverviewController.getUID());
			}
			
			/* DON'T UPDATE THE USER IF THERE'S ANY EMPTY FIELD */
			
			if ( usernameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() || surrnameField.getText().trim().isEmpty() || imgurlField.getText().trim().isEmpty()) {
				
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setHeaderText(null);
			    alert.setTitle("Error");
			    alert.setContentText("Omple tots els camps abans d'actualitzar el teu perfil.");
			    alert.showAndWait();
				
			}else {
				
				/* UPDATES THE USER  */
				
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
	
}
