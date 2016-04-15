
public class Funcoes {
	
	long s1_i1, s2_i2, s3_i3, s4_i4; 
	
    Funcoes (long X, int KR5, long KM32) {   
    	String I1, I2, I3, I4;
    	String s = Long.toString(KM32^X);
//    	System.out.println("xor: "+s);
    	s = BaseNumerica.decToBin(s);
//    	System.out.println("binario: "+s);
    	s = Operacoes.completaZerosEsquerda(s, 32);
//    	System.out.println("32bits:\n"+s);
    	String I = Operacoes.rotateLeft(s, KR5);
//    	System.out.println("I(rotacionado "+KR5+" posicoes):\n"+I);
    	
    	I1 = I.substring(0, 8);
    	I2 = I.substring(8, 16);
    	I3 = I.substring(16, 24);
    	I4 = I.substring(24, 32);
    	
//    	System.out.println("I1: "+I1);
//    	System.out.println("I2: "+I2);
//    	System.out.println("I3: "+I3);
//    	System.out.println("I4: "+I4);
     
    	int i1 = Integer.parseInt(BaseNumerica.binToDec(I1));
    	int i2 = Integer.parseInt(BaseNumerica.binToDec(I2));
    	int i3 = Integer.parseInt(BaseNumerica.binToDec(I3));
    	int i4 = Integer.parseInt(BaseNumerica.binToDec(I4));
    	
    	this.s1_i1 = BaseNumerica.hexToDecLong(Sboxes.S1[i1]);
    	this.s2_i2 = BaseNumerica.hexToDecLong(Sboxes.S2[i2]);
    	this.s3_i3 = BaseNumerica.hexToDecLong(Sboxes.S3[i3]);
    	this.s4_i4 = BaseNumerica.hexToDecLong(Sboxes.S4[i4]);
    }
    
    // TODO: testar calculo do Y
    public void f1() {	
    	long Y = Operacoes.somaMod32(s1_i1, s2_i2);
    	Y = Operacoes.subtracaoMod32(Y, s3_i3);
    	Y = Y^s4_i4;
    	
    	System.out.println("Y = "+ Y);
    }

    // TODO: testar calculo do Y
	public void f2() {
    	long Y = Operacoes.subtracaoMod32(s1_i1, s2_i2);
    	Y = Y^s3_i3;
    	Y = Operacoes.somaMod32(Y, s4_i4);
    	
    	System.out.println("Y = "+ Y);
    }
	
    // TODO: testar calculo do Y
	public void f3() {	
    	long Y = s1_i1^s2_i2;
    	Y = Operacoes.somaMod32(Y, s3_i3);
    	Y = Operacoes.subtracaoMod32(Y, s4_i4);
    	    	
    	System.out.println("Y = "+ Y);
	}
}
