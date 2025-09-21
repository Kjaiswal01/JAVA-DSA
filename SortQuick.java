public class SortQuick {

    // Partition function: places pivot at correct position and arranges
    // all smaller elements on left and larger on right.
    public static int partition(int arr[], int low, int high){
        // Choose the last element as pivot
        int pivot = arr[high];
        // i marks the boundary of elements smaller than pivot
        int i = low - 1;

        // Traverse from low to high-1
        for(int j = low; j < high; j++){
            // If current element is smaller than pivot
            if(arr[j] < pivot){
                i++; // increment boundary
                // Swap arr[i] and arr[j]
                int temp  = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // After loop ends, place pivot element just after the last smaller element
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        // Return the index of pivot after partitioning
        return i;  // pivot index
    }

    // QuickSort function (recursive)
    public static void quickSort(int arr[], int low, int high){
        // If the subarray has at least 2 elements
        if(low < high){
            // Partition the array, get pivot index
            int pidx = partition(arr, low, high);
            // Recursively sort elements before pivot
            quickSort(arr, low, pidx - 1);
            // Recursively sort elements after pivot
            quickSort(arr, pidx + 1, high);
        }
    }

    public static void main(String args[]){
        int[] arr = {6,3,9,5,2,8,1,2,37,7};
        int n = arr.length;

        // Call quicksort on the entire array
        quickSort(arr, 0, n - 1);

        // Print sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
// Time Complexity (TC):----------------------------------
// Average / Best case: O(n log n)
// Worst case: O(n²)

// Space Complexity (SC):-----------------------------------
// Extra space: O(log n) on average due to recursion stack
// Worst case stack space: O(n)