public class SortMerge {

    // 🟩 Divide: Split the array into halves
    public static void divide(int arr[], int si, int ei) {
        // base case: only one element
        if (si >= ei) {
            return;
        }

        // find mid safely to avoid overflow
        int mid = si + (ei - si) / 2;

        // recursively divide left part
        divide(arr, si, mid);

        // recursively divide right part
        divide(arr, mid + 1, ei);

        // merge sorted halves
        conquer(arr, si, mid, ei);
    }

    // 🟩 Conquer: Merge two sorted subarrays
    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];

        int idx1 = si;       // pointer for left half
        int idx2 = mid + 1;  // pointer for right half
        int x = 0;           // index for merged array

        // merge until one subarray finishes
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        // copy remaining elements from left half
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // copy remaining elements from right half
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // copy merged array back to original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        // call merge sort
        divide(arr, 0, n - 1);

        // print sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
