package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 7, 9, 11};
        int index = fibonacciSearch(array, 10);
        System.out.println(index);
    }

    public static int[] getFib(int arrayLength) {
        int[] f = new int[arrayLength];
        f[0] = 1;
        f[1] = 1;
        int i = 2;
        while (i < arrayLength) {
            f[i] = f[i - 2] + f[i - 1];
            i++;
        }
        return f;
    }


    public static int fibonacciSearch(int[] array, int value) {
        int f[] = getFib(array.length);
        int high = array.length - 1;
        int k = 0;
        while (f[k] - 1 < high) {
            k++;
        }
        int[] temp = Arrays.copyOf(array, f[k]);
        for (int i = high + 1; i < f[k]; i++) {
            temp[i] = temp[high];
        }
        int low = 0;
        int mid = 0;
        while (low <= high) {
            mid = low + f[k    - 1] - 1;
            if (temp[mid] > value) {
                high = mid - 1;
                k--;
            } else if (temp[mid] < value) {
                low = mid + 1;
                k -= 2;
            } else {
                if (high > mid) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
