package test;


/**
 * 姓名 刘昊楠
 * 电话 18008733159
 *
 * 若目标字符串中存在源字符串则返回第一个索引位置没有则返回-1
 */
public class test02 {
    public static void main(String[] args) {
        String a="asdqwezxc";
        String b="zxc";
        System.out.println(indexof(b,a));

    }
    /**
     *
     * @param source
     * @param target
     * @return
     */
    public static int indexof(String source,String target){
        //目标字符串长度大于源字符串长度
        if(target.length()<source.length()) return -1;
        char[] arrayTarget = target.toCharArray();
        char[] arraySource = source.toCharArray();
        //flag 0表示源字符串还没有开始遍历 1表示已经开始遍历
        int flag=0;
        int temp=0;
        for (int i = 0; i <arrayTarget.length ; i++) {
            if((arrayTarget[i]==arraySource[temp])){
                temp++;
               if(temp==source.length()){
                   return i-temp+1;
               }
               flag=1;
            }else if(arrayTarget[i]!=arraySource[temp]&&flag==1)
                 return -1;
            }
           return -1;
        }
 }
