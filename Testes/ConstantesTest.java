import org.junit.Test;

public class ConstantesTest {

	@Test
	public void testGeraConstantes() {
		Constantes.geraConstantes();
		
		//funcao de teste
	    for (int i = 0; i < 12; i++){
    		for (int j = 0; j < 4; j++){
				System.out.print(BaseNumerica.decToHexLong(BaseNumerica.binToDecLong(Constantes.ConstM[i][j]))+"    ");
			}
    		System.out.println("");
    	}
		System.out.println();		
	}

}
