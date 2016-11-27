/**
 * 输入一个罗马数字（只能输入1-3999的罗马数字），请将其转换成阿拉伯数字，如果输入有误，请输出“exception”。
 * 如输入I，输出1；输入XX，输出20；输入XXVII，输出27；输入ABC，输出异常。
 * @author Administrator
 *
 */
public class Roman2Arab {

	public static void main(String[] args) {
		String roman = args[0];
		if(roman.length() == 0){
			System.out.print("exception");	//输入为空
		}else{
			roman = roman.toUpperCase();
			int index = 0;	//记录罗马字符位置
			int arab = 0;	//转换后阿拉伯数字
			int pre = letter2Number(roman.charAt(0));
			if(pre < 0){
				System.out.print("exception");
				return;
			}
			int temp = pre;
			for(int i=1; i<roman.length(); i++){
				index = letter2Number(roman.charAt(i));
				if(index < 0){	//输入ABC
					System.out.print("exception");
					return;
				}
				if(index == pre){
					temp += index;
				}else if(index > pre){
					temp = index - temp;
				}else if(index < pre){
					arab += temp;
					temp = index;
				}
				pre = index;
			}
			arab += temp;
			if(arab > 3999){
				System.out.print("exception");
				return;
			}
			System.out.print(arab);
		}
	}

	public static int letter2Number(char roman){
		switch (roman)   
        {  
           case 'I':  return 1;  
           case 'V':  return 5;
           case 'X':  return 10;
           case 'L':  return 50;  
           case 'C':  return 100;  
           case 'D':  return 500;  
           case 'M':  return 1000;  
           default:   return -1;  
        }  
	}
}
