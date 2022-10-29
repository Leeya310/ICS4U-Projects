
public class Romans {
	
	public static void main(String args[]) {
		
		//ArrayList<String> numerals = new ArrayList<String>();
		
		String[] romans = {"Q", "E", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] numerals = {10000, 5000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		
		int num = 48502;
		
		while (num > 0) {
			for (int i = 0; i < numerals.length; i++) {
				if (num >= numerals[i]) {
					System.out.print(romans[i]);
					num -= numerals[i];
					i = -1;
				}
			}
		}
	}
}
