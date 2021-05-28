package com.ds.mathematics;

//Sieve of Eratosthenes
public class PrimeNumbers {

	public static void main(String[] args) {
		PrimeNumbers p = new PrimeNumbers();
		p.printPrimeNumbers(50);
	}
	
	public void printPrimeNumbers(int n) {
		StringBuilder str = new StringBuilder();
		// arr[0], arr[1], arr[2]
		boolean [] primeArr = new boolean[n+1];
		for (int i = 1 ;i< primeArr.length; i++ ) {
			primeArr[i]= true;
		}
		for(int i = 2; i <= n; i++) {
			if (primeArr[i] == true) {
				for ( int j = i*i; j < n; j+= i) {
					primeArr[j] = false;
				}
			}
		}
		for (int i = 2; i < n ; i++) {
			if (primeArr[i] == true) {
			str.append("-->" + i);
			}
		}
		System.out.println(str.toString());
	}
	
	public void printArr(boolean[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i);
		}
	}
}
