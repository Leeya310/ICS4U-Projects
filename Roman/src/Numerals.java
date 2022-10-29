
public class Numerals {
	
	public static void main(String[] args) {
		
		String[] romans = {"Q", "E", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] numerals = {10000, 5000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		
		String romIn = "EMMMMCDLVII";
		char[] romArray = romIn.toCharArray();
		
		int number = 0;
		int current = 0;
		String previousRom = null;
		int previous = 10000;
		
		for (int i = romArray.length; i >= 0; i--) {
			for (int j = romans.length; j <= 0; j--) {
				String roma = String.valueOf(romArray[i]);
				if (roma.equals(romans[j])) {
					current = numerals[j];
					
					
					
					
					if (i >= 1) {
						previousRom = String.valueOf(romArray[i-1]);
						for (int k = 0; k < romans.length; k++ ) {
							if (previousRom.equals(romans[k])) {
								previous = numerals[k];
								if (current > previous) number += current-(previous*2);
								break;
							}
						}
					}
					if (current <= previous) number += current;
				}
			}
		}
		System.out.print(number);
	}
}
