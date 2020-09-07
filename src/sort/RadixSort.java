package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long start = System.currentTimeMillis();
        radixSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }

    public static void radixSort(int[] array) {
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        int length = (maxValue + "").length();
        int[][] buckets = new int[10][array.length];
        int[] bucketElemCounts = new int[10];
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                int k = array[j] / n % 10;
                buckets[k][bucketElemCounts[k]++] = array[j];
            }
            int index = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (int k = 0; k < bucketElemCounts[j]; k++) {
                    array[index++] = buckets[j][k];
                }
                bucketElemCounts[j] = 0;
            }
        }

    }
}
