public class BaseNumerica {		
	// converte numero decimal em binario
	static String decToBin (String dec) {
		int v = Integer.parseInt(dec);
		String bin = Integer.toString(v, 2);
		return bin;
	}

	// converte numero decimal em binario longo
	static String decToBinLong (String dec) {
		long v = Long.parseLong(dec);
		String bin = Long.toString(v, 2);
		return bin;
	}

	// converte numero binario em decimal
	static String binToDec (String binary) {
		int v = Integer.parseInt(binary, 2);
		String dec = Integer.toString(v, 10);
		return dec;
	}

	// converte numero binario em decimal longo
	static String binToDecLong (String binary) {
		long v = Long.parseLong(binary, 2);
		String dec = Long.toString(v, 10);
		return dec;
	}
	
	// converte numero hexadecimal em binario longo
	static String hexToBinLong (String hexadec) {
		long v = Long.parseLong(hexadec, 16);
		String bin = Long.toString(v, 2);
		return bin;
	}	
	
	// converte numero hexadecimal em decimal longo
	static String hexToDecLong (String hexadec) {
		long v = Long.parseLong(hexadec, 16);
		String dec = Long.toString(v, 10);
		return dec;
	}
}