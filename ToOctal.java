/**
 * 求一个正整数的8进制数的每位之和。比如9，八进制表示为11，则它的八进制的每位之和为:2
 * @author Administrator
 *
 */
public class ToOctal {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		String str = Integer.toOctalString(n);
		char[] arr = str.toCharArray();
		int sum = 0;
		for(int i = 0;i < arr.length; i++){
			sum += Integer.parseInt(Character.toString(arr[i]));
		}
		System.out.print(sum);
	}

}
