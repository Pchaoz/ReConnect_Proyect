package com.reConnect.view;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class UserListOverviewController {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    
    @FXML
    public void initialize() throws IOException {
    	
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
    }
}
