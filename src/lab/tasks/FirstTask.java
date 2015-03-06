package lab.tasks;

import java.util.Arrays;

import lab.sort.BubbleSort;
import lab.sort.QuickSort;
import lab.utils.Utils;

public class FirstTask implements ITask {

	@Override
	public void doTask() {
		String isGood = checkIfProperCalculating() ? "good" : "bad";
		System.out.println(isGood);
		
		doMainTask();
	}
	
	private void doMainTask() {
		int[] table = new int[10];
		
		for (int i = 1; i <= 10; i++) {
			table[i - 1] = Utils.getFibonacci(i);
		}
		System.out.println("Fibonacci: " + Arrays.toString(table));
		
		Utils.moveArrayElementsToRightBy(table, 2);
		System.out.println("Fibonacci moved to right by 2: " + Arrays.toString(table));
		
		BubbleSort bSort = new BubbleSort();
		bSort.sort(table);
		System.out.println("Fibonacci bubble sorted: " + Arrays.toString(table));
		
		Utils.moveArrayElementsToLeftBy(table, 2);
		System.out.println("Fibonacci sorted, moved to left by 2: " + Arrays.toString(table));
		
		QuickSort qSort = new QuickSort();
		qSort.sort(table);
		System.out.println("Fibonacci quick sorted: " + Arrays.toString(table));
	}
	
	private Boolean checkIfProperCalculating() {
		for (int i = 100; i > 0; i--) {
			int x = (int)Math.ceil(Math.random()) * 100;
			if (calculateSth(x) != calculateSthHardWay(x)) {
				return false;
			}
		}
		return true;
	}
	
	private Boolean calculateSth(int x) {
		return (x >= 30 && x < 40) || (60 > x && x >= 50) || (80 > x && x >= 70);
	}
	
	private Boolean calculateSthHardWay(int x) {
		if (x >= 30) {
			if (x < 40) {
				return true;
			}
			else if (x >= 50) {
				if (x < 60) {
					return true;
				}
				else if (x >= 70) {
					if (x < 80) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
}
