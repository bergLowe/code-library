public class KadaneAlgorithm_2D_Rectangle {
    // start and end is to keep track of 
    // changes in top and bottom points.
    static int start;
    static int end;

    public static void main(String[] args) {
        int [][]matrix = {
            {6, -5, -7, 4, -4},
            {-9, 3, -6, 5, 2},
            {-10, 4, 7, -6, 3},
            {-8, 9, -3, 3, -7}
        };

        int maximumSum = maxSumRectangle(matrix);
        System.out.println("Maximum Sum Rectangle is: " + maximumSum);
    }

    static int maxSumRectangle(int [][]matrix) {
        int finalTop = -1,
            finalBottom = -1,
            finalLeft = -1,
            finalRight = -1,
            maxSum = Integer.MIN_VALUE,
            rowLength = matrix.length,
            colLength = matrix[0].length,
            sum;

        // colSums store the column sums when added with other columns
        // between left and right.
        int []colSums;

        for (int left = 0; left < colLength; left++) {
            // Initializing array whenever left column changes.
            // As right will travel to the end.
            colSums = new int[rowLength];

            for (int right = left; right < colLength; right++) {
                for (int i = 0; i < rowLength; i++) {
                    colSums[i] += matrix[i][right];
                }

                sum = kadane_maxSubarraySum(colSums);

                if (sum > maxSum) {
                    finalTop = start;
                    finalLeft = left;
                    finalBottom = end;
                    finalRight = right;
                    maxSum = sum;
                }
            }
        }

        System.out.println("(Top, Left) : (" + finalTop + ", " + finalLeft + ")");
        System.out.println("(Bottom, Right) : (" + finalBottom + ", " + finalRight + ")");

        return maxSum;
    }

    static int kadane_maxSubarraySum(int []arr) {
        int maxSum = Integer.MIN_VALUE,
            tempStart = 0,
            sum = 0;
        
        end = -1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                tempStart = i + 1;
            } else if (sum > maxSum) {
                maxSum = sum;
                start = tempStart;
                end = i;
            }
        }

        if (end != -1) {
            return maxSum;
        }

        maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxSum) {
                maxSum = arr[i];
                start = end = i;
            }
        }
        return maxSum;
    }
}
