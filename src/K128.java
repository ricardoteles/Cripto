
public class K128 {
	static String X;
	static String Y;
	static String A,B,C,D;
	
	public String k128(String bloco){
		X = bloco;	
		
		for (int i = 0; i < 12; i++) {
			X = umaIteracao(i);
		}
		return X;		// CIPHER TEXT
	}
	
	public String umaIteracao(int i){
		long a,b,c,d;	
		long km32;
		int kr5;
			
		a = Long.parseLong(BaseNumerica.binToDecLong(X.substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(X.substring(32, 64)));
    	c = Long.parseLong(BaseNumerica.binToDecLong(X.substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(X.substring(96, 128)));
	    					
    	// calcula C
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][0]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][0]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(d, kr5, km32)));
    	
    	// calcula B
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][1]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][1]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f1(c, kr5, km32)));
    	
    	// calcula A
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][2]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][2]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f3(b, kr5, km32)));
    	
    	// calcula D
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][3]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][3]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(a, kr5, km32)));
     	
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	
    	X = C+B+A+D;
    	
    	return X;
	}
	
	public String k128Inv(String bloco){
		Y = bloco;
			
		for (int i = 11; i >= 0; i--) {
			Y = umaIteracaoInv(i);
		}
		return Y;	//PLAIN TEXT
	}
	
	public String umaIteracaoInv(int i){
		long a,b,c,d;	
		long km32;
		int kr5;
		
		c = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(32, 64)));
    	a = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(96, 128)));
	
    	// calcula D
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][3]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][3]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(a, kr5, km32)));
    	
    	// calcula A
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][2]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][2]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f3(b, kr5, km32)));
    	
    	// calcula B
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][1]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][1]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f1(c, kr5, km32)));
    	
    	// calcula C
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(Chaves.KR5[i][0]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(Chaves.KM32[i][0]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(Funcoes.f2(d, kr5, km32)));
    	    	
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	   	
    	Y = A+B+C+D;
    	    	
    	return Y;
	}
}
