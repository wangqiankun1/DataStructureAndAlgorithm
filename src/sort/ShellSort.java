package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        long start = System.currentTimeMillis();
        shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }

//    public static void shellSort(int[] array) {
//        int temp = 0;
//        for (int step = array.length / 2; step > 0; step /= 2) {
//            for (int i = step; i < array.length; i++) {
//                for (int j = i - step; j >= 0; j -= step) {
//                    if (array[j] > array[j + step]) {
//                        temp = array[j];
//                        array[j] = array[j + step];
//                        array[j + step] = temp;
//                    }
//                }
//
//            }
//        }
//    }

    //    public static void shellSort(int[] array) {
//        int temp = 0;
//
//        System.out.println(Arrays.toString(array));
//
//        for (int step = array.length; step > 0; step /= 2) {
//            for (int i = step; i < array.length; i++) {
//                temp = array[i];
//                int j = i - step;
//                while (j >= 0 && temp < array[j]) {
//                    array[j + step] = array[j];
//                    j -= step;
//                }
//                array[j + step] = temp;
//                System.out.println(Arrays.toString(array));
//            }
//        }
//
//    }
    public static void shellSort(int[] array) {
        int temp = 0;
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                temp = array[i];
                int j = i - step;
                while (j >= 0 && temp < array[j]) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = temp;
            }

        }
    }
}
