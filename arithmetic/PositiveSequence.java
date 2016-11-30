package com.efront.junit.exercise.part01.main;
/**
 * 输入一个正数n，输出所有和为n连续正数序列。1+2+3+4+5 = 4+5+6 = 7+8 = 15
 * @author tangwei
 *
 */
public class PositiveSequence {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		StringBuffer sbf = new StringBuffer();
		int beg = 1;
		int end = 2;
		int sum = beg + end;
		while(beg < (n+1)/2){
			if(sum == n){
				for(int i = beg; i <= end; i++){
					if(i != end){
						sbf.append(i+"+");
					}else{
						sbf.append(i+" ");
					}
				}
				sum -= beg;
				beg++;
				end++;
				sum += end;
			}
			if(sum > n){
				sum -= beg;
				beg++;
			}else{
				end++;
				sum += end;
			}
		}
		System.out.print(sbf.toString().trim());
	}

}
