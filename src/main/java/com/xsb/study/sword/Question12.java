package com.xsb.study.sword;

/**
 * 打印1到n位数
 *
 * @author shibao.xing
 * @since 2018-04-21 13:32
 */
public class Question12 {

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        question12.print1ToMaxOfNDigits(3);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] chars = new char[n];
        for (int i = 0; i < 10; i++) {
            chars[0] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(chars, chars.length, 0);
        }

    }

    public void print1ToMaxOfNDigitsRecursively(char[] chars, int length, int index) {

        if (index == length - 1) {
            System.out.println(chars);
            return;
        }

        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(chars, length, index + 1);
        }
    }
}
