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
		String num;
		
		dist %= s.length();
		
		num = s.substring(0, dist);
		num = s.substring(dist, s.length()) + num;
		
		return num;
	}
     
    static long somaMod32(long a, long b){
    	return (long) ((a+b)%Math.pow(2, 32));
    }
    
    static long subtracaoMod32(long a, long b){
    	long x = (long) ((a-b)%Math.pow(2, 32));
    	
    	if(x < 0) 
    		x += Math.pow(2, 32);
    	
    	return x;
    }
    
    static String xor128(String a, String b){
    	String result = "";
    	
    	for(int i = 0; i < a.length(); i++){
    		if(a.charAt(i) == b.charAt(i)){
    			result = result+"0";
    		}
    		else{
    			result = result+"1";
    		}
    	}
 
    	return result;
    }
}
