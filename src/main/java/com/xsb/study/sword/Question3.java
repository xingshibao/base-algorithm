package com.xsb.study.sword;

/**
 * @author shibao.xing
 * @since 2018-04-14 11:33
 */
public class Question3 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Question3 question3 = new Question3();
        boolean find = question3.find(matrix, 3, 3, 5);
        System.out.println(find);
    }

    private boolean find(int[][] array, int rows, int columns, int number) {
        int row = 0;
        int column = columns;
        while (true) {
            if (array[row][column] == number) {
                return true;
            } else if (array[row][column] < number) {
                ++row;
            } else {
                --column;
            }
            if (row > rows || column < 0) {
                break;
            }
        }
        return false;
    }
}
