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
	
	public static void main(String[] args) {
//		parser(args);
		
		K128 k = new K128();
		
		k.k128("011010101000010000010110101010000100000101101010100001000001011010101000010000010110101010000"+
				"10000010110101010000100000100000110");
	}	
}