
public class Chaves {
	static String Ki;
	static String A,B,C,D;
	String KR5[] = new String[Constantes.maxJ];
	String KM32[] = new String[Constantes.maxJ];
	
	Chaves(String senha){
		String K = geraK(senha);
		
		String cte = Operacoes.completaZerosEsquerda((BaseNumerica.hexToBinLong("5A827999")),128);		
		
		Ki = Operacoes.xor128(K, cte);
	}
	
	private String geraK (String senha){
		String bin, K = "";
		int caracter;
		
		for(int i = 0; i < 16; i++){
			caracter = senha.charAt(i);
			bin = Integer.toString(caracter, 2);
			bin = Operacoes.completaZerosEsquerda(bin, 8);
			K += bin;
		}
		
		return K;
	}
	
	private void geraChaveIntermediaria() { 
		long a,b,c,d;
		
		long constM;
		int constR;
		
		a = Long.parseLong(BaseNumerica.binToDecLong(Ki.substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(Ki.substring(32, 64)));
    	c = Long.parseLong(BaseNumerica.binToDecLong(Ki.substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(Ki.substring(96, 128)));
	
    	Funcoes f = new Funcoes();
    	Constantes cte = new Constantes();
    	cte.geraConstantes();
    	
    	// calcula D
    	constR = Integer.parseInt(BaseNumerica.binToDec(cte.ConstR[0]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(cte.ConstM[0]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(a, constR, constM)));
    	
    	// calcula C
    	constR = Integer.parseInt(BaseNumerica.binToDec(cte.ConstR[1]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(cte.ConstM[1]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(f.f1(d, constR, constM)));
    	
    	// calcula B
    	constR = Integer.parseInt(BaseNumerica.binToDec(cte.ConstR[2]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(cte.ConstM[2]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(f.f3(c, constR, constM)));
    	
    	// calcula A
    	constR = Integer.parseInt(BaseNumerica.binToDec(cte.ConstR[3]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(cte.ConstM[3]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(b, constR, constM)));
    
    	
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);

    	Ki = D+C+B+A;
	}
	
	public void geraSubChaves() {
		geraChaveIntermediaria();
		
		KR5[0] = A.substring(27, 32);
		KR5[1] = B.substring(27, 32);
		KR5[2] = C.substring(27, 32);
		KR5[3] = D.substring(27, 32);
		
		KM32[0] = D;
		KM32[1] = C;
		KM32[2] = B;
		KM32[3] = A;
	}
}
