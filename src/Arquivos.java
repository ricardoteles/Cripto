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
        Chaves.geraSubChaves(Ep.senha);
        
        for (int i = 0; i < fileBytes.length; i++) {
            // converte um byte em uma string binaria de 8 bits e concatena-a 16 vezes 
            X += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

            if (i % 16 == 15){
                if(X.length() == 128) {                     //TODO: verificar se < 128 bits 
                    if(i == 15){                                 // primeira iteracao do CBC
                        Y = k.k128(Operacoes.xor128(X, VI));
                    }
                    else{
                        Y = k.k128(Operacoes.xor128(X, Y));      // demais iteracoes do CBC
                    }
                    writeFile(Y, filePath, StandardOpenOption.APPEND);
                }
                X = "";
            }            
        }        
    }

    // funcao inversa do CBC
    public static void CBCInv() throws IOException {
        byte[] fileBytes = readFile(Ep.arqEntrada);
        Path filePath = Paths.get(Ep.arqSaida);
        K128 k = new K128();
        String X = "";
        String Y = "";
        String Yant = "";
        Chaves.geraSubChaves(Ep.senha);
        
        for (int i = 0; i < fileBytes.length; i++) {
            // converte um byte em uma string binaria de 8 bits e concatena-a 16 vezes 
        	Y += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

        	if (i % 16 == 15){
        		if(Y.length() == 128) {
	        		if(i == 15){
	        			X = Operacoes.xor128(k.k128Inv(Y), VI);
	        		}
	        		else{
	        			X = Operacoes.xor128(k.k128Inv(Y), Yant);
	        		}
            		writeFile(X, filePath, StandardOpenOption.APPEND);
            	}
        		Yant = Y;
            	Y = "";
            }            
        }        
    }

    
	public static void writeFile(String b, Path filePath, StandardOpenOption opcao) throws IOException{
        byte[] fileBytes = new byte[16];
       
        for (int i = 0; i < fileBytes.length; i++) {
            String c = b.substring(8*i, 8*(i+1));
           
            fileBytes[i] = (byte) Integer.parseInt(c, 2);
        }
       
        Files.write(filePath, fileBytes, opcao);
    }
	
	public static byte[] readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllBytes(filePath);
    }
	
	public static void geraArqSaida(String fileName, byte[] fileBytes) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, fileBytes);
    }
		
}  