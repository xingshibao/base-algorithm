package com.xsb.study.leetcode;

/**
 * @author shibao.xing
 * @since 2018-04-18 20:54
 */
public class Question64 {

    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1}, {1}};

        Question64 question64 = new Question64();
        int min = question64.minPathSum(grid);
        System.out.println(min);
    }

    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int[][] result = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            int sum = 0;
            for (int j = 0; j < columnCount; j++) {
                if (i == 0) {
                    sum += grid[0][j];
                    result[i][j] = sum;
                } else {
                    if (j == 0) {
                        result[i][j] = result[i - 1][j] + grid[i][j];
                    } else {
                        result[i][j] = Math.min(result[i][j - 1], result[i - 1][j]) + grid[i][j];
                    }
                }
            }
        }

        return result[rowCount - 1][columnCount - 1];
    }

    public int minPathSumRecusion(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int i = Math.min(minPathSumRecusion(grid, rowCount - 1, columnCount), minPathSumRecusion(grid, rowCount, columnCount - 1)) + grid[rowCount - 1][columnCount - 1];
        return i;
    }

    public int minPathSumRecusion(int[][] grid, int rowCount, int colunmCount) {
        if (rowCount == 1 || rowCount == 0) {
            int sum = 0;
            for (int i = 0; i < colunmCount; i++) {
                sum += grid[0][i];
            }
            return sum;
        }

        if (colunmCount == 1 || colunmCount == 0) {
            int sum = 0;
            for (int i = 0; i < rowCount; i++) {
                sum += grid[i][0];
            }
            return sum;
        }

        return Math.min(minPathSumRecusion(grid, rowCount - 1, colunmCount), minPathSumRecusion(grid, rowCount, colunmCount - 1)) + grid[rowCount - 1][colunmCount - 1];
    }
}
