package com.kamen.hashcode;

import java.util.Arrays;

public class Photo {
	private String[] tags;
	private int index;
	private boolean isHorizontal;
	public Photo(String[] tags,int index,boolean isHorizontal){
		this.tags = tags.clone();
		this.index = index;
		this.isHorizontal = isHorizontal;
	}
	public void print() {
		System.out.print((isHorizontal?'H':'V')+" "+index);
		for (int i = 0; i < tags.length; i++) {
			System.out.print(" "+tags[i]);
		}
		System.out.println();
	}
	public String[] getTags() {
		return tags.clone();
	}
	public void setTags(String[] tags) {
		this.tags = tags.clone();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isHorizontal() {
		return isHorizontal;
	}
	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	} 
	@Override
	public Photo clone() {
		return new Photo(tags,index,isHorizontal);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + (isHorizontal ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(tags);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (index != other.index)
			return false;
		if (isHorizontal != other.isHorizontal)
			return false;
		if (!Arrays.equals(tags, other.tags))
			return false;
		return true;
	}
}
