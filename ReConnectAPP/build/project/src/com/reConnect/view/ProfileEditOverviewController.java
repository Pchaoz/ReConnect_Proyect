package com.reConnect.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.reConnect.MainApp;
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
import javafx.stage.Stage;

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

	private MainApp mainApp;
	
	private Stage window;
	
	private UserVO currUser;
	
	SignInOverviewController dataL; 
	
	SignUpOverviewController dataR; 
	
	
	/**
	 * Aquest metode serveix per definir els camps i objectes abans de que carregui el fxml 
	 * @throws IOException
	 */
	@FXML
    public void initialize() throws IOException {
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
    	
	 }
	
	/**
	 * Aquest metode sencarrega de actualitzar lusuari i carregar-ho a la pantalla dinici
	 * @param event
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public void handleUpdate(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		/* VARIABLES THAT GET THE DATA */
		HashPassword hash = new HashPassword();
		
		boolean logIn = false;
		boolean signUp = false;
		
		String username = usernameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();
		String name = nameField.getText();
		String surname = surrnameField.getText();
		String imgurl = imgurlField.getText();
		String hashedPassword = hash.hashPassword(password);
		System.out.println(username);
		UserDAO updater = new UserDAO();
		UserVO updateUser = new UserVO(username, email, hashedPassword, name, surname, imgurl);

		/* TAKE THE DATA FROM LOG IN OR REGISTER (uid) */
		
			if (logIn = true) {
				updateUser.setUid(mainApp.getCurrUser().getUid());
				System.out.print(mainApp.getCurrUser().getUid());
			}else if (signUp = true){
				updateUser.setUid(mainApp.getCurrUser().getUid());
			}
			
			/* DON'T UPDATE THE USER IF THERE'S ANY EMPTY FIELD */
			
			if ( usernameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() || surrnameField.getText().trim().isEmpty() || imgurlField.getText().trim().isEmpty() || !checkValidUrlBoolean(imgurl)) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setHeaderText(null);
			    alert.setTitle("Error");
			    alert.setContentText("Omple tots els camps abans d'actualitzar el teu perfil.");
			    alert.showAndWait();
				
			} else {
				/* UPDATES THE USER IN CASE THE DATA ENTERED IS CORRECT */			
				if (updater.userUpdater(updateUser)) {
					 Alert alert = new Alert(Alert.AlertType.INFORMATION);
					 alert.setHeaderText(null);
					 alert.setTitle("Info");
					 alert.setContentText("Usuari actualitzat amb exit");
					 //ACTUALIZAR PAGINA DE INICIO CON LOS NUEVOS DATOS INTRODUCIDOS POR EL USUARIO
					 alert.showAndWait();
					 
					 UserVO newUser = new UserVO(username, email, hashedPassword, name, surname, imgurl);
					 mainApp.reloadUser(newUser);
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
				    alert.setHeaderText(null);
				    alert.setTitle("Error");
				    alert.setContentText("Error a la hora d'actualitzar el usuari");
				    alert.showAndWait();
				}
				
			}
	}
	
	/**
	 * Aquest metode es lencarregat de validar que la url de la imatge introduida sigui valida
	 * @param url
	 * @return
	 */
	public Boolean checkValidUrlBoolean(String url){  
        try {  
            BufferedImage image = ImageIO.read(new URL(url));  
            if(image != null){  
                return true;
            } else{
                return false;
            }

        } catch (MalformedURLException e) {  
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Hi ha hagut un problema a la hora de carregar la imatge, prova amb un altra");
		    alert.showAndWait();
            return false;
        } catch (IOException e) {  
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Hi ha hagut un problema a la hora de carregar la imatge, prova amb un altra");
		    alert.showAndWait();
            return false;  
        }
    }
	
	/**
	 * Aquest metode serveix per definir els camps i objectes abans de que carregui el fxml
	 * @param mainApp
	 * @throws IOException
	 */
    public void setMainApp(MainApp mainApp) throws IOException {
        this.mainApp = mainApp;
        System.out.println(mainApp == null);	
    	window = mainApp.getStage();
		mainApp.showLateralMenu(drawer);
    }
	
}
