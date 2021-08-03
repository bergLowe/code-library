// https://www.hackerrank.com/challenges/largest-rectangle/problem

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Max_Rectangular_Area_Histogram {
    public static long largestRectangle(List<Integer> heightsArr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = -1;
        int area, i;

        for (i = 0; i < heightsArr.size(); ) {
            if (stack.isEmpty() || heightsArr.get(stack.peekFirst()) <= heightsArr.get(i)) {
                stack.offerFirst(i);
                i++;
            } else {
                int topIndex = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = heightsArr.get(topIndex) * i;
                } else {
                    area = heightsArr.get(topIndex) * (i - stack.peekFirst() - 1);
                }
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int topIndex = stack.pollFirst();
            if (stack.isEmpty()) {
                area = heightsArr.get(topIndex) * i;
            } else {
                area = heightsArr.get(topIndex) * (i - stack.peekFirst() - 1);
            }
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}