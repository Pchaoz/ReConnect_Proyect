package com.reConnect.view;

import com.reConnect.MainApp;
import com.reConnect.model.PostVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PostOverviewController {
    @FXML
    private TableView<PostVO> personTable;
    @FXML
    private TableColumn<PostVO, String> titleColumn;
    @FXML
    private TableColumn<PostVO, String> bodyColumn;
    
    @SuppressWarnings("unused")
	private MainApp mainApp;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        // Initialize the person table with the two columns.    	
    	titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
    	bodyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMessage())); 
    	
    	/*try {

    		trastoDAO = new TrastoDAO();
    		trastosList = trastoDAO.buscarTrasto(barraBuscadorra.getText());

    		//Netejar la llista d'empleats
    		trastosTable.getItems().clear();

    		//carregarlos a empleatable
    		for(int i=0; i trastosTable.getItems().add(trastosList.get(i));
    	}*/
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
 }
