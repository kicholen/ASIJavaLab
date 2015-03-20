package lab.tasks.third;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import lab.utils.FileUtils;


public class ThirdTask {
	List<Point1D> _pointsList;
	private int _currentPositionX;
	private int _currentPositionY;
	private static List<Point> _list;
	private Point _lastPoint;
	
	public ThirdTask() {

	}
	
	public void doTask() {
		_list = new ArrayList<Point>();
		_pointsList = new ArrayList<Point1D>();
		
		_pointsList.add(new Point2D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point3D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point1D());
		_pointsList.add(new Point3D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point2D());
		_pointsList.add(new Point3D());
		
		FileUtils.saveToFile(_pointsList, "points.txt");
		
		_pointsList.clear();
		_pointsList = null;
		
		_pointsList = FileUtils.loadFile("points.txt");
		displayOnGraph(_pointsList);
	}
	
	/**
	 * Display only 2D points, 1D points are converted to 2D with y = 0, 
	 * in case of 3D point z value is omitted.
	 * Additionaly it converts floats to ints ^^
	 * @param list
	 */
	private void displayOnGraph(List<Point1D> list) {
		Point graphRange = new Point((int) Point1D.FLOAT_OFFSET, (int) Point1D.FLOAT_OFFSET);
		_currentPositionX = -(int) Point1D.FLOAT_OFFSET;
		_currentPositionY = (int) Point1D.FLOAT_OFFSET;
		while(!list.isEmpty()) {
			printNext(graphRange, getNextPoint());
		}
		finishPrintingGraph(graphRange);
		printPoints();
	}
	
	private Point getNextPoint() {
		int maxY = -Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int index = 0;
		
		for (int i = 0; i < _pointsList.size(); i++) {
			Point1D point = _pointsList.get(i);
			if (point instanceof Point2D) {
				if (isPointBetter(maxY, minX, (int) ((Point2D) point).getX(), (int) ((Point2D) point).getY())) {
					maxY = (int) ((Point2D) point).getY();
					minX = (int) ((Point2D) point).getX();
					index = i;
				}
			}
			else if (point instanceof Point3D) {
				if (isPointBetter(maxY, minX, (int) ((Point3D) point).getX(), (int) ((Point3D) point).getY())) {
					maxY = (int) ((Point3D) point).getY();
					minX = (int) ((Point3D) point).getX();
					index = i;
				}
			}
			else if (isPointBetter(maxY, minX, (int) point.getX(), 0)) {
				maxY = 0;
				minX = (int) point.getX();
				index = i;
			}
		}
		
		_pointsList.remove(index);
		
		return new Point(minX, maxY);
	}
	
	private boolean isPointBetter(int maxY, int minX, int pointX, int pointY) {
		if (pointY > maxY) {
			if (pointY != maxY) {
				return true;
			}
			else if (pointX < minX) {
				return true;
			}
		}
		else if (pointY == maxY && pointX < minX) {
			return true;
		}
		
		return false;
	}
	
	private void finishPrintingGraph(Point range) {
		printUntilProperYAxis(-range.y, range);
		printUntilProperXAxis(range.x);
	}
	
	private void printNext(Point range, Point point) {
		if (isPointRepeated(point.x, point.y)) {
			return;
		}
		
		printUntilProperYAxis(point.y, range);
		printUntilProperXAxis(point.x);
		
		System.out.print("X");
		_currentPositionX++;
		if (_currentPositionY == range.getY()) {
			_currentPositionY++;
		}
		
		_list.add(new Point(point.x, point.y));
	}
	
	private boolean isPointRepeated(int x, int y) {
		Point newPoint = new Point(x, y);
		if (_lastPoint != null && _lastPoint.equals(newPoint)) {
			return true;
		}
		_lastPoint = newPoint;
		return false;
	}
	
	private void printPoints() {
		System.out.println();
		for (Point point : _list) {
			System.out.println(point.x + ", " + point.y);
		}
	}
	
	private void printUntilProperYAxis(int y, Point range) {
		for (int i = y; i < _currentPositionY;) {
			finishPrintingLine(range);
		}
	}
	
	private void printUntilProperXAxis(int x) {
		for (int i = x; i > _currentPositionX;) {
			printOnXAxis(" ");
		}
	}
	
	private void finishPrintingLine(Point range) {
		for (int i = _currentPositionX; i < range.x; i++) {
			printOnXAxis(" ");
		}
		System.out.print("\n");
		--_currentPositionY;
		_currentPositionX = -range.x;
	}
	
	private void printOnXAxis(String string) {
		if (_currentPositionY == 0) {
			if (_currentPositionX == 0) {
				System.out.print("+");
			}
			else {
				System.out.print("-");
			}
		}
		else if (_currentPositionX == 0) {
			System.out.print("|");
		}
		else {
			System.out.print(" ");
		}
		_currentPositionX++;
	}
}
