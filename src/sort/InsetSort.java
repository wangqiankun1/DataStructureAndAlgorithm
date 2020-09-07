package sort;

public class InsetSort {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100000);
        }
        long start = System.currentTimeMillis();
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertSort(int[] array){
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            int currnValue = array[i];
            int insetIndex = i - 1;
            while (insetIndex >= 0 && currnValue < array[insetIndex]){
                array[insetIndex+1] = array[insetIndex];
                insetIndex--;
            }
            if(insetIndex +1 != i){
                array[insetIndex+1] = currnValue;
            }
        }
    }
}
