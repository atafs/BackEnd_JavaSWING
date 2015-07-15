package gui.tests;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class Test extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(500,400);
        
//        ListView list = new ListView();
//        BorderPane.setAlignment(list, Pos.TOP_LEFT);
//        BorderPane.setMargin(list, new Insets(12,12,12,12));
//        borderPane.setCenter(list);
//        
//        ToolBar toolbar = new ToolBar();
//        HBox statusbar = new HBox();
//        Node appContent = new AppContentNode();
//        borderPane.setTop(toolbar);
//        borderPane.setCenter(appContent);
//        borderPane.setBottom(statusbar);
    	
    	
    	window = primaryStage;
        window.setTitle("ListView Demo");
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 600, 500);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked(){
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String m: movies)
            message += m + "\n";

        System.out.println(message);
    }


}