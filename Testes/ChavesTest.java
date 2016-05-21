import org.junit.Test;

public class ChavesTest {

//	@Test
	public void geraChaveIntermediariaTest(){
		long a,b,c,d;
		
		Chaves.geraSubChaves("senhamalucasenha");

		for(int i = 0; i <= 11; i++){			
			a = Long.parseLong(BaseNumerica.binToDecLong(Chaves.Ki[i].substring(0, 32)));
	    	b = Long.parseLong(BaseNumerica.binToDecLong(Chaves.Ki[i].substring(32, 64)));
	    	c = Long.parseLong(BaseNumerica.binToDecLong(Chaves.Ki[i].substring(64, 96)));
	    	d = Long.parseLong(BaseNumerica.binToDecLong(Chaves.Ki[i].substring(96, 128)));
			
			System.out.print("KEYS["+i+"]");
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+a));
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+b));
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+c));
	    	System.out.println("\t"+BaseNumerica.decToHexLong(""+d));
		}
	}
	
//	@Test
	public void geraSubChavesTest(){
		long a,b,c,d;
		
		Chaves.geraSubChaves("senhamalucasenha");

		for(int i = 0; i <= 11; i++){			
			a = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][0]));
	    	b = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][1]));
	    	c = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][2]));
	    	d = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][3]));
			
			System.out.print("KM32["+i+"] :");
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+a));
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+b));
	    	System.out.print("\t"+BaseNumerica.decToHexLong(""+c));
	    	System.out.println("\t"+BaseNumerica.decToHexLong(""+d));
		}
	}
	
}
