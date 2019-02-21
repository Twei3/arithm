/**
 * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程找出N以内的所有完数
 * @author tangwei
 *
 */
public class PerfectNumber {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int num,pri,sum;
		StringBuffer sbf = new StringBuffer();
		for(num = 1; num < n; num++){
			sum = 0;
			for(pri = 1; pri < num; pri++){
				if(num%pri == 0){
					sum += pri;
				}
			}
			if(num == sum){
				sbf.append(num + " ");
			}
		}
		System.out.println(sbf.toString().trim());
	}

}
