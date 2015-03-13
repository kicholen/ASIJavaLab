package lab.tasks.second;

public class Fraction {
	private double _nominator;
	private double _denominator;
	
	public Fraction(int nominator, int denominator) {
		setNominator(nominator);
		setDenominator(denominator);
	}
	
	public double getDenominator() {
		return _denominator;
	}
	
	public void setDenominator(double value) {
		try {
			tryToSetDenominator(value);
		} catch (DenominatorZeroException e) {
			e.printStackTrace();
		}
	}
	
	private void tryToSetDenominator(double value) throws DenominatorZeroException {
		if (value == 0.0) {
			throw new DenominatorZeroException("Denominator can't be zero.");
		}
		else {
			_denominator = value;
		}
	}
	
	public double getNominator() {
		return _nominator;
	}
	public void setNominator(double value) {
		_nominator = value;
	}
	
	@Override
	public String toString() {
		return "(" + _nominator + ", " + _denominator + ")";
	}
	
	
	@SuppressWarnings("serial")
	class DenominatorZeroException extends Exception {
		
		public DenominatorZeroException(String message) {
			super(message);
		}
		
	}
}

