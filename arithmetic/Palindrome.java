/**
 * 给定一个字符串，在其中找到最长的回文字.算法时间复杂度为O(n^3) 
 * http://blog.sina.com.cn/s/blog_3fe961ae0101iwc2.html
 * @author tangwei
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String str = args[0];
		String result=null;  
	    String temp="";  
	    //定义最长回文子串的长度  
	    int max=0;
	    if(str.length() == 1){
	    	System.out.print(str);
	    	return;
	    }
	    //遍历字符串中的所有元素  
	    for(int i=0;i<str.length();i++){  
	        //数组下标指针j从字符串后面开始往前遍历  
	        for(int j=str.length()-1;j>i;j--){  
	            //判断每一个字符串时候为回文  
	            temp=str.substring(i, j+1);  
	            //如果tempString是回文子串并且其长度(j-i+1)>max  
	            if(isPalindrome(temp)&&(j-i+1)>max){  
	                max = j-i+1;  
	                result = temp;  
	            }  
	        }  
	    }  
	    System.out.print(result);
	}
	
	/* 
     * 回文判断 
     * 问题描述：回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我， 
     * 方法一： 
     * 分析：使用两个"指针"分别从字符串头和尾扫描，若每一个"指针"所指值都相等，这为回文 
     */  
    public static boolean isPalindrome(String s){  
        if(s==null)  
            return false;  
        int left=0;  
        int right=s.length()-1;  
        while(left<right){  
            if(s.charAt(left)!=s.charAt(right))  
                return false;  
            left++;  
            right--;  
        }  
        return true;  
    }  

}
