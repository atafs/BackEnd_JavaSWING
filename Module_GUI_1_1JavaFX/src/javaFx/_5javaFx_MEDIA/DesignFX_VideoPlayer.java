package javaFx._5javaFx_MEDIA;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class DesignFX_VideoPlayer extends Application {

	//ATTRIBUTES
	MediaPlayer mediaplayer;

	//MAIN
	public static void main(String[] args) {
		launch(args);
	}

	//START
	@Override
	public void start(Stage stage) {
		Button btn_play, btn_pause, btn_stop;

		btn_play = new Button("Start");
		btn_pause = new Button("Pause");
		btn_stop = new Button("Stop");

		//LISTENER
		btn_play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.play();
			}
		});
		btn_pause.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.pause();
			}
		});
		btn_stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.stop();
			}
		});

		//MEDIA FILE
		Media videoFile = new Media(getClass().getClassLoader().getResource("javaFx/media/americoLIB_DATA_BASE_0014.mp4").toString());
		mediaplayer = new MediaPlayer(videoFile);
		//CHANGE START VOLUME (percentage)
		mediaplayer.setVolume(0.1);
		MediaView mediaView = new MediaView(mediaplayer);
		
		//SCALE PLAYER
	    mediaView.setFitWidth(320); 
	    mediaView.setFitHeight(240); 
	    mediaView.setPreserveRatio(false);

	    mediaView.setTranslateX(mediaView.getFitWidth()  / 2); 
	    mediaView.setTranslateY(mediaView.getFitHeight() / 2);
	    mediaView.setScaleX(2); mediaView.setScaleY(2);
		
	    //INSTANTIATE GUI
		VBox root = new VBox();
		root.getChildren().addAll(btn_play,btn_pause,btn_stop,mediaView);

		Scene scene = new Scene(root, 650, 600);
		stage.setScene(scene);

		stage.show();
	}

}
