package com.reConnect.view;

import java.io.IOException;

import com.reConnect.MainApp;
import com.reConnect.model.PostVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PostOverviewController {
    @FXML
    private TableView<PostVO> personTable;
    @FXML
    private TableColumn<PostVO, String> titleColumn;
    @FXML
    private TableColumn<PostVO, String> bodyColumn;
    private Stage window;
	private MainApp mainApp;
    /*
    public PostOverviewController() {
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @throws IOException 
     */
	
    @FXML
	public void initialize() throws IOException {

    	// Initialize the person table with the two columns.    	
    	titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
    	bodyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMessage())); 

	}
    /*
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     * @throws IOException 
     */
    public void setMainApp(MainApp mainApp) throws IOException {
        this.mainApp = mainApp;
        // Add observable list data to the table
        // 
        personTable.setItems(mainApp.getPersonData());
        System.out.println(mainApp == null);
    }
 }