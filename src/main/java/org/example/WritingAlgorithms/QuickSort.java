package org.example.WritingAlgorithms;

public class QuickSort {
        // Function to perform the partitioning step
        public static int partition(int arr[], int low, int high) {
            int pivot = arr[high];  // pivot element is the last element
            int i = (low - 1);  // index of the smaller element

            for (int j = low; j < high; j++) {
                // If the current element is smaller than or equal to the pivot
                if (arr[j] <= pivot) {
                    i++;

                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Swap arr[i+1] and arr[high] (or pivot)
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;  // return the partitioning index
        }

        // Function to implement QuickSort
        public static void quickSort(int arr[], int low, int high) {
            if (low < high) {
                // partitionIndex is the index where the pivot is now located
                int partitionIndex = partition(arr, low, high);

                // Recursively sort elements before and after partition
                quickSort(arr, low, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, high);
            }
        }
    }

