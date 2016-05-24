import java.io.IOException;

public class Ep {
	static String modo;
	static String arqEntrada;
	static String arqSaida;
	static String senha;
	
	public static void main(String[] args) throws IOException {
		parser(args[0], args[2], args[4], args[6]);
								
		Chaves.geraSubChaves(senha);
		
		if(Ep.modo.equals("-c"))
			Arquivos.CBC();
		else if(Ep.modo.equals("-d"))
			Arquivos.CBCInv();	
	}	
	
	public static void parser(String modo, String arqEntrada, String arqSaida, String senha){
		Ep.modo = modo;
		Ep.arqEntrada = arqEntrada;
		Ep.arqSaida = arqSaida;
		Ep.senha = montaSenha(senha);
		
//		System.out.println(Ep.modo); // modo
//		System.out.println(Ep.arqEntrada); // arq entrada
//		System.out.println(Ep.arqSaida); // arq saida
//		System.out.println(Ep.senha); // senha
	}
	
	public static String montaSenha(String senha){
		int i = 0;
		
		while(senha.length() < 16){
			senha += senha.charAt(i);
			i++;
		}

		return senha;
	}
}