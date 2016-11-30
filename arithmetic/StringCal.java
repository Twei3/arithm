import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 设计一种结构或算法实现字符串表达式的运算功能，表达式支持+、-、*、/、%、()、[]。请勿使用脚本引擎实现。
 * @author tangwei
 *
 */
public class StringCal {
	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript"); 
	public static void main(String[] args) {
		try {
    		String strs = args[0];
			if(strs.indexOf("[")>=0){
				strs =strs.replaceAll("\\[", "(");
				strs =strs.replaceAll("\\]", ")");
			}
			String re = String.valueOf(jse.eval(strs));
			System.out.println(re.split("\\.")[0]);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
