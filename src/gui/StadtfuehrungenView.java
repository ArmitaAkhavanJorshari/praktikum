package gui;

import business.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class StadtfuehrungenView {
	
	private StadtfuehrungenControl stdcontrol;
	private StadtfuehrungenModel stdModel;
	private Stage primaryStage;
	private Pane pane     					= new  Pane();
	private Label lblEingabe    	 		= new Label("Eingabe");
	private Label lblAnzeige   	 	    	= new Label("Anzeige");
	private Label lblTitel 					= new Label("Titel:");
	private Label lblIdentnummer   		 	= new Label("Identnummer:");
	private Label lblKurzbeschreibung  	 	= new Label("Kurzbeschreibung:");
	private Label lblStartuhrzeit   		= new Label("Startuhrzeit:");
	private Label lblDaten  		 		= new Label("Daten:");
	private TextField txtTitel 	 			= new TextField();
	private TextField txtIdentnummer		= new TextField();
	private TextField txtKurzbeschreibung	= new TextField();
	private TextField txtStartuhrzeit		= new TextField();
	private TextField txtDaten	 	 		= new TextField();
	private TextArea txtAnzeige  			= new TextArea();
	private Button btnEingabe 		 		= new Button("Eingabe");
	private Button btnAnzeige 		 		= new Button("Anzeige");
	private MenuBar mnbrMenuLeiste  		= new MenuBar();
	private Menu mnDatei             		= new Menu("Datei");
	private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export"); 
	
	public StadtfuehrungenView(StadtfuehrungenControl stdcontrol,Stage primaryStage,StadtfuehrungenModel stdModel) {
		this.stdcontrol=stdcontrol;
		this.stdModel=stdModel;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Stadtfuehrungen");
    	primaryStage.show();
    	initKomponenten();
		initListener();
		
		this.primaryStage=primaryStage;
	}
	
	private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblTitel.setLayoutX(20);
    	lblTitel.setLayoutY(90);
    	lblIdentnummer.setLayoutX(20);
    	lblIdentnummer.setLayoutY(130);
    	lblKurzbeschreibung.setLayoutX(20);
    	lblKurzbeschreibung.setLayoutY(170);
    	lblStartuhrzeit.setLayoutX(20);
    	lblStartuhrzeit.setLayoutY(210);
    	lblDaten.setLayoutX(20);
    	lblDaten.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblTitel, lblIdentnummer, lblKurzbeschreibung,
       		lblStartuhrzeit, lblDaten);
    
    	// Textfelder
     	getTxtTitel().setLayoutX(170);
    	getTxtTitel().setLayoutY(90);
    	getTxtTitel().setPrefWidth(200);
    	getTxtIdentnummer().setLayoutX(170);
    	getTxtIdentnummer().setLayoutY(130);
    	getTxtIdentnummer().setPrefWidth(200);
    	getTxtKurzbeschreibung().setLayoutX(170);
    	getTxtKurzbeschreibung().setLayoutY(170);
    	getTxtKurzbeschreibung().setPrefWidth(200);
      	getTxtStartuhrzeit().setLayoutX(170);
    	getTxtStartuhrzeit().setLayoutY(210);
    	getTxtStartuhrzeit().setPrefWidth(200);
    	getTxtDaten().setLayoutX(170);
    	getTxtDaten().setLayoutY(250);
    	getTxtDaten().setPrefWidth(200);
      	pane.getChildren().addAll( 
     		getTxtTitel(), getTxtIdentnummer(), getTxtKurzbeschreibung(),
     		getTxtStartuhrzeit(), getTxtDaten());
     	
        // Textbereich	
        getTxtAnzeige().setEditable(false);
     	getTxtAnzeige().setLayoutX(400);
    	getTxtAnzeige().setLayoutY(90);
     	getTxtAnzeige().setPrefWidth(270);
    	getTxtAnzeige().setPrefHeight(185);
       	pane.getChildren().add(getTxtAnzeige()); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	stdcontrol.nehmeStadtfuehrungAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		stdcontrol.zeigeStadtfuehrungenAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		stdcontrol.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	stdcontrol.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stdcontrol.schreibeStadtfuehrungenInCsvDatei();
			}	
	    });
    }
   
    void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }

public TextField getTxtTitel() {
	return txtTitel;
}

public void setTxtTitel(TextField txtTitel) {
	this.txtTitel = txtTitel;
}

public TextField getTxtIdentnummer() {
	return txtIdentnummer;
}

public void setTxtIdentnummer(TextField txtIdentnummer) {
	this.txtIdentnummer = txtIdentnummer;
}

public TextField getTxtKurzbeschreibung() {
	return txtKurzbeschreibung;
}

public void setTxtKurzbeschreibung(TextField txtKurzbeschreibung) {
	this.txtKurzbeschreibung = txtKurzbeschreibung;
}

public TextField getTxtStartuhrzeit() {
	return txtStartuhrzeit;
}

public void setTxtStartuhrzeit(TextField txtStartuhrzeit) {
	this.txtStartuhrzeit = txtStartuhrzeit;
}

public TextField getTxtDaten() {
	return txtDaten;
}

public void setTxtDaten(TextField txtDaten) {
	this.txtDaten = txtDaten;
}

public TextArea getTxtAnzeige() {
	return txtAnzeige;
}

public void setTxtAnzeige(TextArea txtAnzeige) {
	this.txtAnzeige = txtAnzeige;
}

}
