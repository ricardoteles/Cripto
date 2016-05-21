
public class Chaves {
	static String Ki[] = new String[12];
	static String A,B,C,D;
	static String KR5[][] = new String[12][4];
	static String KM32[][] = new String[12][4];
	
	public static void geraSubChaves(String senha) {
		chaveInicial(senha);
			
		for(int i = 0; i <= 11; i++){
			geraChaveIntermediaria(i);

			KR5[i][0] = Ki[i].substring(27, 32);			
			KR5[i][1] = Ki[i].substring(59, 64);
			KR5[i][2] = Ki[i].substring(91, 96);
			KR5[i][3] = Ki[i].substring(123, 128);
											
			KM32[i][0] = Ki[i].substring(96, 128);
			KM32[i][1] = Ki[i].substring(64, 96);
			KM32[i][2] = Ki[i].substring(32, 64);
			KM32[i][3] = Ki[i].substring(0, 32);
		}			
	}
	
	private static void chaveInicial(String senha) {
    	Constantes.geraConstantes();
		String K = CBC.charBinario(senha);
					
		String cte = Operacoes.completaZerosEsquerda((BaseNumerica.hexToBinLong("5A827999")),128);		
		
		Ki[0] = Operacoes.xor128(K, cte);
	}
	
	private static void geraChaveIntermediaria(int i) { 
		long a,b,c,d;
		
		long constM;
		int constR;
		
		a = Long.parseLong(BaseNumerica.binToDecLong(Ki[i].substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(Ki[i].substring(32, 64)));
    	c = Long.parseLong(BaseNumerica.binToDecLong(Ki[i].substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(Ki[i].substring(96, 128)));
	    	    	
    	// calcula D
    	constR = Integer.parseInt(BaseNumerica.binToDec(Constantes.ConstR[i][0]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(Constantes.ConstM[i][0]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(a, constR, constM)));
    	
    	// calcula C
    	constR = Integer.parseInt(BaseNumerica.binToDec(Constantes.ConstR[i][1]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(Constantes.ConstM[i][1]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f1(d, constR, constM)));
    	
    	// calcula B
    	constR = Integer.parseInt(BaseNumerica.binToDec(Constantes.ConstR[i][2]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(Constantes.ConstM[i][2]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f3(c, constR, constM)));
    	
    	// calcula A
    	constR = Integer.parseInt(BaseNumerica.binToDec(Constantes.ConstR[i][3]));
    	constM = Long.parseLong(BaseNumerica.binToDecLong(Constantes.ConstM[i][3]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(b, constR, constM)));
    
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	
    	if(i < 11) Ki[i+1] = D+C+B+A;
	}
}
