package com.xsb.study.sword;

/**
 * @author shibao.xing
 * @since 2018-04-20 11:15
 */
public class CoinSolution {

    public static void main(String[] args) {
        CoinSolution coinSolution = new CoinSolution();
        int[] value = {0, 1, 2, 5, 10};
        int i = coinSolution.getSolutionCount(value, 10);
        System.out.println(i);
    }

    private int getSolutionCount(int[] value, int n) {
        int colunm = n + 1;
        int row = value.length;
        int[][] result = new int[row][colunm];
        for (int i = 0; i < row; i++) {
            result[i][0] = 0;
        }
        for (int i = 0; i < colunm; i++) {
            result[0][i] = 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < colunm ; j++) {
                int num = 0;
                while (true) {
                    if (j - num * value[i] > 0) {
                        result[i][j] += result[i - 1][j - num * value[i]];
                        ++num;
                    } else if (j - num * value[i] == 0) {
                        result[i][j] += 1;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

//        for (int[] ints : result) {
//            System.out.println(Arrays.toString(ints));
//        }
        return result[row -1][colunm -1];
    }
}
