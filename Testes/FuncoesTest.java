import org.junit.Test;

public class FuncoesTest {

	@Test
	public void testF1() {
		String f= Funcoes.f3(Long.valueOf("11001001011001110001011110000111", 2), 
				 Integer.valueOf("11010", 2), 
				 Long.valueOf("01001111011001010101011110100111",2));
		
		System.out.println("f1(x) = "+BaseNumerica.binToDecLong(f));
	}

//	@Test
	public void testF2() {
		System.out.println("f2(x) = "+Funcoes.f2(3378976647L, 26, 1332041639L));
	}

//	@Test
	public void testF3() {
		System.out.println("f3(x) = "+Funcoes.f3(3378976647L, 26, 1332041639L));
	}

}
