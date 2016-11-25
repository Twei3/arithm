/**
 * 给定K个整数组成的序列{ N1，N2,...Nk},“连续子列”被定义为{ Ni,Ni+1...Nj}，其中 1≤i≤j≤K。
 * “最大子列和”则被定义为所有连续子列元素的和中最大者。
 * 例如给定序列{ -2, 11, -4, 13, -5, -2 }，其连续子列{ 11, -4, 13 }有最大的和20。
 * 现要求你编写程序，计算给定整数序列的最大子列和。
 * 输入格式:输入第1个数字给出整数个数K，空格，再给出K个整数，其间以空格分隔。
 * 输出格式:在一行中输出最大子列和。如果序列中所有整数皆为负数，则输出0。
 * @author tangwei
 *
 */
public class MaxSequenceSum {

	public static void main(String[] args) {
		int maxSum = 0;
		int thisSum = 0;
		int length = Integer.parseInt(args[0]);
		for(int j = 1; j <= length; j++){
			thisSum += Integer.parseInt(args[j]);
			if(thisSum < 0){
				thisSum = 0;
			}else{
				if(thisSum > maxSum){
					maxSum = thisSum;
				}
			} 
		}
		System.out.print(maxSum);
	}

}
