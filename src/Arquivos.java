import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class Arquivos {
  
    public static void CBC() throws IOException{
        byte[] fileBytes = readFile(Ep.arqEntrada);
        Path filePath = Paths.get(Ep.arqSaida);
        K128 k = new K128();
        String X = "";
                
        for (int i = 0; i < fileBytes.length; i++) {
        	X += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

        	if (i % 16 == 15){
            	System.out.println(X.length());
            	if(X.length() == 128) {
            		writeFile(k.k128(X), filePath);
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
                
        for (int i = 0; i < fileBytes.length; i++) {
        	X += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

        	if (i % 16 == 15){
            	if(X.length() == 128) {					// TODO: tamanho do bloco < 128
            		writeFile(k.k128Inv(X), filePath);
            	}
            	X = "";
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