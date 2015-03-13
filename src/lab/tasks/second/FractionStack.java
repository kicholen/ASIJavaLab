package lab.tasks.second;

import java.util.Arrays;

public class FractionStack {
	Fraction[] _stack;
	
	public FractionStack() {
		
	}
	
	public void push(Fraction fraction) {
		Fraction[] newTable = new Fraction[size() + 1];
		if (_stack != null) {
			System.arraycopy(_stack, 0, newTable, 0, size());
			_stack = null;
			_stack = newTable;
		}
		else {
			_stack = newTable;
		}
		
		_stack[size() - 1] = fraction;
	}
	
	public Fraction pop() {
		if (isEmpty()) {
			return null;
		}
		Fraction savedOne = _stack[size() - 1];
		Fraction[] newTable = new Fraction[size() - 1];
		System.arraycopy(_stack, 0, newTable, 0, size() - 1);
		_stack = null;
		_stack = newTable;
		
		return savedOne;
	}
	
	public Boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		if (_stack != null) {
			return _stack.length;
		}
		else {
			return 0;
		}
	}
	
	public Fraction get() {
		if (isEmpty()) {
			return null;
		}
		return _stack[size() - 1];
	}
	
	public void display() {
		if (_stack != null) {
			System.out.println(Arrays.toString(_stack));
		}
		else {
			System.out.println("[]");
		}
	}
}
