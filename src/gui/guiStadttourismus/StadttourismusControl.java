package gui.guiStadttourismus;
import business.StadtfuehrungenModel;
import javafx.stage.Stage;

public class StadttourismusControl {

		private StadttourismusView stadttourismusView;
		private StadtfuehrungenModel stadtfuehrungenModel;
		public StadttourismusControl(Stage primaryStage){
	 		this.stadtfuehrungenModel = StadtfuehrungenModel.getInstance();
	 		
			this.stadttourismusView 
			 	= new StadttourismusView(this, primaryStage,
				stadtfuehrungenModel);
			stadtfuehrungenModel.addObserver(stadttourismusView);
		}
	


}
