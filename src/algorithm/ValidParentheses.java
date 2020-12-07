package algorithm;

import java.util.*;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.

 */
public class ValidParentheses {
    public static void main(String[] args) {
      //  System.out.println(isValid("()"));
        System.out.println(isValidAnswer("(}{)"));
    }

    /**
     * 教学解法
     * @param s
     * @return
     */
    public static boolean isValidAnswer(String s) {
        if(s==null||s.length()==0) return true;
        Map<Character, Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> deque = new ArrayDeque<>();
        for (char c :s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                deque.push(c);
            }else{
                if(deque.size()==0|| map.get(c)!= deque.pop())return false;
            }
        }
        return deque.size()==0;
    }

    /**
     * 解题失败
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.length()%2!=0||s.length()==0)return false;
        String first=s.substring(0,1);
        String end=s.substring(s.length()-1,s.length());
        if(first.equals(")")||first.equals("}")||first.equals("]")) return false;
        if(end.equals("(")||end.equals("{")||end.equals("[")) return false;
        for (int i = 0; i < s.length()-1; i++) {
             switch (s.substring(i,i+1)){
                    case "(":
                        if( !s.substring(i+1,i+2).equals(")")&&!s.substring(s.length()-i-1,s.length()-i).equals(")")){
                            return false;
                        }
                        break;
                    case "{":
                        if( !s.substring(i+1,i+2).equals("}")&&!s.substring(s.length()-i-1,s.length()-i).equals("}")){
                            return false;
                        }
                        break;
                    case "[":
                        if( !s.substring(i+1,i+2).equals("]")&&!s.substring(s.length()-i-1,s.length()-i).equals("]")){
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
         return true;

    }

}
