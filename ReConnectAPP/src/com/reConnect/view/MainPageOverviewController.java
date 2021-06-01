package com.reConnect.view;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.reConnect.model.PostDAO;
import com.reConnect.model.PostVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPageOverviewController {
	@FXML
	TextField titleTextField;
	@FXML
	TextField bodyTextField;
	@FXML
	Label usernameLabel;
	@FXML
	ImageView profileImageView;
	@FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

	
	SignInOverviewController user;
	
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
	   	        drawer.close();
	   	    } else {
	   	        drawer.open();
	   	    }
	   	});
		
		/*URI url = new URI("http://userserve-ak.last.fm/serve/126/8636005.jpg");
		Image image = ImageIO.read(url.openStream());*/
		//profileImageView.setImage(image);
	    usernameLabel.setText(SignInOverviewController.getUsername());
	}
	
	
    @FXML
    public void handlePosts() {
    	try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PostOverview.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }
    
    @FXML
    public void handleSubmitPost() {
    	System.out.println("test");
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