
public class K128 {
	static String X;
	static String Y;
	static String A,B,C,D;
	String KR5[] = new String[Constantes.maxJ];
	String KM32[] = new String[Constantes.maxJ];
	
	public void k128(String bloco){
		X = bloco;
			
		for (int i = 0; i < 1; i++) {
			X = umaIteracao();
		}
		System.out.println("res = "+X);
	}
	
	public String umaIteracao(){
		long a,b,c,d;	
		long km32;
		int kr5;
		
		a = Long.parseLong(BaseNumerica.binToDecLong(X.substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(X.substring(32, 64)));
    	c = Long.parseLong(BaseNumerica.binToDecLong(X.substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(X.substring(96, 128)));
	
    	String senha = "ricardoOliveiraT";
		Chaves ch = new Chaves(senha);
		
		ch.geraSubChaves();
    	Funcoes f = new Funcoes();
    	
    	// calcula C
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[0]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[0]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(d, kr5, km32)));
    	
    	// calcula B
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[1]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[1]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(f.f1(c, kr5, km32)));
    	
    	// calcula A
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[2]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[2]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(f.f3(b, kr5, km32)));
    	
    	// calcula D
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[3]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[3]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(a, kr5, km32)));
     	
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	   	
    	X = C+B+A+D;
    	
    	return X;
	}
	
	public void k128Inv(String bloco){
		Y = bloco;
			
		for (int i = 11; i >= 0; i--) {
			Y = umaIteracao();
		}
		System.out.println("res = "+Y);
	}
	
	public String umaIteracaoInv(){
		long a,b,c,d;	
		long km32;
		int kr5;
		
		c = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(0, 32)));
    	b = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(32, 64)));
    	a = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(64, 96)));
    	d = Long.parseLong(BaseNumerica.binToDecLong(Y.substring(96, 128)));
	
    	String senha = "ricardoOliveiraT";
		Chaves ch = new Chaves(senha);
		
		ch.geraSubChaves();
    	Funcoes f = new Funcoes();
    	
    	// calcula D
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[3]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[3]));
    	d = d ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(a, kr5, km32)));
    	
    	// calcula C
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[0]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[0]));
    	c = c ^ Long.parseLong(BaseNumerica.binToDecLong(f.f2(d, kr5, km32)));
    	
    	// calcula B
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[1]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[1]));
    	b = b ^ Long.parseLong(BaseNumerica.binToDecLong(f.f1(c, kr5, km32)));
    	
    	// calcula A
    	kr5 = Integer.parseInt(BaseNumerica.binToDec(ch.KR5[2]));
    	km32 = Long.parseLong(BaseNumerica.binToDecLong(ch.KM32[2]));
    	a = a ^ Long.parseLong(BaseNumerica.binToDecLong(f.f3(b, kr5, km32)));
    	
    	
    	A = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(a)), 32);
    	B = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(b)), 32);
    	C = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(c)), 32);
    	D = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(d)), 32);
    	   	
    	Y = A+B+C+D;
    	
    	return Y;
	}
}
