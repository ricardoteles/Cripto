import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.IOException;

public class Arquivos {
	static String VI = "11111111111111111111111111111111111111111111111111111111111111111111111111111111"+
				"111111111111111111111111111111111111111111111111";
	
    public static void CBC() throws IOException{
        byte[] fileBytes = readFile(Ep.arqEntrada);
        Path filePath = Paths.get(Ep.arqSaida);
        int tamArqBytes = 0;
        K128 k = new K128();
        String X = "";
        String Y = "";
        Chaves.geraSubChaves(Ep.senha);
        
        for (int i = 0; i < fileBytes.length; i++) {
            // converte um byte em uma string binaria de 8 bits e concatena-a 16 vezes 
            X += String.format("%8s", Integer.toBinaryString(fileBytes[i] & 0xFF)).replace(' ', '0');

            if (i % 16 == 15){
                if(i == 15){                                 // primeira iteracao do CBC
                    Y = k.k128(Operacoes.xor128(X, VI));
                }
                else{
                    Y = k.k128(Operacoes.xor128(X, Y));      // demais iteracoes do CBC
                }
                writeFile(Y, filePath, StandardOpenOption.APPEND);

                tamArqBytes += 16;
                X = "";
            }            
        }
          
        if(X.length() != 128 && X !=""){
        	tamArqBytes += X.length()/8;
        	X = completaUltimoBloco(X);
        	X +=Operacoes.completaZerosEsquerda((BaseNumerica.decToBin(tamArqBytes+"")), 32);
        	Y = k.k128(Operacoes.xor128(X, Y));
        	writeFile(Y, filePath, StandardOpenOption.APPEND);
        }
        
        if(Ep.opcaoA.equalsIgnoreCase("-a")){
        	gravaBranco(Ep.arqEntrada, fileBytes.length);
        }
    }

    public static String completaUltimoBloco(String X){
    	while(X.length() < 96){
    		X += "1"; 
    	}
    	return X;
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
        		if(i == 15){
        			X = Operacoes.xor128(k.k128Inv(Y), VI);
        		}
        		else{
        			X = Operacoes.xor128(k.k128Inv(Y), Yant);
        		}
        		writeFile(X, filePath, StandardOpenOption.APPEND);

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
	
	// gera um arquivo de saida caso ele nao exista
	public static void geraArqSaida(String fileName, byte[] fileBytes) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, fileBytes);
    }
	
	// se eh passada a opcao -a, grava espacos em branco no arquivo e o deleta 
	public static void gravaBranco (String fileName, int fileBytes) throws IOException {
        Path filePath = Paths.get(fileName);
        byte[] esp = new byte[1];
        esp[0] = ' ';
        
        Files.write(filePath, esp);
        
        for (int i = 1; i < fileBytes; i++) {
        	Files.write(filePath, esp, StandardOpenOption.APPEND);
		}
        
        File f = new File("./"+Ep.arqEntrada);
     	f.delete();
    }
		
}  