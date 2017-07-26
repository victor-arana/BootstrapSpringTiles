package com.arana.introcs;

public class Exceptions {

	public static void main(String[] args) {
		int[] listOfNumbers = {0, 2, 4};
		fancyDivide(listOfNumbers, 0);
	}

	static void fancyDivide(int[] listOfNumbers, int index) {
		try {
			try {
				throw new Exception("0");
			} finally {
				int denom =  listOfNumbers[index];
				for(int i: listOfNumbers){
					listOfNumbers[i] /= denom;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
