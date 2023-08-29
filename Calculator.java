package com.junit.entity;
import static java.lang.System.out;
public class Calculator {

	public int addition(int a, int b)
	{
		return a+b;
	}
	
	public int fact(int n) {
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact=fact*i;;
		}
		return fact;
	}
	
	
	public boolean checkMumbai() {
		String s="mumbai";
		return s.contains("e");
	}
	
	public boolean checkI() {
		String s="I love my India";
		return s.contains("I");
	}
	
	public int checkLengthOfString(String name){
		return name.length();
	}
	
	public int searchElementArray(int search) {
		int[] arr= {10,20,30,40,50};
		for(int i:arr) {
			if(i==search)
				return 1;
		}
		return 0;
	}
	
	public int[] insertElement(int[] arr, int pos, int element)
	{       
		int[] arr1 = new int[arr.length+1];
		
		for(int i =0 ; i < arr.length+1 ; i++)
		{
			//since the user has no idea regarding the index thus decreasing the value of pos by 1
			if(i<pos-1) 
			{
				arr1[i] = arr[i]; //adding the elements of old array to new array
			}
			else if(i==pos-1) // if the index is same as the position then add the element in that index
			{
				arr1[i] = element;
			}
			else
				arr1[i] = arr[i - 1]; //shifting the elements to right side
		}
		
		return arr1; //returning the new array
	}
	
	public String reverse(String str)
	{
		String rev = "";
		for(int i = str.length()-1; i>=0; i--)
		{
			rev += str.charAt(i);
		}
		
		return rev;
	}
	
	public int division(int a, int b)
	{
		return a/b;
	}
	
	public Object division1(int a, int b)
	{
		try {
			return a/b;
		}
		catch(ArithmeticException e)
		{
			return "Cannot divide a number by zero.";
		}
	}
	
	public int division2(int a, int b) throws ArithmeticException
	{
		return a/b;
	}
	
}