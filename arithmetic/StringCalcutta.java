
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 设计一种结构或算法实现字符串表达式的运算功能，表达式支持+、-、*、/、%、()、[]。请勿使用脚本引擎实现。
 * @author Administrator
 *
 */
public class StringCalculate {

	public static void main(String[] args) {
		System.out.print(StringCalculate.computeString(args[0]));
	}
	
	/**  
	       * 计算字符串四则运算表达式
	       */  
	      public static String computeString(String string){   
	          String regexCheck ="[\\(\\)\\d\\+\\-\\*/\\.]*";//是否是合法的表达式   
	             
	          if(!Pattern.matches(regexCheck, string))   
	              return string;   
	             
	          Matcher matcher = null;   
	          String temp = "";   
	         int index = -1;   
	         String regex = "\\([\\d\\.\\+\\-\\*/]+\\)";//提取括号表达式   
	          string = string.replaceAll("\\s", "");//去除空格   
	          try{   
	              Pattern pattern = Pattern.compile(regex);   
	             //循环计算所有括号里的表达式   
	              while(pattern.matcher(string).find()){   
	                  matcher = pattern.matcher(string);   
	                 while(matcher.find()){   
	                      temp = matcher.group();   
	                      index = string.indexOf(temp);   
	                     string = string.substring(0, index)+computeStirngNoBracket(temp)+string.substring(index+temp.length());   
	                  }   
	              }   
	              //最后计算总的表达式结果   
	              string = computeStirngNoBracket(string);   
	          }catch (NumberFormatException e) {   
	              return e.getMessage();   
	          }   
	         return string;   
	      }   
	         
	      /**  
	       * 计算不包含括号的表达式  
	       */  
	      private static String computeStirngNoBracket(String string){   
	          string = string.replaceAll("(^\\()|(\\)$)", "");   
	         String regexMultiAndDivision = "[\\d\\.]+(\\*|\\/)[\\d\\.]+";   
	          String regexAdditionAndSubtraction = "[\\d\\.]+(\\+|\\-)[\\d\\.]+";   
	             
	         String temp = "";   
	          int index = -1;   
	             
	          //解析乘除法   
	          Pattern pattern = Pattern.compile(regexMultiAndDivision);   
	          Matcher matcher = null;   
	         while(pattern.matcher(string).find()){   
	              matcher = pattern.matcher(string);   
	             if(matcher.find()){   
	                 temp = matcher.group();   
	                  index = string.indexOf(temp);   
	                  string = string.substring(0, index)+doMultiAndDivision(temp)+string.substring(index+temp.length());   
	              }   
	          }   
	             
	          //解析加减法   
	          pattern = Pattern.compile(regexAdditionAndSubtraction);   
	          while(pattern.matcher(string).find()){   
	              matcher = pattern.matcher(string);   
	              if(matcher.find()){
	                 temp = matcher.group();   
	                  index = string.indexOf(temp);   
	                 string = string.substring(0, index)+doAdditionAndSubtraction(temp)+string.substring(index+temp.length());   
	              }   
	          }   
	             
	          return string;   
	     }   
	       
	      /**  
	       * 执行乘除法 
	       */  
	     private static String doMultiAndDivision(String string){   
	         String value = "";   
	          double d1 = 0;   
	          double d2 = 0;   
	          String[] temp = null;   
	          if(string.contains("*")){   
	              temp = string.split("\\*");   
	          }else{   
	              temp = string.split("/");   
	          }   
	             
	          if(temp.length<2)   
	              return string;   
	             
	          d1 = Double.valueOf(temp[0]);   
	          d2 = Double.valueOf(temp[1]);   
	          if(string.contains("*")){   
	             value=String.valueOf(d1*d2);
	         }else{   
	             value=String.valueOf(d1/d2);   
	         }   
	            
	         return value;   
	     }   
	        
	     /**  
	      * 执行加减法   
	      */  
     private static String doAdditionAndSubtraction(String string){   
	         double d1 = 0;   
	         double d2 = 0;   
	         String[] temp = null;   
	         String value = "";   
	         if(string.contains("+")){   
	             temp = string.split("\\+");   
	         }else{   
	             temp = string.split("\\-");   
	         }   
	            
	         if(temp.length<2)   
	            return string;   
	            
	         d1 = Double.valueOf(temp[0]);   
	         d2 = Double.valueOf(temp[1]);   
	         if(string.contains("+")){   
	             value= String.valueOf(d1+d2);
	         }else{   
	             value=String.valueOf(d1-d2);   
	         }   
	            
	         return value;   
	     }

}
