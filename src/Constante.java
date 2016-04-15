public class Constante {
	int maxJ = 4, maxI = 12; 
	static int iteracao = 0, CR = 11, MR = 19;
	static long CM = Integer.parseInt("5A827999", 16), MM = Integer.parseInt("6ED9EBA1",16);
	String ConstM[] = new String[maxJ];
	String ConstR[] = new String[maxJ];
	
	// gera as as constantes ConstR e ConstM no momento da execucao da i-esima iteracao
    public void geracaoConstantes() {   	
    	for (int j = 0; j < maxJ; j++) {
    		ConstM[j] = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong((""+CM)), 32);	
    		CM = (long) ((CM+MM)%Math.pow(2, 32));
    		ConstR[j] = Operacoes.completaZerosEsquerda(BaseNumerica.decToBin((""+CR)), 5);
   			CR = (int) ((CR+MR)%Math.pow(2, 5));
	    }
    	
    	iteracao++;	// variavel para testar qual eh a iteracao
    }

    //funcao de teste
    public void imprimeMAtriz() {
    	System.out.println("iteracao "+iteracao+": ");
		for (int j = 0; j < maxJ; j++)
			System.out.print(ConstM[j]+"    ");
		System.out.println();
    }
}