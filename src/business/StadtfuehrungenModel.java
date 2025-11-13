package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import fileCreatorsAkhavan.ConcreteCsvCreator;

public class StadtfuehrungenModel {
	
	private Stadtfuehrung stadfuehrung;

	public Stadtfuehrung getStadfuehrung() {
		return stadfuehrung;
	}

	public void setStadfuehrung(Stadtfuehrung stadfuehrung) {
		this.stadfuehrung = stadfuehrung;
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
			 this.stadfuehrung=new Stadtfuehrung(zeile[0], Integer.parseInt(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
			 reader.schliesseDatei();
		 
		
	}
	 public void leseAusTXTDatei(String type) throws Exception{
			
			 
				 fileCreatorsAkhavan.ReaderCreatorAkhavan rca=new fileCreatorsAkhavan.ConcreteTxtCreator();
				 fileCreatorsAkhavan.ReaderProductAkhavan reader=rca.factoryMethode();
				 
				 String[] zeile=reader.leseAusDatei();
				 this.stadfuehrung=new Stadtfuehrung(zeile[0], Integer.parseInt(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
				 reader.schliesseDatei();
			 
			
		}
	 public void schreibeStadtfuehrungenInCsvDatei() throws Exception{
		
		BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true));
		aus.write(stadfuehrung.gibStadtfuehrungZurueck(';'));
		aus.close();
	}
	 public void schreibeStadtfuehrungenInTXTDatei() throws Exception{
			
			BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.txt", true));
			aus.write(stadfuehrung.gibStadtfuehrungZurueck('\n'));
			aus.close();
		}
		
	

}
