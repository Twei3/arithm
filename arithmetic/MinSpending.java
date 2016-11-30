package com.efront.junit.exercise.part01.main;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 有N(N≤5000)个数的集合A，每次可以从集合A中删除两个数，然后把他们的和放回集合， 直到剩下一个数。
 * 每次操作的开销等于删除的两个数的和，求最小总开销。所有数均小于100000。
 * @author tangwei
 *
 */
public class MinSpending {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.print(0);
			return;
		}
		Queue<Integer> priorityQueue = new PriorityQueue<>(args.length);
		for(int i=0; i < args.length; i++){
			priorityQueue.add(Integer.parseInt(args[i]));
		}
		int minCost = 0;
		while(priorityQueue.size() > 1){
			int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            priorityQueue.add(a+b);
            minCost += a+b;
		}
		System.out.print(minCost);
		while(!priorityQueue.isEmpty()){
			priorityQueue.poll();
		}
	}

}
