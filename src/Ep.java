import java.io.IOException;

public class Ep {
	static String modo;
	static String arqEntrada;
	static String arqSaida;
	static String senha;
	
	public static void main(String[] args) throws IOException {
		Ep.modo = args[0];
		Ep.arqEntrada = args[2];
		
		if(args.length == 8 && Ep.modo.equals("-c")){			// Modo (1) com o parâmetro -a
			Ep.arqSaida = args[4];
			Ep.senha = montaSenha(args[6]);

			System.out.println("Falta fazer o -a");				// TODO: opcao -a
		}
		else if(args.length == 7){	
			Ep.arqSaida = args[4];
			Ep.senha = montaSenha(args[6]);
		
			if(Ep.modo.equals("-c")) Arquivos.CBC();			// Modo (1) sem o parâmetro -a
			
			else if(Ep.modo.equals("-d")) Arquivos.CBCInv();	// Modo (2)
		}
		else if(args.length == 5){
			Ep.senha = montaSenha(args[4]);
			
			if(Ep.modo.equals("-1"))							// Modo (3)
				System.out.println("Fazer a aleatoridade pelo metodo 1");

			else if(Ep.modo.equals("-2"))						// Modo (4)
				System.out.println("Fazer a aleatoridade pelo metodo 2");
		}
		else {
			System.out.println("Modo desconhecido");
		}
		
	}
	
	// trata a senha para que ela tenha tamanho igual a 16 (concatenando ou truncando)
	public static String montaSenha(String senha){
		int i = 0;
		
		if(senha.length() > 16) senha = senha.substring(0, 16);

		while(senha.length() < 16){
			senha += senha.charAt(i);
			i++;
		}
	
		return senha;
	}
}