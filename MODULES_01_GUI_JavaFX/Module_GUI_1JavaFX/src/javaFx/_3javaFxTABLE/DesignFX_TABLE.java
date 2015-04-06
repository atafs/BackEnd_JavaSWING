package javaFx._3javaFxTABLE;

import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DesignFX_TABLE extends Application {

	//ATTRIBUTES
	private TableView<Person> table;

	//MAIN
	public static void main(String[] args) {
		launch(args);
	}

	//INIT OF WINDOW
	@Override
	public void init() {
		table = new TableView<Person>();

		table.getColumns().addAll(Person.getColumn(table));

		//GET ObservableList DATA
		table.setItems(getPersonDummy());

		//LISTENER OF THE TABLE
		table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//ONLY WITH TWO CLICKS
				if (event.getClickCount() > 1) {
					if (table.getSelectionModel().getSelectedIndex() >= 0) {
						System.out.println(table.getSelectionModel().getSelectedItem().getFirstname());
					}
				}
			}
		});

	}

	//START
	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		root.getChildren().addAll(table);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);

		stage.show();

	}

	//ObservableList DATA
	public static ObservableList<Person> getPersonDummy() {
		ObservableList<Person> data = FXCollections.observableArrayList();

		data.addAll(new Person("Max", "Mustermann", new Date()));
		data.addAll(new Person("John", "Doe", new Date()));
		data.addAll(new Person("Random", "User", new Date()));

		return data;
	}
}
