package algorithm;

import java.util.ArrayList;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *

 */
public class 回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindromeAnswerOne(121));
    }


    /**
     * 教学最优解
     * @param x
     * @return
     */
    public static boolean isPalindromeAnswerBest(int x){
        if(x<0 || (x!=0 && x%10==0)) return false;
        int n=0;
        while(x>n){
            n *=10;
            n += x%10;
            x/=10;
         }
        return (x==n)||(n/10==x);
    }
     /**
     * 教学解法
     * @param x
     * @return
     */
    public static boolean isPalindromeAnswerOne(int x){

        String s = new Integer(x).toString();
        String s1 = new StringBuilder(s).reverse().toString();
        if(s.equals(s1)){
            return true;
        }
        return false;
    }

    /**
     * 自己做法
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        if(x<0){
            return false;
        }
        int num=0;
        int i=x;
        while(i>0){
            int number = i % 10;
            i/=10;
            list.add(number);
        }
        for (int j = 0; j <list.size() ; j++) {
            int pow =(int) Math.pow(10, list.size()-j-1);
            num+=list.get(j)*pow;
        }
        if(num==x){
            return true;
        }
        return false;
    }
}
