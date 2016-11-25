/**
 * 有一堆石头，你和你的朋友每次只能从中拿走1-3块石头，你先开始拿，谁拿到最后一块石头谁赢,现在有n(n > 0)块石头，
 * 计算应该谁赢。如果你赢，输出0，如果你的朋友赢，输出1
 * http://blog.csdn.net/littlestream9527/article/details/9068061
 * @author tangwei
 *
 */
public class StoneGame {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if(n <= 3){
			System.out.print(0);
		}else{
			if(n%(3+1) == 0){
				System.out.print(1);
			}else{
				System.out.print(0);
			}
		}
	}

}
