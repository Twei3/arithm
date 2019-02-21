/**
 * 将一个正整数分解质因数
 * @author tangwei
 *
 */
public class PrimeFactors {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		StringBuffer sbf = new StringBuffer();
		for(int i=2; i <= n;i++){
			while(n%i == 0){
				n = n/i;
				sbf.append(i+" ");
			}
		}
		System.out.print(sbf.toString().trim().replace(" ", "*"));
	}

}
