/**
 * 输入一个罗马数字（只能输入1-3999的罗马数字），请将其转换成阿拉伯数字，如果输入有误，请输出“exception”。
 * 如输入I，输出1；输入XX，输出20；输入XXVII，输出27；输入ABC，输出异常。
 * http://blog.csdn.net/li002qwe/article/details/4508839
 * @author tangwei
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
			 while (index < roman.length())   
	          {  
	             char letter = roman.charAt(index);        // 罗马数字当前位置的字符  
	             int number = letter2Number(letter);  // 字符转化为阿拉伯数字  
	               
	             if (number < 0)  
	             {  
	            	 System.out.print("exception");  //罗马数字中不包含输入字符
	            	 return;
	             }  
	               
	             index++;         //移动到字符串的下一个位置  
	               
	             if (index == roman.length())   //罗马数字已处理完毕  
	             {  
	                 arab += number;  
	             }  
	             else   
	             {  
	                    char nextLetter = roman.charAt(index);  
	                    int nextNumber = letter2Number(nextLetter);  
	                  
	                    if (nextNumber > number)  //后边的字符比前边的大  
	                    {    
	                           int result = nextNumber - number;  
	                             
	                           if(result == 4 || result == 9 || result == 40 || result == 90 || result == 400 || result == 900)  
	                           {  
	                               arab += result;  
	                               index++;  
	                                 
	                               if(index == roman.length())     //罗马数字已处理完毕  
	                               {  
	                                   break;  
	                               }  
	                               else  
	                               {  
	                                   char  afterNextLetter = roman.charAt(index);     
	                                   int afterNextNumber = letter2Number(afterNextLetter);  
	                                     
	                                   if(afterNextNumber > result)  
	                                   {  
	                                	   System.out.print("exception");
	                  	            	   return;  
	                                   }  
	                               }  
	                           }  
	                           else   
	                           {  
	                        	   System.out.print("exception");
              	            	   return;
	                           }  
	                     }  
	                     else   
	                     {  
	                            if((number==5 || number==50 ||number==500)&& number == nextNumber)   //V、L、D用于大数右边（相加），使用超过1次。  
	                            {  
	                            	System.out.print("exception");
               	            	   return; 
	                            }  
	                              
	                            if(number == nextNumber)     
	                            {  
	                                index++;    //还要再看下一个字符  
	                                  
	                                if (index == roman.length())   //罗马数字已处理完毕  
	                                {  
	                                   arab += number+nextNumber;  
	                                   break;  
	                                }  
	                                  
	                                char  afterNextLetter = roman.charAt(index);     
	                                int afterNextNumber = letter2Number(afterNextLetter);  
	                                  
	                                if(afterNextNumber > nextNumber) //I、X、C在在大数左边（即相减时）使用超过2个  
	                                {  
	                                	System.out.print("exception");
                  	            	    return; 
	                                }  
	                                else if(afterNextNumber == nextNumber)  //出现3个字符都相同的情况，如III  
	                                {  
	                                    index++;   //还要再看下一个字符,可能会出现IIII这种情况（不允许的，应抛出异常）  
	                                      
	                                    if (index == roman.length())   //罗马数字已处理完毕  
	                                    {  
	                                        arab += number+nextNumber+afterNextNumber;  
	                                        break;  
	                                    }  
	                                      
	                                    char  afterNextNextLetter = roman.charAt(index);     
	                                    int afterNextNextNumber = letter2Number(afterNextNextLetter);  
	                                      
	                                    if(afterNextNextNumber == afterNextNumber)   //出现IIII这种情况  
	                                    {  
	                                    	System.out.print("exception");
		                  	            	return;  
	                                    }  
	                                    else   
	                                    {  
	                                        arab += number;  
	                                        index = index-2;                      //回退2个字符（因为考虑了4个字符）  
	                                    }  
	                                }  
	                                else   
	                                {  
	                                    arab += number+nextNumber;  
	                                }  
	                            }  
	                            else  
	                            {  
	                                arab += number;  
	                            }  
	                     }  
	             }    
	          }   
			if(arab > 3999){
				System.out.print("exception");
				return;
			}
			System.out.print(arab);
		}
	}
	
	public static int letter2Number(char roman) {
		switch (roman) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

}
