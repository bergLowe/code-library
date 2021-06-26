// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] matrix = new int[grid.length][2];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            matrix[i][1] = rowMaxNum(grid, i);
            matrix[i][0] = colMaxNum(grid, i);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += (Math.min(matrix[i][1], matrix[j][0]) - grid[i][j]);
            }
        }

        return sum;
    }

    private int rowMaxNum (int[][] grid, int index) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (max < grid[index][i]) {
                max = grid[index][i];
            }
        }
        return max;
    }

    private int colMaxNum (int[][] grid, int index) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            if (max < grid[i][index]) {
                max = grid[i][index];
            }
        }
        return max;
    }
}