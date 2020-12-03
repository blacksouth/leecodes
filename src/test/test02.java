package test;

import java.math.BigDecimal;

public class test02 {
    public static void main(String[] args) {
        String a="asdqwezxc";
        String b="{[()]}";
        for (int i = 0; i <b.length() ; i++) {
            System.out.println(b.substring(i,i+1));
            System.out.println(b.substring(b.length()-i-1,10));
        }


    }
}
