package com.reConnect.view;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.reConnect.model.PostVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPageOverviewController {
    @FXML
    private TableView<PostVO> postTableView;
    @FXML
    private TableColumn<PostVO, String> userColumn;
    @FXML
    private TableColumn<PostVO, String> titleColumn;
    @FXML
    private TableColumn<PostVO, String> bodyColumn;
    
    @FXML
    public void handlePosts(ActionEvent event)  throws IOException, NoSuchAlgorithmException{
    		Parent root = FXMLLoader.load(getClass().getResource("test.java"));
            Scene newScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
    }
}