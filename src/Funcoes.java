public class Funcoes {
	static long s1_i1, s2_i2, s3_i3, s4_i4; 
	
    // calcula o I e acha os valores nas S-boxes usadas pelas funcoes f1, f2 e f3
    static private void achaI (long X, int KR5, long KM32) {
    	String I1, I2, I3, I4;
    	
    	// calcular I
    	String s = Long.toString(KM32^X);
    	s = BaseNumerica.decToBinLong(s);
    	s = Operacoes.completaZerosEsquerda(s, 32);
    	String I = Operacoes.rotateLeft(s, KR5);
    	
    	//dividir I
    	I1 = I.substring(0, 8);
    	I2 = I.substring(8, 16);
    	I3 = I.substring(16, 24);
    	I4 = I.substring(24, 32);
    	     
    	int i1 = Integer.parseInt(BaseNumerica.binToDec(I1));
    	int i2 = Integer.parseInt(BaseNumerica.binToDec(I2));
    	int i3 = Integer.parseInt(BaseNumerica.binToDec(I3));
    	int i4 = Integer.parseInt(BaseNumerica.binToDec(I4));
    	
    	// achar s1_i1, s2_i2, s3_i3 e s4_i4 
    	s1_i1 = Long.parseLong(BaseNumerica.hexToDecLong(Sboxes.S1[i1]));
    	s2_i2 = Long.parseLong(BaseNumerica.hexToDecLong(Sboxes.S2[i2]));
    	s3_i3 = Long.parseLong(BaseNumerica.hexToDecLong(Sboxes.S3[i3]));
    	s4_i4 = Long.parseLong(BaseNumerica.hexToDecLong(Sboxes.S4[i4]));
    }
    
    static public String f1(long X, int KR5, long KM32) {
    	achaI(X, KR5, KM32);
    	
    	// calcular Y
    	long Y = Operacoes.somaMod32(s1_i1, s2_i2);
    	Y = Operacoes.subtracaoMod32(Y, s3_i3);
    	Y = Y^s4_i4;
    	
    	return Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(Y)),32);
    }

    static public String f2(long X, int KR5, long KM32) {
		achaI(X, KR5, KM32);
    	
		// calcular Y
		long Y = Operacoes.subtracaoMod32(s1_i1, s2_i2);
    	Y = Y^s3_i3;
    	Y = Operacoes.somaMod32(Y, s4_i4);
    	
    	return Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(Y)),32);
    }
	
    static public String f3(long X, int KR5, long KM32) {	
		achaI(X, KR5, KM32);
    	
		// calcular Y
		long Y = s1_i1^s2_i2;
    	Y = Operacoes.somaMod32(Y, s3_i3);
    	Y = Operacoes.subtracaoMod32(Y, s4_i4);
    	    	
    	return Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong(Long.toString(Y)),32);
	}
}
