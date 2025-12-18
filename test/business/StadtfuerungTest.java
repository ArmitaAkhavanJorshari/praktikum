package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



class StadtfuehrungTest {

	//Altstadt,1,Rundgang,10,20251207,20251208,20251215
	    private Stadtfuehrung stadtfuehrung;
	    private String[] daten = {"20251207_20251208_20251215"};

	    @BeforeEach
	    void setUp() throws Exception {
	        stadtfuehrung = new Stadtfuehrung(
	            "Altstadt",
	            1,                 
	            "Rundgang",
	            10.0f,
	            daten
	        );
	    }

	    @AfterEach
	    void tearDown() throws Exception {
	        stadtfuehrung = null;
	    }

	    @Test
	    void test() {

	        
	        assertTrue(
	            () -> stadtfuehrung.getIdentnummer() == 1,
	            () -> "Der Test war erfolgreich!"
	        );

	        
	        Throwable exc = assertThrows(IllegalArgumentException.class,
	            () -> {new Stadtfuehrung(null,1,"Rundgang",10.0f,daten);
	            }
	        );

	        assertEquals("Titel darf nicht null sein",
	            exc.getMessage()
	        );
	    }
	


	}



