package sort;

import nonLinearStructure.tree.Heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4, 6, 9, 8, 7};
        HeapSort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void HeapSort(int[] arr) {
        Heap heap = new Heap();

        for (int a : arr) {
            heap.add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.remove();
        }
    }
}
