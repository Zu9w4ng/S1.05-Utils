package n1ex4;

import java.io.File;

import n1ex4.DirectoryList;

public class App {

	public static void main(String[] args) {
		String path = new File("").getAbsolutePath();
		DirectoryList.fileDirectoryTree(path);
		String pathRead = path + "/src/n1ex4/resultFile.txt";
		DirectoryList.printFile(pathRead);
	}

}