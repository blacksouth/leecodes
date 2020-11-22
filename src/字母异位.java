import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */

public class 字母异位 {

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));
    }


    /**
     * 自己的做法一
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }


}
