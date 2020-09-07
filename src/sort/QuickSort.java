package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }


//    public static void quickSort(int[] array, int low, int high) {
//        if (low >= high ) {
//            return;
//        }
//        int l = low;
//        int h = high;
//        int pivotValue = array[low];
//
//        while (l < h) {
//            while (h > l && array[h] >= pivotValue) {
//                h--;
//            }
//            array[l] = array[h];
//            while (l < h && array[l] < pivotValue) {
//                l++;
//            }
//            array[h] = array[l];
//        }
//        array[l] = pivotValue;
//        quickSort(array, low, h - 1);
//        quickSort(array, l + 1, high);
//    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low;
        int h = high;
        int pivotValue = array[low];
        while (l < h) {
            while (h > l && array[h] >= pivotValue) {
                h--;
            }
            array[l] = array[h];
            while (l < h && array[l] < pivotValue) {
                l++;
            }
            array[h] = array[l];
        }
        array[l] = pivotValue;
        quickSort(array, low, h - 1);
        quickSort(array, l + 1, high);
    }
}
