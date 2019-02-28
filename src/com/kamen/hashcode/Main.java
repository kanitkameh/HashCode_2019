package com.kamen.hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File f = new File("a_example.txt");
		Scanner input = null;
		Photo[] photoArray = null;
		try {
			input = new Scanner(f);
			photoArray = readPhotos(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			input.close();
		}
		/*
		for (int i = 0; i < photoArray.length; i++) {
			photoArray[i].print();
		}
		
		Slide test = new Slide(photoArray[2], photoArray[3]);
		test.printTags();
		*/
		
		
	}
	
	public static Photo[]  readPhotos(Scanner input) {
		int photoCount = Integer.parseInt(input.nextLine());
		Photo[] photoArray = new Photo[photoCount];
		
		for (int i = 0; i < photoArray.length; i++) {
			String[] currentLine = input.nextLine().split(" ");
			char c = currentLine[0].charAt(0);
			int tagCount = Integer.parseInt(currentLine[1]);
			String[] tags = new String[tagCount];
			for (int j = 0; j < tags.length; j++) {
				tags[j] = currentLine[j+2];
			}
			photoArray[i] = new Photo(tags,i,(c=='H'?true:false));
		}
		return photoArray;
	}

}
