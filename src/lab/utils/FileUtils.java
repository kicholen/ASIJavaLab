package lab.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import lab.tasks.third.Point1D;
import lab.tasks.third.Point2D;
import lab.tasks.third.Point3D;


public class FileUtils {
	
	public static List<Point1D> loadFile(String fileName) {
		File file = new File(fileName);
		List<Point1D> list1D = new ArrayList<Point1D>();
		List<Point2D> list2D = new ArrayList<Point2D>();
		List<Point3D> list3D = new ArrayList<Point3D>();
		
		try (FileInputStream inputStream = new FileInputStream(file)) {
			Scanner scanner = new Scanner(inputStream);
			ArrayList<Float> tempList = new ArrayList<Float>();
			
			Pattern patternLeftParenthesis = Pattern.compile("(\\()|(\\,)");
			Pattern patternRightParenthesis = Pattern.compile("\\)");
			
			while(scanner.hasNext()) {
				if (scanner.hasNext(patternLeftParenthesis)) {
					scanner.next();
				}
				else if (scanner.hasNext(patternRightParenthesis)) {
					if (tempList.size() == 1) {
						list1D.add(new Point1D(tempList.get(0).floatValue()));
						tempList.clear();
					}
					else if (tempList.size() == 2) {
						list2D.add(new Point2D(tempList.get(0).floatValue(), tempList.get(1).floatValue()));
						tempList.clear();
					}
					else if (tempList.size() == 3) {
						list3D.add(new Point3D(tempList.get(0).floatValue(), tempList.get(1).floatValue(), tempList.get(2).floatValue()));
						tempList.clear();
					}
					scanner.next();
				}
				else {
					tempList.add(new Float(scanner.next()));
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list1D.addAll(list2D);
		list1D.addAll(list3D);
		return list1D;
	}
	
	public static void saveToFile(List<Point1D> list, String fileName) {
		Path path = Paths.get(fileName);
		String stringToWrite = "";
		
		for (Point1D point : list) {
			stringToWrite += point.getFormattedString();
		}
		
	    try {
			Files.write(path, stringToWrite.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
