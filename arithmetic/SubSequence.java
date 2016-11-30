/**
 * 假如给你一个长度为n(其中n≤106)的序列A，请你在这个序列中找出一个尽量长的连续子序列Am~An，要求该序列中不包含相同的元素。
 * @author tangwei
 *
 */
public class SubSequence {

	public static void main(String[] args) {
		int[] a = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			a[i] = Integer.valueOf(args[i]);
		}
		String temp = "";
		String out = "";
		for (int i = 1; i < args.length; i++) {
			if (a[i - 1] != a[i] - 1) {
				temp = "";
				continue;
			} else {
				if (temp.length() > 0) {
					temp = temp.substring(0, temp.length() - 1);
				}
				temp += a[i - 1] + " " + a[i];
			}
			if (temp.length() >= out.length()) {
				out = temp;
			}
		}
		System.out.print(out);
	}

}
