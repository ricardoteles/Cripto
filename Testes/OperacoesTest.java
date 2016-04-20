import static org.junit.Assert.*;

import org.junit.Test;


public class OperacoesTest {

	@Test
	public void testCompletaZerosEsquerda() {
		String a = "1010";
		
		assertTrue("ok", Operacoes.completaZerosEsquerda(a, 10).equals("000000"+"1010"));
	}

	@Test
	public void testRotateLeft() {
		String a = "101000";
		
		assertTrue("ok", Operacoes.rotateLeft(a, 3).equals("000101"));
	}

	@Test
	public void testSomaMod32() {
		long a = (long)Math.pow(2, 32);
		
		assertTrue("1) Soma mod32 ok", Operacoes.somaMod32(a, 4) == 4);
		assertTrue("2) Soma mod32 ok", Operacoes.somaMod32(a, a) == 0);
		assertTrue("3) Soma mod32 ok", Operacoes.somaMod32(a, 5) == 5);
	}

	@Test
	public void testSubtracaoMod32() {
		long a = (long)Math.pow(2, 32);
		
		assertTrue("1) Sub mod32 ok", Operacoes.subtracaoMod32(6, 4) == 2);
		assertTrue("2) Sub mod32 ok", Operacoes.subtracaoMod32(8, 8) == 0);
		assertTrue("3) Sub mod32 ok", Operacoes.subtracaoMod32(a, a-1) == 1);
	}

	@Test
	public void testXor128() {
		assertTrue("xor ok", Operacoes.xor128("00000", "11111").equals("11111"));
		assertTrue("xor ok", Operacoes.xor128("11111", "11111").equals("00000"));
		assertTrue("xor ok", Operacoes.xor128("10100", "11111").equals("01011"));
	}

}
