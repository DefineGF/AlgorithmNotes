package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = {4, 4, 3, 3, 8, 32};
        new QuickSort1().sort(data,0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static class QuickSort1 {
        public void sort(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int p = arr[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && arr[j] >= p) {
                    j--;
                }
                while (i < j && arr[i] <= p) {
                    i++;
                }
                swap(arr, i, j);
            }
            // i == j
            arr[start] = arr[i];
            arr[i] = p;
            sort(arr, start, j - 1);
            sort(arr, j + 1, end);
        }

    }
}
