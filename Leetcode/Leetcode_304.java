class NumMatrix {
    int [][]matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0, i, j;

        for (i = row1; i <= row2; i++) {
            for (j = col1; j <= col2; j++) {
                sum += this.matrix[i][j];
            }
        }
        return sum;
    }
}