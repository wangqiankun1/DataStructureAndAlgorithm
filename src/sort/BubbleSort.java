package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void bubbleSort(int[] array){
        int temp = 0;
//        boolean flag = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                if(array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
//                    flag = true;
                }
            }
//            if(!flag)
//                break;
//            else {
//                flag = false;
//            }
        }
    }
}
