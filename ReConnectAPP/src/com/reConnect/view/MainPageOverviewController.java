package com.reConnect.view;
import com.reConnect.model.PostVO;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainPageOverviewController {
    @FXML
    private TableView<PostVO> postTableView;
    @FXML
    private TableColumn<PostVO, String> userColumn;
    @FXML
    private TableColumn<PostVO, String> titleColumn;
    @FXML
    private TableColumn<PostVO, String> bodyColumn;
    
}