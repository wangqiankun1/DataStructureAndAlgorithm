package search;

import java.util.*;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 3, 4, 96, 13, 15, 32, 65, 13, 5, 5, 96};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        ArrayList<Integer> arrayList = insertValueSearch(array, 0, array.length - 1, 96);
        System.out.println(arrayList.toString());
    }

    public static ArrayList<Integer> insertValueSearch(int[] array, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);
        if (array[mid] == findValue) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(mid);
            int l = mid - 1;
            int r = mid + 1;
            while (l >= 0 && array[l] == findValue) {
                arrayList.add(l--);
            }
            while (r < array.length && array[r] == findValue) {
                arrayList.add(r++);
            }
            return arrayList;
        } else if (array[mid] > findValue) {
            return insertValueSearch(array, left, mid - 1, findValue);
        } else {
            return insertValueSearch(array, mid + 1, right, findValue);
        }
    }
}
