package com.efront.junit.exercise.part01.main;
/**
 * 输入两个正整数m和n，求其最大公约数和最小公倍数
 * @author tangwei
 *
 */
public class DivisorAndMultiple {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.print(DivisorAndMultiple.maxDivisor(m, n) + " ");
		System.out.print(DivisorAndMultiple.minMultiple(m, n));
	}
	
	public static int maxDivisor(int m, int n){
		int temp = 0;
		while(m%n != 0){
			temp = m%n;
			m = n;
			n = temp;
		}
		return n;
	}
	
	public static int minMultiple(int m, int n){
		return m*n/maxDivisor(m, n);
	}
}
