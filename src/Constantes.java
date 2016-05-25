public class Constantes {
	static int CR = 11, MR = 19;
	static long CM = Long.parseLong("5A827999", 16), MM = Long.parseLong("6ED9EBA1",16);
	static String ConstM[][] = new String[12][4];
	static String ConstR[][] = new String[12][4];
	
	// gera as constantes ConstR e ConstM
    public static void geraConstantes() {
    	for (int i = 0; i < 12; i++){
	    	for (int j = 0; j < 4; j++) {
	    		ConstM[i][j] = Operacoes.completaZerosEsquerda(BaseNumerica.decToBinLong((""+CM)), 32);	
	    		CM =  (long) ((CM+MM)%Math.pow(2, 32));
	    		ConstR[i][j] = Operacoes.completaZerosEsquerda(BaseNumerica.decToBin((""+CR)), 5);
	   			CR = (int) ((CR+MR)%Math.pow(2, 5));
		    }
    	}
    }
}