package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4, 6, 9, 8, 7};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void InsertionSort(int[] arr) {

        int i, j;
        int target;

        for (i = 1; i < arr.length; i++) {
            target = arr[i];

            for (j = i - 1; j >= 0; j--) {

                if (arr[j] > target) {
                    arr[j + 1] = arr[j];
                }
                else {
                    break;
                }
            }

            arr[j + 1] = target;
        }

//        for (int i = 0; i < arr.length - 1; i++) {
//            int target = arr[i + 1];
//
//            for (int j = 0; j < i + 1; j++) {
//
//                if (arr[j] > target) {
//
//                    for (int k = i + 1; k > j; k--) {
//                        arr[k] = arr[k - 1];
//                    }
//
//                    arr[j] = target;
//                    break;
//                }
//
//            }
//        }
    }
}
