package sort;

import java.util.Arrays;

public class MergeSort {
    static int[] sorted;
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4, 6, 8, 7};
        sorted = new int[a.length];
        mergeSort(a, 0, 7);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] arr, int first, int last) {
        int mid = (first + last) / 2;

        if (first < mid) {

            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
        }
        mergeSortArr(arr, first, mid, last);

    }

    public static void mergeSortArr(int[] arr, int first, int mid, int last) {

        int left = first;
        int right = mid + 1;
        int idx = first;


        while (left <= mid && right <= last) {
            if (arr[left] <= arr[right]) {
                sorted[idx] = arr[left];
                left++;
                idx++;
            }
            else {
                sorted[idx] = arr[right];
                right++;
                idx++;
            }
        }

        if (left > mid) {
            while (right <= last) {
                sorted[idx] = arr[right];
                right++;
                idx++;
            }
        }

        else {
            while (left <= mid) {
                sorted[idx] = arr[left];
                left++;
                idx++;
            }
        }

        for (int i = first; i <= last; i++) {
            arr[i] = sorted[i];
        }
    }
}
