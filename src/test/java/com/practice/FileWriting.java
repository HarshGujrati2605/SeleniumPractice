package com.practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

	public static void writeInFile(String nameoffile) {
		try {
			FileWriter myWriter = new FileWriter("GlobalVariable.txt", true);
			FileReader readfile = new FileReader(".//" + nameoffile + "");
			int i;
			while ((i = readfile.read()) != -1)
            myWriter.write(readfile.read());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		writeInFile("Sample.txt");

	}

}
