package gui.tests;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gui_v7 extends Application {

    private Stage window;
    private Scene scene, scene2, sceneAttach, sceneSubtask, sceneAll;
    private static TextArea console, consoleSubtask, consoleAttach, consoleAll;
    private static String messageToConsole = "";
    private static final int MAX_WITH_CONSOLE = 1200;
    private String pathCSS = "gui/styles/myStyle_v1.css";
    private String pathMEDIA = "media";

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//SET ICON
    	primaryStage.getIcons().add(new Image(pathMEDIA + "/morphisICON.jpg"));
 
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
        Image image = new Image(pathMEDIA + "/morphis.jpg");
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
                window.setScene(sceneAttach);
            }
        });
        
        createSubTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createSubTasks");
                printMessageInConsole("createSubTasks");
                window.setScene(sceneSubtask);
            }
        });
        
        createAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createAll");
                printMessageInConsole("createAll");
                window.setScene(sceneAll);
            }
        });
        //######################################################

        
        //SCENE02 CREATE TASKS##################################
        //LAYOUT02
        Group root2 = new Group();
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setVgap(8);
        gridpane.setHgap(10);
        
        //TEXTAREA
        console = new TextArea();
        //cssEditorFld.setPrefRowCount(10);
        console.setPrefColumnCount(100);
        console.setWrapText(true);
        console.setPrefWidth(MAX_WITH_CONSOLE - 10);
        //GridPane.setHalignment(console, HPos.CENTER);
        //GridPane.setConstraints(console, 1, 1);

        String cssDefault = "CREATE TASKS";
        console.setText(cssDefault);
        
        //TEXTFIELD
        TextField type2 = new TextField(cssDefault);
        type2.setDisable(true);
        GridPane.setConstraints(type2, 4, 1);
        
        //BUTTON
        Button start = new Button("START");
        GridPane.setConstraints(start, 0, 1);
        start.getStyleClass().add("button-blue");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", console);
            	testRunProgram("half way there..." + "\n", console);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", console);
            	testRunProgram("finished the program..." + "\n", console);
            	start.setDisable(true);
            }
        });
        
        Button update = new Button("UPDATE");
        GridPane.setConstraints(update, 1, 1);
        update.getStyleClass().add("button-red");
        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", console);
            	testRunProgram("half way there..." + "\n", console);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", console);
            	testRunProgram("finished the program..." + "\n", console);
            }
        });
        
        Button clean = new Button("CLEAN");
        GridPane.setConstraints(clean, 2, 1);
        clean.getStyleClass().add("button-orange");
        clean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	console.setText("");
            	messageToConsole = "";
            	
            }
        });
        
        Button back = new Button("BACK");
        GridPane.setConstraints(back, 3, 1);
        back.getStyleClass().add("button-purple");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	messageToConsole = "";
                printMessageInConsole("returning to main menu");
                window.setScene(scene);
                start.setDisable(false);
            }
        });

        gridpane.getChildren().addAll(start, update, clean, back, type2);
  
        scene2 = new Scene(root2);
        scene2.setFill(Color.BLACK);
        scene2.getStylesheets().add(pathCSS);
        VBox box2 = new VBox();
        box2.getChildren().add(console);
        box2.getChildren().add(gridpane);
        root2.getChildren().add(box2);

        //######################################################
        
        //SCENE02 CREATE ATTACH###############################
        //LAYOUT02
        Group rootAttach = new Group();
        GridPane gridpaneAttach = new GridPane();
        gridpaneAttach.setPadding(new Insets(10, 10, 10, 10));
        gridpaneAttach.setVgap(8);
        gridpaneAttach.setHgap(10);
        
        //TEXTAREA
        consoleAttach = new TextArea();
        //cssEditorFld.setPrefRowCount(10);
        consoleAttach.setPrefColumnCount(100);
        consoleAttach.setWrapText(true);
        consoleAttach.setPrefWidth(MAX_WITH_CONSOLE - 10);
        //GridPane.setHalignment(console, HPos.CENTER);
        //GridPane.setConstraints(console, 1, 1);

        String cssDefaultAttach = "LOAD ATTACHMENTS";
        consoleAttach.setText(cssDefaultAttach);
        
        //TEXTFIELD
        TextField typeAttach = new TextField(cssDefaultAttach);
        typeAttach.setDisable(true);
        GridPane.setConstraints(typeAttach, 4, 1);
        
        //BUTTON
        Button startAttach = new Button("START");
        GridPane.setConstraints(startAttach, 0, 1);
        startAttach.getStyleClass().add("button-blue");
        startAttach.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleAttach);
            	testRunProgram("half way there..." + "\n", consoleAttach);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleAttach);
            	testRunProgram("finished the program..." + "\n", consoleAttach);
            	startAttach.setDisable(true);
            }
        });
        
        Button updateAttach = new Button("UPDATE");
        GridPane.setConstraints(updateAttach, 1, 1);
        updateAttach.getStyleClass().add("button-red");
        updateAttach.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleAttach);
            	testRunProgram("half way there..." + "\n", consoleAttach);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleAttach);
            	testRunProgram("finished the program..." + "\n", consoleAttach);
            }
        });
        
        Button cleanAttach = new Button("CLEAN");
        GridPane.setConstraints(cleanAttach, 2, 1);
        cleanAttach.getStyleClass().add("button-orange");
        cleanAttach.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	consoleAttach.setText("");
            	messageToConsole = "";
            	
            }
        });
        
        Button backAttach = new Button("BACK");
        GridPane.setConstraints(backAttach, 3, 1);
        backAttach.getStyleClass().add("button-purple");
        backAttach.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	messageToConsole = "";
                printMessageInConsole("returning to main menu");
                window.setScene(scene);
                startAttach.setDisable(false);
            }
        });

        gridpaneAttach.getChildren().addAll(startAttach, cleanAttach, backAttach, updateAttach, typeAttach);
  
        sceneAttach = new Scene(rootAttach);
        sceneAttach.setFill(Color.BLACK);
        sceneAttach.getStylesheets().add(pathCSS);
        VBox boxAttach = new VBox();
        boxAttach.getChildren().add(consoleAttach);
        boxAttach.getChildren().add(gridpaneAttach);
        rootAttach.getChildren().add(boxAttach);

        //######################################################

        //SCENE02 CREATE SUBTASKS##################################
        //LAYOUT02
        Group rootSubtask = new Group();
        GridPane gridpaneSubtask = new GridPane();
        gridpaneSubtask.setPadding(new Insets(10, 10, 10, 10));
        gridpaneSubtask.setVgap(8);
        gridpaneSubtask.setHgap(10);
        
        //TEXTAREA
        consoleSubtask = new TextArea();
        //cssEditorFld.setPrefRowCount(10);
        consoleSubtask.setPrefColumnCount(100);
        consoleSubtask.setWrapText(true);
        consoleSubtask.setPrefWidth(MAX_WITH_CONSOLE - 10);
        //GridPane.setHalignment(console, HPos.CENTER);
        //GridPane.setConstraints(console, 1, 1);

        String cssDefaultSubtask = "CREATE SUB_TASKS";
        consoleSubtask.setText(cssDefaultSubtask);
        
        //TEXTFIELD
        TextField typeSubtask = new TextField(cssDefaultSubtask);
        typeSubtask.setDisable(true);
        GridPane.setConstraints(typeSubtask, 4, 1);
        
        //BUTTON
        Button startSubtask = new Button("START");
        GridPane.setConstraints(startSubtask, 0, 1);
        startSubtask.getStyleClass().add("button-blue");
        startSubtask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleSubtask);
            	testRunProgram("half way there..." + "\n", consoleSubtask);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleSubtask);
            	testRunProgram("finished the program..." + "\n", consoleSubtask);
            	startSubtask.setDisable(true);
            }
        });
        
        Button updateSubtask = new Button("UPDATE");
        GridPane.setConstraints(updateSubtask, 1, 1);
        updateSubtask.getStyleClass().add("button-red");
        updateSubtask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleSubtask);
            	testRunProgram("half way there..." + "\n", consoleSubtask);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleSubtask);
            	testRunProgram("finished the program..." + "\n", consoleSubtask);
            }
        });
        
        Button cleanSubtask = new Button("CLEAN");
        GridPane.setConstraints(cleanSubtask, 2, 1);
        cleanSubtask.getStyleClass().add("button-orange");
        cleanSubtask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	consoleSubtask.setText("");
            	messageToConsole = "";
            	
            }
        });
        
        Button backSubtask = new Button("BACK");
        GridPane.setConstraints(backSubtask, 3, 1);
        backSubtask.getStyleClass().add("button-purple");
        backSubtask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	messageToConsole = "";
                printMessageInConsole("returning to main menu");
                window.setScene(scene);
                startSubtask.setDisable(false);
            }
        });

        gridpaneSubtask.getChildren().addAll(startSubtask, cleanSubtask, backSubtask, updateSubtask, typeSubtask);
  
        sceneSubtask = new Scene(rootSubtask);
        sceneSubtask.setFill(Color.BLACK);
        sceneSubtask.getStylesheets().add(pathCSS);
        VBox boxSubtask = new VBox();
        boxSubtask.getChildren().add(consoleSubtask);
        boxSubtask.getChildren().add(gridpaneSubtask);
        rootSubtask.getChildren().add(boxSubtask);

        //######################################################

        //SCENE02 CREATE ALL##################################
        //LAYOUT02
        Group rootAll = new Group();
        GridPane gridpaneAll = new GridPane();
        gridpaneAll.setPadding(new Insets(10, 10, 10, 10));
        gridpaneAll.setVgap(8);
        gridpaneAll.setHgap(10);
        
        //TEXTAREA
        consoleAll = new TextArea();
        //cssEditorFld.setPrefRowCount(10);
        consoleAll.setPrefColumnCount(100);
        consoleAll.setWrapText(true);
        consoleAll.setPrefWidth(MAX_WITH_CONSOLE - 10);
        //GridPane.setHalignment(console, HPos.CENTER);
        //GridPane.setConstraints(console, 1, 1);

        String cssDefaultAll = "CREATE ALL";
        consoleAll.setText(cssDefaultAll);
        
        //TEXTFIELD
        TextField typeAll = new TextField(cssDefaultAll);
        typeAll.setDisable(true);
        GridPane.setConstraints(typeAll, 4, 1);
        
        //BUTTON
        Button startAll = new Button("START");
        GridPane.setConstraints(startAll, 0, 1);
        startAll.getStyleClass().add("button-blue");
        startAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleAll);
            	testRunProgram("half way there..." + "\n", consoleAll);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleAll);
            	testRunProgram("finished the program..." + "\n", consoleAll);
            	startAll.setDisable(true);
            }
        });
        
        Button updatetAll = new Button("UPDATE");
        GridPane.setConstraints(updatetAll, 1, 1);
        updatetAll.getStyleClass().add("button-red");
        updatetAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	testRunProgram("starting the program..." + "\n", consoleAll);
            	testRunProgram("half way there..." + "\n", consoleAll);
            	testRunProgram("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy..." + "\n", consoleAll);
            	testRunProgram("finished the program..." + "\n", consoleAll);
            }
        });
        
        Button cleanAll = new Button("CLEAN");
        GridPane.setConstraints(cleanAll, 2, 1);
        cleanAll.getStyleClass().add("button-orange");
        cleanAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	consoleAll.setText("");
            	messageToConsole = "";
            	
            }
        });
        
        Button backAll = new Button("BACK");
        GridPane.setConstraints(backAll, 3, 1);
        backAll.getStyleClass().add("button-purple");
        backAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	messageToConsole = "";
                printMessageInConsole("returning to main menu");
                window.setScene(scene);
                startAll.setDisable(false);
            }
        });

        gridpaneAll.getChildren().addAll(startAll, cleanAll, backAll, updatetAll, typeAll);
  
        sceneAll = new Scene(rootAll);
        sceneAll.setFill(Color.BLACK);
        sceneAll.getStylesheets().add(pathCSS);
        VBox boxAll = new VBox();
        boxAll.getChildren().add(consoleAll);
        boxAll.getChildren().add(gridpaneAll);
        rootAll.getChildren().add(boxAll);

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
    
    public void testRunProgram(String message, TextArea console) {
    	messageToConsole += message;
    	console.setText(messageToConsole);
    }
}