public class Largest_SecondLargest {

    // Time Complexity: O(n)
    static void largestAndSecondLargest (int[] arr) {
        int largest = Integer.MIN_VALUE, 
            secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                secondLargest = largest;
                largest = arr[i];
            } else if (secondLargest < arr[i]) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Largest: " + largest + " | Second Largest: " + secondLargest);
    }
}
