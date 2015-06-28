package javaFx._4javaFxComboBOX;

import java.util.Date;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DesignFX_ComboBOX extends Application {

	//ATTRIBUTES
	ComboBox<Person> comboBox;

	//MAIN
	public static void main(String[] args) {
		launch(args);
	}

	//INIT GUI
	@Override
	public void init() {
		
		//INITIALIZE
		comboBox = new ComboBox<>();

		//SET ITENS
		comboBox.setItems(getPersonDummy());

		//PRE SELECT THE FIRST ITEM
		comboBox.getSelectionModel().select(2);

		//LISTENER
		comboBox.valueProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> arg0, Person person_before, Person person_after) {
				if (person_before != null) {
					System.out.print("PERSON BEFORE: " + person_before.getFirstname() + " -> ");
				}
				System.out.println("PERSON AFTER: " + person_after.getFirstname());
			}

		});

		//DEFINE CURRENT CELL
		comboBox.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {

			@Override
			public ListCell<Person> call(ListView<Person> arg0) {
				
				//INSTANTIATE LIST CELL
				ListCell<Person> cell = new ListCell<Person>() {

					//WHEN THE VALUE CHANGES
					@Override
					public void updateItem(Person person, boolean empty) {
						super.updateItem(person, empty);
						
						//CHECK IF IT IS EMPTY
						if (person != null) {
							setText(person.toString());
							
							//CHANGE COLOR IF THE PERSON NAME IS MAX
							if (person.getFirstname().equals("Americo")) {
								setTextFill(Color.RED);
							} else if(person.getFirstname().equals("Tomas")) {
								setTextFill(Color.GREEN);
							} else if(person.getFirstname().equals("Ana")) {
								setTextFill(Color.BLUE);
							}
						} else {
							setText(null);
						}
					}

				};
				return cell;
			}
		});
	}

	//START GUI
	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		root.getChildren().addAll(comboBox);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);

		stage.show();

	}

	//AUX STATIC METHOD: INSERT DATA TO LIST
	public static ObservableList<Person> getPersonDummy() {
		ObservableList<Person> data = FXCollections.observableArrayList();

		data.addAll(new Person("Americo", "Developer", new Date()));
		data.addAll(new Person("Tomas", "Telecom", new Date()));
		data.addAll(new Person("Ana", "Nurse", new Date()));

		return data;
	}
}
