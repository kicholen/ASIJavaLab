package lab.tasks.third;


public class Point2D extends Point1D {
	private float _y;
	
	public Point2D(float x, float y) {
		super(x);
		_y = y;
	}
	
	public Point2D() {
		super();
		_y = getRandomFloat(-FLOAT_OFFSET, FLOAT_OFFSET);
	}
	
	public float getY() {
		return _y;
	}
	
	@Override
	public String getFormattedString() {
		return "( " + getX() + " , " + _y + " ) ";
	}
}
