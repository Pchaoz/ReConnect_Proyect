package com.reConnect;

import com.jfoenix.controls.JFXDrawer;
import com.reConnect.model.PostDAO;
import com.reConnect.model.PostVO;
import com.reConnect.model.UserDAO;
import com.reConnect.model.UserVO;
import com.reConnect.view.DrawerContentController;
import com.reConnect.view.MainPageOverviewController;
import com.reConnect.view.PostOverviewController;
import com.reConnect.view.ProfileEditOverviewController;
import com.reConnect.view.SignInOverviewController;
import com.reConnect.view.SignUpOverviewController;
import com.reConnect.view.StartMenuOverviewController;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {
	private Stage primaryStage;
	
	/**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<PostVO> personData = FXCollections.observableArrayList();
	private String url;
	private String name;
	private String surname;
	private UserVO currUser;
	public ObservableList<PostVO> returnPersonData(){
		return personData;
	}
	/**
	 * Constructor
	 */
	public MainApp() {
		PostDAO daoProva = new PostDAO();
		ArrayList<PostVO> arraylist = daoProva.obtainAllPosts();		

		for(int i=0; i< arraylist.size();i++) {
			personData.add(arraylist.get(i));
		}
	}
	
	/**
	 * Es lencarregat de recarregar la llista missatges en cas d'haver alguna actualizació
	 * @param personTable
	 */
    public void reloadDB(TableView<PostVO> personTable) {
    	PostDAO currEmpDAO = new PostDAO();
        ArrayList<PostVO> arraylist;
        arraylist = currEmpDAO.obtainAllPosts();
        personTable.getItems().clear();
        
        for(int i=0; i< arraylist.size();i++) {
			personData.add(arraylist.get(i));
		}
    }
    
    public void reloadUser(UserVO currentUser) {
    	UserDAO reloadUser = new UserDAO();
    	reloadUser.loadUser(currentUser);
    	setURL(currentUser);
    	setName(currentUser);
    	setSurname(currentUser);
    	setCurrUser(currentUser);
    }
    
    public UserVO setCurrUser(UserVO currentUser) {
    	currUser = currentUser;
    	return currUser;
    }
    
    public UserVO getCurrUser() {
    	return currUser;
    }
    
    public String setURL(UserVO currentUser) {
    	url = currentUser.getImgUrl();
    	return url;
    }
    
    public String getURL() {
    	return url;
    }
    
    public String setName(UserVO currentUser) {
    	name = currentUser.getName();
    	return url;
    }
    
    public String getName() {
    	return name;
    }
    
    public String setSurname(UserVO currentUser) {
    	surname = currentUser.getSurname();
    	return surname;
    }
    
    public String getSurname() {
    	return surname;
    }
    
	/**
	 * Mètode principal que executa la aplicacio
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<PostVO> getPersonData() {
		return personData;
	}

	/**
	 * Returns the stage
	 */
	public Stage getStage() {
		return primaryStage;
	}
	
	/**
	 * Es lencarregat de canviar el titol i fer un set de la escena primaria i ensenyarla
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("reConnect");        
		showAppOverview();
	}
	
	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showAppOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StartMenuOverview.fxml"));
			AnchorPane appOverview = (AnchorPane) loader.load();
			Scene scene = new Scene(appOverview);
	        

			primaryStage.setScene(scene);
			primaryStage.show();


			// Give the controller access to the main app.
			StartMenuOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showStartPageOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/StartMenuOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		StartMenuOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showSignUpOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/SignInOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		SignInOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showSignInOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/SignUpOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);
		window.setScene(newScene); 
		window.show();

		SignUpOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showMainPageOverview(ActionEvent event, Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/MainPageOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);
		window.setScene(newScene); 
		window.show();

		MainPageOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showLateralMenu(JFXDrawer drawer) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/DrawerContent.fxml"));
		VBox box = (VBox) loader.load();

		drawer.setSidePane(box);

		DrawerContentController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showPostOverview(Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/PostOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		PostOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}

	/**
	 * Dona acces al mainApp i canvia la pestanya per una de nova
	 */
	public void showProfileEditOverview(Stage window) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/ProfileEditOverview.fxml"));
		AnchorPane appOverview = (AnchorPane) loader.load();
		Scene newScene = new Scene(appOverview);

		window.setScene(newScene); 
		window.show();

		ProfileEditOverviewController controller1 = loader.getController();
		controller1.setMainApp(this);
	}
	

}
