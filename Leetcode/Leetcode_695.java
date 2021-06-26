class Solution {
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && !(visited[i][j])) {
                    maxArea = Math.max(maxArea, findArea(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int findArea(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            visited[row][col] || grid[row][col] == 0) {
                return 0;
            }
        
        visited[row][col] = true;
        return (1 + findArea(grid, row + 1, col) + findArea(grid, row - 1, col) + findArea(grid, row, col + 1) + findArea(grid, row, col - 1));
        
    }
}