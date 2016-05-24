import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class Arquivos {
	static String VI = "11111111111111111111111111111111111111111111111111111111111111111111111111111111"+
				"111111111111111111111111111111111111111111111111";
	
    public static void CBC() throws IOException{
        byte[] fileBytes = readFile(Ep.arqEntrada);
        Path filePath = Paths.get(Ep.arqSaida);
        K128 k = new K128();
        String X = "";
        String Y = "";
        
        for (int i = 0; i < fileBytes.length; i++) {
        	X += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

        	if (i % 16 == 15){
        		if(X.length() == 128) {						//TODO: verificar se < 128 bits 
	        		if(i == 15){
	        			Y = k.k128(Operacoes.xor128(X, VI));
	        		}
	        		else{
	        			Y = k.k128(Operacoes.xor128(X, Y));
	        		}
            		writeFile(Y, filePath);
            	}
            	X = "";
            }            
        }        
    }

    public static void CBCInv() throws IOException{
        byte[] fileBytes = readFile(Ep.arqEntrada);
        Path filePath = Paths.get(Ep.arqSaida);
        K128 k = new K128();
        String X = "";
        String Y = "";
        String Yant = "";
        
        for (int i = 0; i < fileBytes.length; i++) {
        	Y += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

        	if (i % 16 == 15){
        		if(Y.length() == 128) {
	        		if(i == 15){
	        			X = Operacoes.xor128(k.k128Inv(Y), VI);
	        		}
	        		else{
	        			X = Operacoes.xor128(k.k128Inv(Y), Yant);
	        		}
            		writeFile(X, filePath);
            	}
        		Yant = Y;
            	Y = "";
            }            
        }        
    }

    
	public static void writeFile(String b, Path filePath) throws IOException{
        byte[] fileBytes = new byte[16];
       
        for (int i = 0; i < fileBytes.length; i++) {
            String c = b.substring(8*i, 8*(i+1));
           
            fileBytes[i] = (byte) Integer.parseInt(c, 2);
        }
       
        Files.write(filePath, fileBytes, StandardOpenOption.APPEND);
    }
	
	public static byte[] readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllBytes(filePath);
    }
}  