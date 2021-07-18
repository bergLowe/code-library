/*
Rotate Matrix by 90 degrees inplace.
We perform circular rotation on each layer, moving the top edge to the right edge, the right edge to
the bottom edge, the bottom edge to the left edge and the left edge to the top edge.
*/
public class Rotate_Matrix_90 {
    public void rotateMatrix (int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return ;
        
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;

            }
        }
        for (int []a: matrix) {
            for (int b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
