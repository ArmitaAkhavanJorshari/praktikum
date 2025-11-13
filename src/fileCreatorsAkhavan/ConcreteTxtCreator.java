package fileCreatorsAkhavan;

import java.io.FileNotFoundException;

public class ConcreteTxtCreator extends ReaderCreatorAkhavan {

	@Override
	public ReaderProductAkhavan factoryMethode() throws FileNotFoundException {
		
		return new ConcreteTxtProduct();
	}

}
