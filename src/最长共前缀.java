/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。

 */

public class 最长共前缀 {
    public static void main(String[] args) {
        String []aa={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(aa));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs ==null||strs.length==0){
            return null;
        }
        String pre=strs[0];
        for (String s :strs) {
            while(s.indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
            }
        }
        return  pre;

    }


}
