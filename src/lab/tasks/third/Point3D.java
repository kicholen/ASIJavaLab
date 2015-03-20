package lab.tasks.third;


public class Point3D extends Point2D {
	private float _z;
	
	public Point3D(float x, float y, float z) {
		super(x, y);
		_z = z;
	}
	
	public Point3D() {
		super();
		_z = getRandomFloat(-FLOAT_OFFSET, FLOAT_OFFSET);
	}
	
	public float getZ() {
		return _z;
	}
	
	public String getFormattedString() {
		return " ( " + getX() + " , " + getY() + " , " + getZ() + " ) ";
	}
}
