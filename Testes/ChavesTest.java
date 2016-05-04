import org.junit.Test;

public class ChavesTest {

	@Test
	public void geraSubChavesTest(){
		Chaves.geraSubChaves("aaaaaabbbb1qazxs");
		
		System.out.println("Ki = " + Chaves.Ki);
	}
	
//	@Test
	public void imprimeMatrizChaves() {
		Constantes.geraConstantes();
		
		//funcao de teste
	    for (int i = 0; i < 12; i++){
    		for (int j = 0; j < 4; j++){
				System.out.print(BaseNumerica.binToDecLong(Chaves.KR5[i][j])+"    ");
			}
    		System.out.println("");
    	}
		System.out.println();		
	}
}
