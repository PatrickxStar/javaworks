package org.example.WritingAlgorithms;

public class BubbleSort {

    public static void bubbleSort(int arr[], int N) {
        // Loop over the array
        for (int i = 0; i < N-1; i++) {
            // Last i elements are already sorted
            for (int j = 0; j < N-i-1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j+1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 1, 3, 9, 7};
        int N = arr.length;

        bubbleSort(arr, N);

        // Print the sorted array
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

