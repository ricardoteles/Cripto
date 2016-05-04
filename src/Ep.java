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
		
		Chaves.geraSubChaves("aaaaaabbbb1qazxs");	//senha
		K128 k = new K128();
		
		k.k128("01100001011000100110001101100100011001010110011001100111011010000110000101100010011000110110010001100101011001100110011101101000");
	
		k.k128Inv("01101110101010011011111100000110010110010010100001000000000000110001101011000001010101001100100010011000001001110001001101010000");
	}	
}