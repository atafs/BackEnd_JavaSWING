package javaFx._1firstJavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstFX extends Application{
	
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
		
		//NEW ELEMENTS
		lb_text = new Label("Here some Text");
		btn_click = new Button("Click it");
		
		//LISTENER
		btn_click.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				lb_text.setText("New Text");				
			}
		});
		
		//INITIALIZE WINDOW
		VBox root = new VBox();
		root.getChildren().addAll(lb_text, btn_click);
		
		Scene scene = new Scene(root, 500,500);
		stage.setScene(scene);
		
		stage.show();
	}
}
