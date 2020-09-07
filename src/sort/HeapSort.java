package sort;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        int temp = 0;
        for (int i = array.length - 1; i > 0; i--) {
            temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i);
        }
    }

    public static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && array[j] < array[j + 1]) {
                j++;
            }
            if (temp < array[j]) {
                array[i] = array[j];
                i = j;
            } else {
                break;
            }
        }
        array[i] = temp;
    }
}
