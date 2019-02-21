/**
 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34...... ，规则是当前数（n>2）为前两位数字之和。
 * 请用算法实现求第1个至第n个数字之和。
 * @author tangwei
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		System.out.println(Fibonacci.fibSum(num));
	}

	public static int fib(int n){
		if(n <= 1){
			return 1;
		}else{
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static int fibSum(int n){
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += fib(i);
		}
		return sum;
	}
}
