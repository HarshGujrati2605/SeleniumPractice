package com.practice;

import java.io.FileReader;
import java.io.IOException;

public class Filereader {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader(".\\Sample.txt");    
        int i;    
        while((i=fr.read())!=-1)    
        System.out.print((char)i);    
        fr.close();    

	}

}
