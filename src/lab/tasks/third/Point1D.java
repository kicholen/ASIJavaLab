package lab.tasks.third;


public class Point1D {
	public final static float FLOAT_OFFSET = 10.0f;
	
	private float _x;
	
	public Point1D(float x) {
		_x = x;
	}
	
	public Point1D() {
		_x = getRandomFloat(-FLOAT_OFFSET, FLOAT_OFFSET);
	}
	
	public float getX() {
		return _x;
	}
	
	public String getFormattedString() {
		return " ( " + _x + " ) ";
	}
	
	protected float getRandomFloat(float min, float max) {
		return (float) (Math.random() < 0.5 ? ((1-Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min));
	}
	
	protected void display() {
		System.out.println(getFormattedString());
	}
	
}
