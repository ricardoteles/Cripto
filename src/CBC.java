import java.io.*;

public class CBC {
	static BufferedReader in;
	static BufferedWriter bw;
	
	public static String charBinario (String str){
		String bin, K = "";
		int caracter;
		
		for(int i = 0; i < str.length(); i++){
			caracter = str.charAt(i);
			bin = Integer.toString(caracter, 2);
			bin = Operacoes.completaZerosEsquerda(bin, 8);
			K += bin;
		}
		
		return K;
	}
	
    public static void leituraEscritaArq(String arqEntrada,String arqSaida) throws IOException{
    	try {
            in = new BufferedReader(new FileReader(arqEntrada));

            OutputStream os = new FileOutputStream(arqSaida);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            
            cbc();
            
            bw.close();
            in.close();
    	} 
        catch (IOException e){
            System.out.println(e.getMessage());
        }
     }
    
    public static void cbc() throws IOException {
    	char ch;
        String str = "";
        int i = in.read();
        
        // le 2 bytes por vez
        while (i != -1){
        	ch = (char) i;
        	str += ch;
        	
        	if(str.length() % 16 == 0){
//        		str = charBinario (str);
        		System.out.println(str);
        		bw.write(str+"\n");
        		str = "";
        	}

            i = in.read();
        }
        
        // le os ultimos bytes
        while(str.length() % 16 != 0){
        	str+="1";
        }
        
        if(str != ""){
//        	str = charBinario (str);
        	System.out.println(str);
        	bw.write(str+"\n");
        }
	}
}
