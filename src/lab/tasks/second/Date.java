package lab.tasks.second;

public class Date {
	private int _day;
	private int _month;
	private int _year;
	
	public Date() {
		
	}
	
	public Date(int day, int month, int year) {
		_day = day;
		_month = month;
		_year = year;
	}
	
	/**
	 * Display format format DD-MM-YYY 
	 */
	public void display() {
		System.out.println(getDay() + "-" + getMonth() + "-" + getYear());
	}
	
	public int getDay() {
		return _day;
	}
	
	public void setDay(int value) {
		_day = value;
	}
	
	public int getMonth() {
		return _month;
	}
	
	public void setMonth(int value) {
		_month = value;
	}
	
	public int getYear() {
		return _year;
	}
	
	public void setYear(int value) {
		_year = value;
	}
	
}
