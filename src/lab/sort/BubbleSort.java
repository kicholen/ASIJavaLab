package lab.sort;

public class BubbleSort implements ISort {
	
	public void sort(int[] table) {
		int n = table.length;
		do {
			for (int i = 0; i < n - 1; i++) {
				if (table[i] > table[i + 1]) {
					int buffer = table[i];
					table[i] = table[i + 1];
					table[i + 1] = buffer;
				}
			}
			n = n - 1;
		} while(n > 1);
	}
	
}
