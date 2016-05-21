import java.io.IOException;

public class Ep {
	public static void parser(String[] args){
		String modo = args[0];
		String arqEntrada = args[2];
		String arqSaida = args[4];
		String senha = args[6];
		
		System.out.println(args.length);
		System.out.println(modo); // modo
		System.out.println(arqEntrada); // arq entrada
		System.out.println(arqSaida); // arq saida
		System.out.println(senha); // senha
	}
	
	public static void main(String[] args) throws IOException {
//		parser(args);
//		CBC.leituraEscritaArq("./bin/entrada.txt", "./bin/saida.txt");
		
		System.out.println("senhamalucasenha:\n");
		
		Chaves.geraSubChaves("senhamalucasenha");
		
		K128 k = new K128();
			
		String plain = "10001001100101101001001011011111110000011101111110011010100100101001111010011100100011001111010111111111111111111111111111110011";
		
		k.k128(plain);
		k.k128Inv("00110000001110001011010101111001110110110110000011010001010111000110010100110000001011000111101010001000011010110000011001101000");
		
	}	
}