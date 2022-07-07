package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 2, 4};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

    }
//    public static void selectionSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = arr[i];
//            int temp = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (min > arr[j]) {
//                    min = arr[j];
//                    temp = j;
//                }
//            }
//            arr[temp] = arr[i];
//            arr[i] = min;
//        }
//
//    }
}
