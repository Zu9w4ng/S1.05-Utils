package n1ex3;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DirectoryList {
	
	private static int tabNum;
	private static String result = "";
	
	public static void printDirectory(String path) {
		
		File currentDirectory = new File(path);
		ArrayList<File> contents = new ArrayList<File>(Arrays.asList(currentDirectory.listFiles()));
		File resultFile = new File(path + "./src/n1ex3/resultFile.txt");
        try {
            if (!resultFile.createNewFile()){
                System.out.println("The file already exists");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		try {
			FileWriter writer = new FileWriter(path + "./src/n1ex3/resultFile.txt");
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
				writer.write(file.getName() + " type: " + type + " last modified: " + file.lastModified() + "\n");
			}
			writer.close();
		} 
		catch (Exception e) {
			System.out.println("no es possible ordenar i imprimir el contingut");
		}
	}
	
	private static void generateDirectoryTree(String path) {
		
		File currentDirectory = new File(path);
		ArrayList<File> contents = new ArrayList<File>(Arrays.asList(currentDirectory.listFiles()));
		try {
			Collections.sort(contents);
			Character type; 
			for (File file : contents) {
				for (int i = 0; i < tabNum; ++i) {
					result += ("    ");
				}
				if (file.isDirectory()) {
					type = 'D';
					result += (file.getName() + " type: " + type + " last modified: " + file.lastModified() + "\n");
					String newPath = file.getAbsolutePath();
					tabNum++;
					generateDirectoryTree(newPath);
					tabNum--;
				}
				else if (file.isFile()) {
					type = 'F';
					result += (file.getName() + " type: " + type + " last modified: " + file.lastModified() + "\n");
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
	
	public static void printDirectoryTree(String path) {
		
		generateDirectoryTree(path);
		FileWriter writer;
		try {
			writer = new FileWriter(path + "./src/n1ex3/resultFile.txt");
			writer.write(result);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result = "";
	}

}
