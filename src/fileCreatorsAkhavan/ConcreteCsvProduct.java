package fileCreatorsAkhavan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class ConcreteCsvProduct extends ReaderProductAkhavan {
	
	public ConcreteCsvProduct() throws FileNotFoundException {
	
		this.ein =  new BufferedReader(new FileReader("Stadtfuehrung.csv"));
	}

	private BufferedReader ein ;

	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] zeile = ein.readLine().split(";");
		/*Stadtfuehrung s =new Stadtfuehrung(zeile[0],Integer.parseInt(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));*/
			
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}
	
	

}
