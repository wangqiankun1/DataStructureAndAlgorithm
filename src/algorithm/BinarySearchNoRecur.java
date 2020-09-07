package algorithm;

import java.util.Arrays;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] array = {1,3,5,7,8,11,16,18,19,25};
        int i = binarySearch(array, 10);
        System.out.println(i);
    }

    public static int binarySearch(int[] array, int search) {
        int low = 0;
        int hight = array.length - 1;
        int mid = 0;
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (array[mid] == search) {
                return mid;
            } else if (array[mid] > search) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
