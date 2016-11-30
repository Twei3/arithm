package com.efront.junit.exercise.part01.main;
/**
 * 算法求一个正整数的质因数之和。例如输入为12，它的质因数为2、2、3，则和为7。
 * @author tangwei
 *
 */
public class PrimeNumber {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int index = 2;
		int sum = 0;
		while(index <= num){
			if(num % index == 0){
				num = num/index;
				sum += index;
			}else{
				index++;
			}
		}
		System.out.println(sum);
	}
}
