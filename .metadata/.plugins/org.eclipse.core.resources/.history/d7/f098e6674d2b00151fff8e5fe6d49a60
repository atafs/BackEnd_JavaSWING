package gui.tests;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gui_v5 extends Application {

    private Stage window;
    private Scene scene, scene2;
    private static TextArea console;
    private static String messageToConsole = "";
    private static final int MAX_WITH_CONSOLE = 1200;
    private String pathCSS = "gui/styles/myStyle_v1.css";

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//SET ICON
    	primaryStage.getIcons().add(new Image("media//morphisICON.jpg"));
 
        window = primaryStage;
        primaryStage.setResizable(false);
        window.setTitle("Ellucian - Jira Issues");
        
        //SCENE01 ##############################################
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //BUTTONS
        Button createTasks = new Button("CREATE TASKS");
        GridPane.setConstraints(createTasks, 0, 1);
        createTasks.getStyleClass().add("button-blue");
        
        Button loadAttachments = new Button("LOAD ATTACHMENTS");
        GridPane.setConstraints(loadAttachments, 1, 1);
        loadAttachments.getStyleClass().add("button-red");
        
        Button createSubTasks = new Button("CREATE SUB-TASKS");
        GridPane.setConstraints(createSubTasks, 2, 1);
        createSubTasks.getStyleClass().add("button-green");
        
        Button createAll = new Button("CREATE ALL");
        GridPane.setConstraints(createAll, 3, 1);
        createAll.getStyleClass().add("button-purple");
        
        //IMAGE
        Image image = new Image("media/morphis.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        //Add everything to grid
        grid.getChildren().addAll(createTasks, loadAttachments, createSubTasks, createAll);
        
        //LISTENERS FOR BUTTONS
        createTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createTasks");
                printMessageInConsole("createTasks");
                window.setScene(scene2);
            }
        });
        
        loadAttachments.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("loadAttachments");
                printMessageInConsole("loadAttachments");
                window.setScene(scene2);
            }
        });
        
        createSubTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createSubTasks");
                printMessageInConsole("createSubTasks");
                window.setScene(scene2);
            }
        });
        
        createAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createAll");
                printMessageInConsole("createAll");
                window.setScene(scene2);
            }
        });
        //######################################################

        
        //SCENE02 ##############################################
        //LAYOUT02
        Group root2 = new Group();
        GridPane gridpane = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //TEXTAREA
        console = new TextArea();
        //cssEditorFld.setPrefRowCount(10);
        console.setPrefColumnCount(100);
        console.setWrapText(true);
        console.setPrefWidth(MAX_WITH_CONSOLE - 10);
        //GridPane.setHalignment(console, HPos.CENTER);
        //GridPane.setConstraints(console, 1, 1);

        String cssDefault = "click the start button to begin execute application...";
        console.setText(cssDefault);
        
        //BUTTON
        Button start = new Button("START");
        GridPane.setConstraints(start, 0, 1);
        start.getStyleClass().add("button-red");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n");
            	testRunProgram("half way there..." + "\n");
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n");
            	testRunProgram("finished the program..." + "\n");
            }
        });
        
        Button clean = new Button("CLEAN");
        GridPane.setConstraints(clean, 1, 1);
        clean.getStyleClass().add("button-orange");
        clean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	console.setText("");
            	messageToConsole = "";
            	
            }
        });
        
        Button back = new Button("BACK");
        GridPane.setConstraints(back, 2, 1);
        back.getStyleClass().add("button-blue");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createAll");
                printMessageInConsole("returning to main menu");
                window.setScene(scene);
            }
        });

        gridpane.getChildren().addAll(start, clean, back);
  
        scene2 = new Scene(root2);
        scene2.setFill(Color.BLACK);
        scene2.getStylesheets().add(pathCSS);
        VBox box2 = new VBox();
        box2.getChildren().add(console);
        box2.getChildren().add(gridpane);
        root2.getChildren().add(box2);

        //######################################################

        //LAYOUT01
        Group root = new Group();
        scene = new Scene(root);
        scene.getStylesheets().add(pathCSS);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(grid);
        box.getChildren().add(iv1);
        root.getChildren().add(box);

        window.setScene(scene);
        window.sizeToScene(); 
        window.show();
    }
    
    //CALL STATIC METHOD
    public static void printMessageInConsole(String message) {
    	System.err.println(message);
    }
    
    public static void printToTextArea(String message) {
    	console.setText(message);
    }
    
    public void testRunProgram(String message) {
    	messageToConsole += message;
    	console.setText(messageToConsole);
    }
}