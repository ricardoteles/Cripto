
public class BaseNumerica {		
	// funcao que transforma numero decimal em binario
		static String decToBin (String dec) {
			int v = Integer.parseInt(dec);
			String bin = Integer.toString(v, 2);
			return bin;
		}
	
	// funcao que transforma numero binario em long
	static String decToBinLong (String dec) {
		long v = Long.parseLong(dec);
		String bin = Long.toString(v, 2);
		return bin;
	}
	
	static long hexToDecLong (String hexadec) {
		return Long.parseLong(hexadec, 16);
	}
	
	static String binToDec (String binary) {
		int v = Integer.parseInt(binary, 2);
		String dec = Integer.toString(v, 10);
		return dec;
	}
}