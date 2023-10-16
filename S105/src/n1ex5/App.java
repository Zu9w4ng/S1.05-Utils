package n1ex5;

import java.io.*;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {

		SerializableClass object = new SerializableClass("Juan", 34, 175, 71);
		
		//serialize
		try {
			String path = new File("").getAbsolutePath() + "/src/n1ex5/";
	        FileOutputStream fileOut = new FileOutputStream(path + "object.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(object);
	        out.close();
	        fileOut.close();
	    } 
		catch (IOException i) {
	        i.printStackTrace();
	    }
		
		//deserialize
		SerializableClass returnedObject;
		
		try {
			String path = new File("").getAbsolutePath() + "/src/n1ex5/";
	        FileInputStream fileIn = new FileInputStream(path + "object.ser");
	        ObjectInputStream input = new ObjectInputStream(fileIn);
	        
	        returnedObject = (SerializableClass) input.readObject();
	        input.close();
	        fileIn.close();
	        System.out.println(returnedObject.toString());
	    } 
		catch (IOException i) {
	        i.printStackTrace();
	    }
		
		
		
	}

}
