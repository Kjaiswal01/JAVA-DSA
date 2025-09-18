class Sorting {
    // Utility method to print the elements of an array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // print each element with space
        }
        System.out.println();  // new line at the end
    }

    public static void main(String args[]) {
        // Original array to be sorted
        int arr[] = {72,6,5,99,75,23};

        // ------------------ Bubble Sort ------------------
        // Bubble Sort compares adjacent elements and swaps them if they are out of order.
        // After each full pass, the largest element "bubbles up" to its correct position at the end.
        for (int i = 0; i < arr.length - 1; i++) {    // Outer loop runs n-1 times
            for (int j = 0; j < arr.length - i - 1; j++) { // Inner loop avoids last sorted elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // ------------------ Insertion Sort ------------------
        // Insertion Sort builds a sorted portion of the array one element at a time.
        // It picks the next element and inserts it into the correct position of the already sorted part.
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];   // current element to insert into the sorted part
            int j = i - 1;          // index of last element of the sorted part
            // shift elements greater than 'current' one position to the right
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // place 'current' at its correct position
            arr[j + 1] = current;
        }

        // ------------------ Selection Sort ------------------
        // Selection Sort repeatedly finds the smallest element from the unsorted part
        // and puts it at the beginning.
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;   // index of the smallest element
            // find the index of the smallest element in the remaining unsorted array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            // swap the smallest element with the first element of the unsorted part
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        // Print the sorted array after all sorting algorithms
        printArray(arr);
    }
}
