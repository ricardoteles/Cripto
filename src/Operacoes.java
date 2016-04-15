public class Operacoes {
	
	// funcao que coloca zero a esquerda para respeitar o num de bits
    static String completaZerosEsquerda(String num, int numBits){ 	
    	while(num.length() < numBits){
    		num = "0"+num; 
    	}
    	
    	return num;
    }
    
    // rotaciona para a esquerda dist posicoes
    static String rotateLeft(String s, int dist){
		String elem0, resto = s;
		
		for(int i = 0; i < dist; i++){
			elem0 = resto.substring(0, 1);
			resto = resto.substring(1) + elem0;
		}
		
		return resto;
	}
    
    static long subtracaoMod32(long a, long b){
    	return (long) ((a-b)%Math.pow(2, 32));
    }
    
    static long somaMod32(long a, long b){
    	return (long) ((a+b)%Math.pow(2, 32));
    }
}
