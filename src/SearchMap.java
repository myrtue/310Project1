import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchMap {
	
	public static void main(String args[]) {
		System.out.println("Hello World!");
		
		String inputFile = args[1];
		String outputFile = args[2];
		
		try {
			Scanner s = new Scanner(new File(inputFile));
			readFile(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void readFile(Scanner s) {
		
	}
}
