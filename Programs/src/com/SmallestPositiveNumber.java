package com;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Rahul Jain
 * 
 * This program will find out the smallest positive number from a given array of positive integers
 */
public class SmallestPositiveNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SmallestPositiveNumber obj = new SmallestPositiveNumber();
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(8);
		intList.add(2);
		intList.add(3);
		System.out.println("Smallest Number:: "+obj.smallestPositiveNumber(intList,""));
	}
	
	public String smallestPositiveNumber(List<Integer> intList,String finalOutput){

		if(intList.size()==1){
			return finalOutput+Integer.toString(intList.get(0));
		}
		
		String temp = "";
		String totalNumber = "0";
		int smallestElementInArray = 0;
		
		for(int i=0;i<intList.size();i++){
			temp = temp + intList.get(i);
			for(int j=0;j<intList.size();j++){
				if(i==j){
					continue;
				}
				temp = temp + intList.get(j);
			}
	
			if(Integer.parseInt(totalNumber)==0 || Integer.parseInt(totalNumber)>Integer.parseInt(temp)){
				totalNumber = temp;
				smallestElementInArray = intList.get(i);
			}
			temp = "";
		}
		
		intList.remove(new Integer(smallestElementInArray));
		
		return finalOutput+Integer.toString(smallestElementInArray)+smallestPositiveNumber(intList,finalOutput);
	}

}
