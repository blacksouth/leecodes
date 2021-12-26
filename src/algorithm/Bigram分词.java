package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 */
public class Bigram分词 {


    public static void main(String[] args) {
        //String text = "alice is a good girl she is a good student", first = "a", second = "good";
        String text = "ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv ypkk", first = "lnlqhmaohv", second = "ypkk";
        String[] ocurrences = findOcurrences01(text, first, second);

        System.out.println(Arrays.toString(ocurrences));
    }

    public static String[] findOcurrences01(String text, String a, String b) {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {
            if (ss[i].equals(a) && ss[i + 1].equals(b)) {
                list.add(ss[i + 2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }



    public static String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        int length = split.length;
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String objectOne = split[i];
            String objectTwo;
            if (i + 1 >= length) {
                objectTwo = "";
            } else {
                objectTwo = split[i + 1];
            }
            String objectThree;
            if (i + 2 >= length) {
                objectThree = null;
            } else {
                objectThree = split[i + 2];
            }
            if (objectOne.equals(first) && objectTwo.equals(second)) {
                strings.add(objectThree);

            }

        }
        List<String> collect = strings.stream().filter(item -> item!=null).collect(Collectors.toList());

        return collect.toArray(new String[collect.size()]);
    }

}
