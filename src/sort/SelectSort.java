package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100000);
        }
        long start = System.currentTimeMillis();
        selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void selectSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    index = j;
                }
            }
            if(min != array[i]){
                temp = array[i];
                array[i] = min;
                array[index] = temp;
            }
        }
    }
}
