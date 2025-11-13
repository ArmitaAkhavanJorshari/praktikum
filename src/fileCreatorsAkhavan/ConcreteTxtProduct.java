package fileCreatorsAkhavan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtProduct extends ReaderProductAkhavan{
	
	public ConcreteTxtProduct() throws FileNotFoundException {
		
		this.ein = new BufferedReader(new FileReader("Stadtfuehrung.txt"));;
	}

	private BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile =new String[5];
		String zeile=ein.readLine();
		int i=0;
		while(i< ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			zeile=ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

}
