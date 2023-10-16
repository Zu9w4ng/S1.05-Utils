package n1ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DirectoryList {
	
	private static int tabNum;
	
	public static void printDirectory(String path) {
		
		File currentDirectory = new File(path);
		ArrayList<File> contents = new ArrayList<File>(Arrays.asList(currentDirectory.listFiles()));
		try {
			Collections.sort(contents);
			Character type; 
			for (File file : contents) {
				if (file.isDirectory()) {
					type = 'D';
				}
				else if (file.isFile()) {
					type = 'F';
				}
				else {
					throw new Exception("alguna cosa no es fitxer o directori");
				}
				System.out.println(file.getName() + " type: " + type + " last modified: " + file.lastModified());
			}	
		} 
		catch (Exception e) {
			System.out.println("no es possible ordenar i imprimir el contingut");
		}
	}
	
	public static void printDirectoryTree(String path) {
		File currentDirectory = new File(path);
		ArrayList<File> contents = new ArrayList<File>(Arrays.asList(currentDirectory.listFiles()));
		try {
			Collections.sort(contents);
			Character type; 
			for (File file : contents) {
				for (int i = 0; i < tabNum; ++i) {
					System.out.print("    ");
				}
				if (file.isDirectory()) {
					type = 'D';
					System.out.println(file.getName() + " type: " + type + " last modified: " + file.lastModified());
					String newPath = file.getAbsolutePath();
					tabNum++;
					printDirectoryTree(newPath);
					tabNum--;
				}
				else if (file.isFile()) {
					type = 'F';
					System.out.println(file.getName() + " type: " + type + " last modified: " + file.lastModified());
				}
				else {
					throw new Exception("alguna cosa no es fitxer o directori");
				}
				
			}	
		} 
		catch (Exception e) {
			System.out.println("no es possible ordenar i imprimir el contingut");
		}
		
	}

}
