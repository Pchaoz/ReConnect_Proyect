package com.reConnect.view;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		ListView<ListModel> listView = new ListView<>();
		listView.setCellFactory(lv -> new MessageCell());

		Scene scene = new Scene(listView, 400, 400);
		primaryStage.setScene(scene);
		//scene.getStylesheets().add("/css/default.css");
		primaryStage.show();
		ObservableList<ListModel> listModels = FXCollections.observableArrayList();
		listView.setItems(listModels);
		loadData(listModels);
	}

	public class MyFeed extends ListCell<ListModel>{
		GridPane newPostGridPane;
		Text profileText = new Text();
		Circle testCircle = new Circle();
		TextField titleTextField = new TextField();
		TextField bodyTextField = new TextField();
		Button submitButton = new Button();
		
		public MyFeed() {
			profileText.getStyleClass().add("profile-label");
			testCircle.getStyleClass().add("circle");
			titleTextField.getStyleClass().add("title-text");
			bodyTextField.getStyleClass().add("body-textfield");
			submitButton.getStyleClass().add("submit-btn");
			newPostGridPane = new GridPane();
			newPostGridPane.add(submitButton, 0, 0, 1, 1);
		}
	}

	public class MessageCell extends ListCell<ListModel> {
		HBox graphic;
		ImageView imageView = new ImageView();
		Text nameText = new Text();
		Text titleText = new Text();
		Text messageText = new Text();

		public MessageCell() {
			nameText.getStyleClass().add("label-text");
			titleText.getStyleClass().add("heading-text");
			imageView.setFitWidth(80);
			imageView.setFitHeight(80);
			messageText.setWrappingWidth(260);
			HBox messageBox = new HBox(messageText);
			messageBox.getStyleClass().add("standard-border");
			messageBox.setPadding(new Insets(6));
			VBox leftBox = new VBox(5, imageView, nameText);
			VBox rightBox = new VBox(5, titleText, messageBox);
			leftBox.setAlignment(Pos.TOP_CENTER);
			graphic = new HBox(10, leftBox, rightBox);
		}

		@Override
		public void updateItem(ListModel item, boolean empty) {
			System.out.println("here ");
			if ((item != null) && !empty) {
				System.out.println("updating");
				super.updateItem(item, empty);
				nameText.textProperty().bind(item.userNameProperty());
				titleText.textProperty().bind(item.titleProperty());
				messageText.textProperty().bind(item.messageProperty());
				imageView.imageProperty().bind(item.imageProperty());
				setGraphic(graphic);
			} else {
				setGraphic(null);
			}
		}
	}

	private void loadData(ObservableList<ListModel> listModels) {
		listModels.add(new ListModel("fred",
				new Image("https://image.flaticon.com/icons/png/512/145/145859.png"),
				"I'm Upset",
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, " + "totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae " + "vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut " + "odit aut fugit, sed quia consequuntur magni"));
		listModels.add(new ListModel("GeorgeX",
				new Image("https://image.flaticon.com/icons/png/512/3048/3048163.png"),
				"This is the Title",
				"adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam "
						+ "quaerat voluptatem. Ut enim ad minima veniam"));
	}

	class ListModel {
		StringProperty userName = new SimpleStringProperty("");
		ObjectProperty<Image> image = new SimpleObjectProperty<>();
		StringProperty title = new SimpleStringProperty("");
		StringProperty message = new SimpleStringProperty("");

		public ListModel(String userName, Image image, String title, String message) {
			this.userName.set(userName);
			this.image.set(image);
			this.title.set(title);
			this.message.set(message);
		}

		public StringProperty userNameProperty() {
			return userName;
		}

		public ObjectProperty<Image> imageProperty() {
			return image;
		}

		public StringProperty titleProperty() {
			return title;
		}

		public StringProperty messageProperty() {
			return message;
		}
	}
}
