class Solution {
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int[][] visitNeighbors = new int[][]{
            {-1, -1},   // Top left
            {-1, 0},    // Top
            {-1, 1},    // Top right
            {0, -1},    // Left
            {0, 1},     // Right
            {1, -1},    // Bottom left
            {1, 0},     // Bottom
            {1, 1}      // Bottom right
        };
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0' && !visited[i][j]) {
                    numIslands++;
                    traverseIsland(grid, i, j, visitNeighbors);
                } 
            }
        }

        return numIslands;
    }

    private void traverseIsland (char[][] grid, int rowIndex, int colIndex, int[][] visitNeighbors) {
        visited[rowIndex][colIndex] = true;
        for (int k = 0; k < visitNeighbors.length; k++) {
            int i = rowIndex + visitNeighbors[k][0];
            int j = colIndex + visitNeighbors[k][1];
            if (isValidIndex(i, j, grid.length, grid[0].length) && grid[i][j] != '0' && !visited[i][j]) {
                traverseIsland(grid, i, j, visitNeighbors);
            }
        }
    }

    private boolean isValidIndex (int rowIndex, int colIndex, int rowLength, int colLength) {
        return rowIndex >= 0 && rowIndex < rowLength && colIndex >= 0 && colIndex < colLength;
    }
}