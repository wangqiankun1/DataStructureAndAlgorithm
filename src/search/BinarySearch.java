package search;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 3, 4, 96, 13,15, 32, 65, 13,5,5,96};
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int)(Math.random()*10);
//        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        ArrayList<Integer> arrayList = binarySearch(array, 0, array.length - 1, 5);
        System.out.println(arrayList.toString());
    }

    public static ArrayList<Integer> binarySearch(int[] array, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right)
            return new ArrayList<Integer>();
        if (findVal == array[mid]) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(mid);
            int l = mid - 1;
            int r = mid + 1;
            while (l >= 0 && array[l] == findVal) {
                arrayList.add(l++);
            }
            while (r <= array.length - 1 && array[r] == findVal) {
                arrayList.add(r++);
            }
            return arrayList;

        } else if (findVal > array[mid]) {
            return binarySearch(array, mid + 1, right, findVal);
        } else {
            return binarySearch(array, left, mid - 1, findVal);
        }
    }
}
