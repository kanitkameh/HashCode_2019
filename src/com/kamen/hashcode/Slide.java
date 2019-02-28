package com.kamen.hashcode;

import java.util.ArrayList;

public class Slide {
	private String[] tags;
	private Photo first = null;
	private Photo second = null;
	public Slide(Photo first, Photo second) {
		this.tags = new String[first.getTags().length + second.getTags().length];
		this.first = first.clone();
		this.second = second.clone();
		int i = 0;
		for (i = 0; i < first.getTags().length; i++) {
			this.tags[i] = first.getTags()[i];
		}
		for (int j = 0; j < second.getTags().length; j++) {
			if(!contains(second.getTags()[j], first.getTags())){
				this.tags[i] = second.getTags()[j];
				i++;
			}
		}
		tags = removeNull(tags);
	}
	private String[] removeNull(String[] a) {
		   ArrayList<String> removedNull = new ArrayList<String>();
		   for (String str : a)
		      if (str != null)
		         removedNull.add(str);
		   return removedNull.toArray(new String[0]);
	}
	public Slide(Photo first) {
		this.first = first.clone();
		this.tags = this.first.getTags();
	}
	
	private boolean contains(String str, String[] tags) {
		for(int i = 0; i < tags.length; i++) {
			if(tags[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	public void printTags() {
		System.out.println("Tag count "+tags.length);
		for (int i = 0; i < this.tags.length; i++) {
			System.out.print(tags[i] + " ");
		}
		System.out.println();
	}
	public String[] getTags() {
		return tags.clone();
	}
	public void setTags(String[] tags) {
		this.tags = tags.clone();
	}
	public Photo getFirst() {
		return first.clone();
	}
	public void setFirst(Photo first) {
		this.first = first.clone();
	}
	public Photo getSecond() {
		return second.clone();
	}
	public void setSecond(Photo second) {
		this.second = second.clone();
	}
}
