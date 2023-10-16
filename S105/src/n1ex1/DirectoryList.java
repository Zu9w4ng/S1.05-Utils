package n1ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DirectoryList {
	
	private static String path = new File("").getAbsolutePath();
	private static File directory = new File(path);
	private static ArrayList<String> contents = new ArrayList<String>(Arrays.asList(directory.list()));
	
	public static void printDirectory() {
		try {
			Collections.sort(contents);
			System.out.println(contents);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
