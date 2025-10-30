package gui;



import business.Stadtfuehrung;
import business.StadtfuehrungenModel;
import javafx.stage.Stage;

public class StadtfuehrungenControl {
	
	private StadtfuehrungenView stdview;
	private StadtfuehrungenModel stdmodel;
	
	public StadtfuehrungenControl(Stage primaryStage) {
		this.stdview=new StadtfuehrungenView(this, primaryStage, stdmodel);
		this.stdmodel=new StadtfuehrungenModel();
	}
	
	 void nehmeStadtfuehrungAuf(){
    	try{ 
    		stdmodel.setStadfuehrung(new Stadtfuehrung(
    			stdview.getTxtTitel().getText(), 
   	            Integer.parseInt(stdview.getTxtIdentnummer().getText()),
   	            stdview.getTxtKurzbeschreibung().getText(),
   	            Float.parseFloat(stdview.getTxtStartuhrzeit().getText()),
    		    stdview.getTxtDaten().getText().split(";")));
       	}
       	catch(Exception exc){
       		stdview.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
     void zeigeStadtfuehrungenAn(){
    	if(stdmodel.getStadfuehrung() != null){
    		stdview.getTxtAnzeige().setText(stdmodel.getStadfuehrung().gibStadtfuehrungZurueck(' '));
    	}
    	else{
    		stdview.zeigeInformationsfensterAn("Bisher wurde keine Stadtfuehrung aufgenommen!");
    	}
    }    
		  
     void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			
      			stdmodel.leseAusDatei(typ);
      			stdview.zeigeInformationsfensterAn("Das Stadtfuehrung wurde gelesen!");
      		}
       		else{
	   			stdview.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		
		catch(Exception exc){
			stdview.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	 void schreibeStadtfuehrungenInCsvDatei() {
		try {
			stdmodel.schreibeStadtfuehrungenInCsvDatei();
   			stdview.zeigeInformationsfensterAn(
	   			"Die Stadtfuehrungen wurden gespeichert!");
		}	
		
		catch(Exception exc){
			stdview.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

}
