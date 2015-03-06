package lab.sort;

public class QuickSort implements ISort {

	public void sort(int[] table) {
		int left = 0;
		int right = table.length - 1;
		
		quickSort(table, left, right);
	}
	
	private void quickSort(int[] table, int left, int right) {
		if (left < right) {
			int i = divideTable(table, left, right);
			quickSort(table, left, i - 1);
			quickSort(table, i + 1, right);
		}
	}
	
	private int divideTable(int[] table, int left, int right) {
		int divideIndex = chooseDividePoint(left, right);
		int elementValue = table[divideIndex];
		swap(table, divideIndex, right);
		
		int currentPosition = left;
		for (int i = left; i <= right -1; i++) {
			if (table[i] < elementValue) {
				swap(table, i, currentPosition);
				currentPosition += 1;
			}
		}
		swap(table, currentPosition, right);
		
		return currentPosition;
	}
	
	private int chooseDividePoint(int left, int right) {
		return (left + right) / 2;
	}
	
	private void swap(int[] table, int firstIndex, int secondIndex) {
		int buffer = table[firstIndex];
		table[firstIndex] = table[secondIndex];
		table[secondIndex] = buffer;
	}
}
