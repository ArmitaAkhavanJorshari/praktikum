package business;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Vector;

//import fileCreatorsAkhavan.ConcreteCsvCreator;
import ownUtil.Observable;
import ownUtil.Observer;

public class StadtfuehrungenModel implements Observable {
	
	private static StadtfuehrungenModel instance=new StadtfuehrungenModel();
	
	private StadtfuehrungenModel() {
		
	}
	
	public static StadtfuehrungenModel getInstance() {
		if(instance==null) {
			instance=new StadtfuehrungenModel();
		}
		return instance;
	}
	private ArrayList<Stadtfuehrung> stadfuehrung=new ArrayList<>();

	public ArrayList<Stadtfuehrung> getStadfuehrung() {
		return stadfuehrung;
	}

	public void addStadfuehrung(Stadtfuehrung s) {
		stadfuehrung.add(s);
		
	}

	 public void leseAusCSVDatei(String type) throws Exception{
		/*BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
		String[] zeile = ein.readLine().split(";");
		stadfuehrung = new Stadtfuehrung(zeile[0], 
			Integer.parseInt(zeile[1]), 
			zeile[2], 
			Float.parseFloat(zeile[3]), 
			zeile[4].split("_"));
			ein.close();*/
		 
			 fileCreatorsAkhavan.ReaderCreatorAkhavan rca=new fileCreatorsAkhavan.ConcreteCsvCreator();
			 fileCreatorsAkhavan.ReaderProductAkhavan reader=rca.factoryMethode();
			 
			 String[] zeile=reader.leseAusDatei();
			 Stadtfuehrung s=new Stadtfuehrung(zeile[0], Integer.parseInt(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
			 addStadfuehrung(s);
			 reader.schliesseDatei();
			 
			 notifyObservers();
		 
		
	}
	 public void leseAusTXTDatei(String type) throws Exception{
			
			 
				 fileCreatorsAkhavan.ReaderCreatorAkhavan rca=new fileCreatorsAkhavan.ConcreteTxtCreator();
				 fileCreatorsAkhavan.ReaderProductAkhavan reader=rca.factoryMethode();
				 
				 String[] zeile=reader.leseAusDatei();
				 Stadtfuehrung s=new Stadtfuehrung(zeile[0], Integer.parseInt(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
				 addStadfuehrung(s);
				 reader.schliesseDatei();
				 
				 notifyObservers();
			 
			
		}
	 public void schreibeStadtfuehrungenInCsvDatei() throws Exception{
		
		BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true));
		for(Stadtfuehrung s:stadfuehrung) {
			aus.write(s.gibStadtfuehrungZurueck(';'));
		}
		
		aus.close();
	}
	 
	  private Vector<Observer> observers=new Vector<Observer>();

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer obs : observers) {
			obs.update();
		}
		
	}
	
		
	

}
