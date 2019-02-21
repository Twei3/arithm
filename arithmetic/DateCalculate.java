/**
 * 输入某年year(4位正整数)某月month（1-12）某日day（1-31），判断这一天是这一年的第几天。
 * 如果日期无效，请输出-1. 
 * @author tangwei
 *
 */
public class DateCalculate {
	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int day = Integer.parseInt(args[2]);
		int Feb = 0;
		int count = 0;
		int error = -1;
		if(year%400 == 0 || (year%4 == 0 && year%100 != 0)){
			Feb = 29;
		}else{
			Feb =28;
		}
		switch (month) {
		case 1:
			if(day > 0 && day <= 31){
				count = day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 2:
			if(day > 0 && day <= Feb){
				count = 31 + day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 3:
			if(day > 0 && day <= 31){
				count = 31 + Feb + day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 4:
			if(day > 0 && day <= 30){
				count = 31+Feb+31+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 5:
			if(day > 0 && day <= 31){
				count = 31+Feb+31+30+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 6:
			if(day > 0 && day <= 30){
				count = 31+Feb+31+30+31+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 7:
			if(day > 0 && day <= 31){
				count = 31+Feb+31+30+31+30+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 8:
			if(day > 0 && day <= 31){
				count = 31+Feb+31+30+31+30+31+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 9:
			if(day > 0 && day <= 30){
				count = 31+Feb+31+30+31+30+31+31+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 10:
			if(day > 0 && day <= 31){
				count = 31+Feb+31+30+31+30+31+31+30+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 11:
			if(day > 0 && day <= 30){
				count = 31+Feb+31+30+31+30+31+31+30+31+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;
		case 12:
			if(day > 0 && day <= 31){
				count = 31+Feb+31+30+31+30+31+31+30+31+30+day;
			}else{
				count = error;
			}
			System.out.println(count);
			break;

		default:
			System.out.println("请输入正确的月份");
			break;
		}
	}
}
