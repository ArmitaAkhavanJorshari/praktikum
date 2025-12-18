package main;


import gui.guiStadtfuehrung.StadtfuehrungenControl;
import gui.guiStadttourismus.StadttourismusControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new StadtfuehrungenControl(primaryStage);
		
		Stage fensterStadttourismus = new Stage();
		new StadttourismusControl(fensterStadttourismus);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}

