package lab.tasks;

import lab.tasks.second.Date;
import lab.tasks.second.Fraction;
import lab.tasks.second.FractionStack;

public class SecondTask implements ITask {

	@Override
	public void doTask() {
		Date data = new Date(20, 10, 1999);
		data.display();
		
		FractionStack stack = new FractionStack();
		
		for (int i = 0; i < 10; i++) {
			stack.display();
			stack.push(new Fraction(i, i + 1));
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
			stack.display();
		}
	}

}
