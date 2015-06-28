package javaFx._2javaFxWithCSS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DesignFX_CSS extends Application {

	//ATRIBUTES
	private Label lb_text;
	private Button btn_click;

	//MAIN
	public static void main(String[] args) {
		launch(args);
	}

	//START
	@Override
	public void start(Stage stage) throws Exception {
		//SHADOW EFFECT (extra line)
		DropShadow ds = new DropShadow();
		ds.setOffsetY(5.0);
		ds.setOffsetX(5.0);
		ds.setColor(Color.WHITE);

		//REFLECTION EFFECT
		Reflection reflection = new Reflection();
		reflection.setFraction(0.8);
		reflection.setTopOffset(-20);

		//INSTANTIATE COMPONENTS
		lb_text = new Label("Here some Text");
		btn_click = new Button("Click it");

		//ADD EFFECT
		btn_click.setEffect(ds);
		lb_text.setEffect(reflection);

		//CHECK FOR STYLE CLASS (otherwise it does not change)
		lb_text.getStyleClass().add("my_customLabel");

		//LISTENER
		btn_click.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				lb_text.setText("New Text");
			}
		});

		//INSTANTIATE WINDOW
		VBox root = new VBox();
		root.getChildren().addAll(lb_text, btn_click);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);

		//ADD CSS TO APP
		scene.getStylesheets().add("javaFx/_2javaFxWithCSS/myStyle.css");

		stage.show();

	}
}