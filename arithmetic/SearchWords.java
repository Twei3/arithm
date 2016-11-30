import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 现有一个按CamelCase规则编写的词组，请寻找该词组中的单词个数。CamelCase词组有以下特征:
 * 1. 由1个或多个英文单词组成。
 * 2. 第一个词首字母为小写，其他字母也为小写。
 * 3. 其余的词首字母为大写，其他字母为小写。
 * 词组的长度不超过10^5
 * 输入:saveChangesInTheEditor
 * 输出:5
 * @author tangwei
 *
 */
public class SearchWords {

	public static void main(String[] args) {
		String str = args[0];
		if(!str.matches("^[a-z]+([A-Z][a-z]*)*$")){
			System.out.print(0);
			return;
		}
		int count = 0;
		  String reg = "[A-Z]";
	      Pattern pattern = Pattern.compile(reg);
	      Matcher matcher = null;   
	      while(pattern.matcher(str).find()){   
              matcher = pattern.matcher(str);   
              while(matcher.find()){
            	  String temp = matcher.group();   
                  int index = str.indexOf(temp);   
                  str = str.substring(index+1); 
                  count++;
              }   
          }   
		System.out.print(count+1);
	}

}
