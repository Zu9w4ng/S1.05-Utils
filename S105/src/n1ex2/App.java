package n1ex2;

import java.io.File;

public class App {

	public static void main(String[] args) {
		String path = new File("").getAbsolutePath();
		DirectoryList.printDirectoryTree(path);
	}

}
