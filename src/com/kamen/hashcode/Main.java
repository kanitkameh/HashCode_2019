package com.kamen.hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
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
		output(makeSlides(photoArray));
		/*
		for (int i = 0; i < photoArray.length; i++) {
			photoArray[i].print();
		}
		
		Slide test = new Slide(photoArray[2], photoArray[3]);
		test.printTags();
		*/
		
		
	}
	//makes output file
	public static void output(List<Slide> result) throws NullPointerException{
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("outputfile.txt"));
			int size = result.size();
			out.println(size);
			for (Slide e : result) {
				out.println(e.getFirst().getIndex()+(e.getFirst().isHorizontal()?"":" "+e.getSecond().getIndex()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
		
	}
	//makes photos into slides
	public static List<Slide> makeSlides(Photo[] photoArray){
		List<Photo> photos = new ArrayList<Photo>(Arrays.asList(photoArray));
		List<Slide> slides = new ArrayList<Slide>();
		
		Iterator<Photo> iter = photos.iterator();
		//getting rid of horizontal elements
		while(iter.hasNext()){
			Photo current = iter.next();
			if(current.isHorizontal()){
				slides.add(new Slide(current));
				iter.remove();
			}
			
		}
		photos.sort(new Comparator<Photo>() {

			@Override
			public int compare(Photo arg0, Photo arg1) {
				if(arg0.getTags().length>arg1.getTags().length) {
					return 1;
				}
				if(arg0.getTags().length<arg1.getTags().length) {
					return -1;
				}
				return 0;
			}
			
		});
		while(!photos.isEmpty()) {
			Photo first = photos.get(0);
			photos.remove(0);
			Photo second = photos.get(photos.size()-1);
			photos.remove(photos.size()-1);
			slides.add(new Slide(first,second));
			System.out.println("Made one time");
		}
		return slides;
	}
	//orders the slides into presentation TO-DO
	public static Deque<Slide> makePresentation(){
		return null;
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
