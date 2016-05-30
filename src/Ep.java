import java.io.IOException;

public class Ep {
	static String modo;
	static String arqEntrada;
	static String arqSaida;
	static String senha;
	static String opcaoA = "";
	
	public static void main(String[] args) throws IOException {
		Ep.modo = args[0];
		Ep.arqEntrada = args[2];
		
		if(args.length == 8 && Ep.modo.equals("-c")){			// Modo (1) com o parâmetro -a
			Ep.arqSaida = args[4];
			Ep.senha = montaSenha(args[6]);
			Arquivos.geraArqSaida(Ep.arqSaida, "".getBytes());	// cria o arquivo, caso nao exista
			Ep.opcaoA = "-a";
			
			Arquivos.CBC();
		}
		else if(args.length == 7){	
			Ep.arqSaida = args[4];
			Ep.senha = montaSenha(args[6]);
			Arquivos.geraArqSaida(Ep.arqSaida, "".getBytes());
			
			if(Ep.modo.equals("-c")) Arquivos.CBC();			// Modo (1) sem o parâmetro -a
			
			else if(Ep.modo.equals("-d")) Arquivos.CBCInv();	// Modo (2)
		}
		else if(args.length == 5){
			Ep.senha = montaSenha(args[4]);
			
			if(Ep.modo.equals("-1"))							// Modo (3)
				System.out.println("Não foi implementada a aleatoridade pelo metodo 1!\n");

			else if(Ep.modo.equals("-2"))						// Modo (4)
				System.out.println("Não foi implementada a aleatoridade pelo metodo 2!\n");
		}
		else {
			System.out.println("Modo desconhecido. Por favor digitar um dos seguintes modos:\n");
			System.out.println("Modo (1) Criptografar arquivos:");
			System.out.println("    java Ep -c -i <arquivo de entrada> -o <arquivo de saida> -p <senha> -a\n");
			System.out.println("Modo (2) Decriptografar arquivos:");
			System.out.println("    java Ep -d -i <arquivo de entrada> -o <arquivo de saida> -p <senha>\n");
			System.out.println("Modo (3) Calcular aleatoriedade pelo método 1:	[NÃO IMPLEMENTADO!]");
			System.out.println("    java Ep -1 -i <arquivo de entrada> -p <senha>\n");
			System.out.println("Modo (4) Calcular aleatoriedade pelo método 2:	[NÃO IMPLEMENTADO!]");
			System.out.println("    java Ep -2 -i <arquivo de entrada> -p <senha>\n");
		}
	}
	
	// trata a senha para que ela tenha tamanho igual a 16 (concatenando ou truncando)
	public static String montaSenha(String senha){
		int letras = 0;
		int algarismos = 0;
		int i = 0;
		
		// verifica se a senha possui pelo menos 8 caracteres
		if(senha.length() < 8){
			System.out.println("A <senha> deve conter pelo menos 8 caracteres!");
			System.exit(-1);
		}
		
		// trunca senha se for maior que 16
		else if(senha.length() > 16) senha = senha.substring(0, 16);
		
		// verifica se a senha possui pelo menos 2 letras e 2 algarismos decimais
		for (int j = 0; j < senha.length(); j++) {
			if(senha.charAt(j) >= 48 && senha.charAt(j) <= 57) 
				algarismos++;
			else if((senha.charAt(j) >= 65 && senha.charAt(j) <= 90) ||
					(senha.charAt(j) >= 97 && senha.charAt(j) <= 122)) letras++;
		}
		
		if(letras < 2 || algarismos < 2){
			System.out.println("A <senha> deve conter pelo menos 2 letras e 2 algarismos decimais!");
			System.out.println("\nSua senha contem\nLetras: "+letras+"\t"+"Algarismos: "+algarismos);
			System.exit(-1);
		}
	
		// caso a senha seja maior que 7 e menor que 16, concatena ate 16
		while(senha.length() < 16){
			senha += senha.charAt(i);
			i++;
		}
	
		return senha;
	}
}