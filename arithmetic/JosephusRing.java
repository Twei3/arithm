package com.efront.junit.exercise.part01.main;
/**
 * 有m(m > 0)个人围成一圈，顺序报号(从1开始)。从第一个人开始报数，凡报到n(n > 0)的人退出圈子，
 * 然后从第n+1（退出圈子位置的下一个人）个人处重新开始报数（从1开始）， 最后留下来的是原来的第几号
 * @author tangwei
 *
 */
public class JosephusRing {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		boolean[] persons = JosephusRing.outPerson(m, n);
		for(int i = 0; i < persons.length; i++){
			if(persons[i]){
				System.out.print(i+1);
			}
		}
	}
	
	public static boolean[] outPerson(int m, int n){
		boolean[] persons = new boolean[m];
		int index = 0;
		int num = m;
		for(int i=0; i < m; i++){
			persons[i] = true;
		}
		while(num != 1){
			for(int j = 0; j < m; j++){
				if (!persons[j]) {
                    continue;
                } else {
                    index++;
                    if (index % n == 0) {
                        persons[j] = false;
                        index = 0;
                    }
                }
			}
			num = 0;
			for(int k = 0; k < m; k++){
				if(persons[k]){
					num++;
				}
			}
		}
		return persons;
	}

}
