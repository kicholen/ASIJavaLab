
public class Main {

	public static void main(String[] args) {
		Date data = new Date(20, 10, 1999);
		
		data.display();
		
		FractionStack stack = new FractionStack();
		
		for (int i = 0; i < 50; i++) {
			stack.push(new Fraction(i, i + 1));
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getDenominator());
		}
	}

}
