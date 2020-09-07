package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        long start = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1, new int[array.length]);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }



    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left == right)
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);
        sort(array,left,mid,right,temp);
    }

    public static void sort(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1; 
        int k = 0; 
        while (i <= mid && j <= right){
            if(array[i]<array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while (i <= mid){
            temp[k++] = array[i++];
        }
        while (j<= right){
            temp[k++] = array[j++];
        }
        int tempLeft = left;
        k = 0;
        while (tempLeft <= right){
            array[tempLeft++] = temp[k++];
        }
    }
}
