package algorithm;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 * <p>
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 */
public class 重复叠加字符串匹配 {



    public static void main(String[] args) {
        int i = repeatedStringMatch("abcd", "abcdb");
        System.out.println(i);
    }

    public static int repeatedStringMatch(String a, String b) {
        int repeatCount = 0;
        StringBuilder aBuilder = new StringBuilder();
        while (repeatCount <= b.length()+1) {
            aBuilder.append(a);
            if (aBuilder.indexOf(b) > -1) {
                return repeatCount+1;
            }
            repeatCount++;
        }
        return -1;
    }
}
