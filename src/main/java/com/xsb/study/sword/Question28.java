package com.xsb.study.sword;

/**
 * 全排列
 *
 * @author shibao.xing
 * @since 2018-04-14 19:07
 */
public class Question28 {

    public static void main(String[] args) {
        double a = 1.000001;
        double b = 0.000001;

        System.out.println(Math.abs(a - b - 1.0) <= 0.000001);
        System.out.println(a - b == 1.0);
        System.out.println(a - b - 1.0);
        System.out.println(a - b);
        System.out.println(Double.compare(a - b, 1.0));
    }
}
