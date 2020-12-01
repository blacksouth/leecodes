package test;

import java.math.BigDecimal;

public class test02 {
    public static void main(String[] args) {

        System.out.println(new BigDecimal("10.00").multiply(new BigDecimal("1.000")).subtract(new BigDecimal("10.00")));

        String a="enterprise.areaMeasure";
         String b=a.substring(0,10);
        System.out.println(b);
    }
}
