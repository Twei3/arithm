/**
 * 有一对兔子，出生后第三个月起每个月都生一对兔子，小兔子出生后第三个月起又每个月生一对，
 * 假设兔子不死，到n个月时兔子的总数是多少对
 * @author tangwei
 *
 */
public class Rabbit {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.print(fib(n));
	}
	
	public static int fib(int n){
		if(n <= 2){
			return 1;
		}else{
			return fib(n-1) + fib(n-2);
		}
	}

}
