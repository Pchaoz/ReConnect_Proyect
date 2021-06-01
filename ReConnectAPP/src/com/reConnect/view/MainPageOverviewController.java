package com.reConnect.view;

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
	
	SignInOverviewController user;
	@FXML
	public void initialize() {
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