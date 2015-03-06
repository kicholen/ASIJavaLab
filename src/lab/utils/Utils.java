package lab.utils;

public class Utils {
	private static final int SHIFTING_METHOD_THRESHOLD = 5;
	
	public static int getFibonacci(int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		else {
			return number = getFibonacci(number - 1) + getFibonacci(number - 2);
		}
	}
	
	public static void moveArrayElementsToRightBy(int[] table, int shift) {
		if (shift > SHIFTING_METHOD_THRESHOLD) {
			table = shiftRightByCopying(table, shift);
		}
		else {
			for (int i = 0; i < shift; i++) {
				shiftRightByOne(table);
			}			
		}
	}
	
	public static void moveArrayElementsToLeftBy(int[] table, int shift) {
		if (shift > SHIFTING_METHOD_THRESHOLD) {
			table = shiftLeftByCopying(table, shift);
		}
		else {
			for (int i = 0; i < shift; i++) {
				shiftLeftByOne(table);
			}		
		}
	}
	
	private static int[] shiftRightByCopying(int[] table, int shift) {
	    int[] shiftedArray = new int[table.length];
	    
	    System.arraycopy(table, table.length - shift, shiftedArray, 0, shift);
	    System.arraycopy(table, 0, shiftedArray, shift, table.length - shift);
	    
	    return shiftedArray;
	}
	
	private static void shiftRightByOne(int[] table) {
        int lastElement = table[table.length - 1];
        
        for (int index = table.length - 2; index >= 0 ; index--) {
        	table[index + 1] = table[index];
        }
        
        table[0] = lastElement;
	}
	
	private static int[] shiftLeftByCopying(int[] table, int shift) {
	    int[] shiftedArray = new int[table.length];
	    System.arraycopy(table, shift, shiftedArray, 0, table.length - shift);
	    System.arraycopy(table, 0, shiftedArray, table.length - shift, shift);
	    
	    return shiftedArray;
	}
	
	private static void shiftLeftByOne(int[] table) {
		int firstElement = table[0];
		
		for (int index = 0; index < table.length - 1; index++) {
			table[index] = table[index + 1];
		}
		
		table[table.length - 1] = firstElement;
	}
}
