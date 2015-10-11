package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the total number of number(s) in the array ");
		int totalNum = scanner.nextInt();
		if(totalNum < 1){
			System.out.println("Exiting as no number to be processed");
			System.exit(0);
		}
		for(int i = 0; i < totalNum; i++){
			System.out.println(i+1+".Enter the number: ");
			intList.add(scanner.nextInt());
		}
		scanner.close();
		
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
