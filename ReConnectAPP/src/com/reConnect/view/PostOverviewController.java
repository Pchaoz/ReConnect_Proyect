package com.reConnect.view;

import java.io.IOException;

import com.reConnect.MainApp;
import com.reConnect.model.PostVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PostOverviewController {
    @FXML
    private TableView<PostVO> personTable;
    @FXML
    private TableColumn<PostVO, String> titleColumn;
    /**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */ @FXML
    private TableColumn<PostVO, String> bodyColumn;
    @FXML
    private ImageView profileImageView;
	private Stage window;
	private MainApp mainApp;
  
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @throws IOException 
     */
    @FXML
	public void initialize() throws IOException {
    	try {
        	// Initialize the person table with the two columns.    	
        	titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
        	bodyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMessage()));
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}

	}
    /**
     * Es lencarregat de enviar lusuari a la pagina anterior (mainPage)
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleReturn(ActionEvent event) throws IOException {
    	window = mainApp.getStage();
		mainApp.showMainPageOverview(event, window);
    }
    
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     * @throws IOException 
     */
    public void setMainApp(MainApp mainApp) throws IOException {
        this.mainApp = mainApp;
        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
        mainApp.reloadDB(personTable);
    }
    

 }
