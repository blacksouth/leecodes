import java.util.Arrays;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */

public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(1234567898));

    }

    public static int reverse(int x) {
        if(x>0){
            return getNumber(x);
        }
        return  -getNumber(-x);
    }
    public static int getNumber(int num){
        StringBuilder stringBuilder = new StringBuilder();
        Integer integer = new Integer(num);
        String s = integer.toString();
        char[] chars = s.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i = chars.length-1; i >=0 ; i--) {
             chars1[chars.length-1-i]=chars[i];
        }
        for (int i = 0; i <chars1.length ; i++) {
            if(i>0&&chars1[i-1]!=0){
                stringBuilder.append(chars1[i]);
            }else if(i==0&&chars1[i]!=0){
                stringBuilder.append(chars1[i]);
            }
        }
        char[] chars2 = stringBuilder.toString().toCharArray();

        return 1;
    }

}
