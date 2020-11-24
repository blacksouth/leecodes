import java.util.Arrays;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
   输入: 123
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
        System.out.println(reverse(-123));
     }


    /**
     * 教学解法
     * @param x
     * @return
     */
    public static int reverseAnwser(int x) {
        if(x==Integer.MIN_VALUE) return 0;
        int neg=x<0 ? -1:1;
        x*= neg;
        int ret=0;
        while(x>0){
            int n=ret;
            n *=10;
            n +=x % 10;
            x /=10;
            //判断整数是否溢出
            if(n/10!=ret)return 0;
            ret=n;
        }
        return ret*neg;
    }




    /**
     * 自己做法
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if(x>0){
            return getNUmberOne(x);
        }
        return  -getNUmberOne(-x);
    }
    public static int getNUmberOne(int x){
        StringBuilder stringBuilder = new StringBuilder();
        Integer integer = new Integer(x);
        String s = integer.toString();
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            stringBuilder.append(chars[i]);
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        }catch (NumberFormatException e){
            return 0;
        }
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
        int sum=0;
        for (int i = 0; i < chars2.length; i++) {
            int pow = (int)Math.pow(10, (int) chars2.length-1 - i);
             sum+=(((int)chars2[i]-48)*pow);
        }
        return sum;
    }

}
