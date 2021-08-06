// https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MyPair {
    public int rowIndex;
    public int colIndex;

    public MyPair () {
        this.rowIndex = this.colIndex = -1;
    }

    public MyPair (int i, int j) {
        this.rowIndex = i;
        this.colIndex = j;
    }    
}

class Solution {
    public boolean is_Possible(int[][] grid) {
        // grid contains:
        // 0 -> Wall
        // 1 -> Source
        // 2 -> Destination
        // 3 -> Empty Cell / Path

        Deque<MyPair> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        MyPair start = null;
        List<MyPair> pairs = new ArrayList<>(){{
            add(new MyPair(-1, 0)); // Top
            add(new MyPair(1, 0));  // Bottom
            add(new MyPair(0, -1)); // Left
            add(new MyPair(0, 1));  // Right
        }};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start = new MyPair(i, j);
                    break;
                }
            }
            if (start != null) break;
        }

        if (start == null) return false;
        q.offerLast(start);
        visited[start.rowIndex][start.colIndex] = true;

        while (!q.isEmpty()) {
            MyPair curr = q.pollFirst();

            for (int i = 0; i < pairs.size(); i++) {
                int rowIndex = curr.rowIndex + pairs.get(i).rowIndex;
                int colIndex = curr.colIndex + pairs.get(i).colIndex;
            
                if (isValidIndex(rowIndex, colIndex, grid.length, grid[0].length) &&
                    !visited[rowIndex][colIndex] &&
                    grid[rowIndex][colIndex] != 0) {

                        if (grid[rowIndex][colIndex] == 2) return true;
                        q.offerLast(new MyPair(rowIndex, colIndex));
                        visited[rowIndex][colIndex] = true;
                
                }
            }
        }

        return false;
    }

    private boolean isValidIndex (int i, int j, int rowSize, int colSize) {
        return i >= 0 && i < rowSize && j >= 0 && j < colSize;
    }
}