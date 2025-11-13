package fileCreatorsAkhavan;

import java.io.FileNotFoundException;

public class ConcreteCsvCreator extends ReaderCreatorAkhavan {

	public ReaderProductAkhavan factoryMethode() throws FileNotFoundException {
		
		return new ConcreteCsvProduct();
	}

}
