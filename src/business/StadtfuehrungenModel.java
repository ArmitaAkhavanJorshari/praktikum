package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class StadtfuehrungenModel {
	
	private Stadtfuehrung stadfuehrung;

	public Stadtfuehrung getStadfuehrung() {
		return stadfuehrung;
	}

	public void setStadfuehrung(Stadtfuehrung stadfuehrung) {
		this.stadfuehrung = stadfuehrung;
	}

	 public void leseAusDatei(String txt) throws Exception{
		BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
		String[] zeile = ein.readLine().split(";");
		stadfuehrung = new Stadtfuehrung(zeile[0], 
			Integer.parseInt(zeile[1]), 
			zeile[2], 
			Float.parseFloat(zeile[3]), 
			zeile[4].split("_"));
			ein.close();
	}
	 public void schreibeStadtfuehrungenInCsvDatei() throws Exception{
		
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true));
		aus.write(stadfuehrung.gibStadtfuehrungZurueck(';'));
		aus.close();
	}
		
	

}
