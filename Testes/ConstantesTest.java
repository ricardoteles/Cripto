import static org.junit.Assert.*;

import org.junit.Test;


public class ConstantesTest {

	@Test
	public void testGeraConstantes() {
		Constantes cte = new Constantes();
		cte.geraConstantes();
		
		assertTrue("Constantes ok", cte.ConstR[0].equals("01011"));
		assertTrue("Constantes ok", cte.ConstR[1].equals("11110"));
		assertTrue("Constantes ok", cte.ConstR[2].equals("10001"));
		assertTrue("Constantes ok", cte.ConstR[3].equals("00100"));
	}

}
