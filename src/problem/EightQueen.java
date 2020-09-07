package problem;

public class EightQueen {
    static int result = 0;
    static int[] array;
    public static int totalNQueens(int n) {
        array = new int[n];
        put(0,n);
        return result;
    }
    public static void put(int x,int n){
        if (x == n ){
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            array[x] = i;
            if(!isConflict(x)){
                put(x+1,n);
            }
        }
    }

    public static boolean isConflict(int x){ //y是改行的第
        if(x == 0)
            return false;
        for (int i = 0; i < x; i++) {
            if(array[i] == array[x] ||Math.abs(array[x]-array[i]) == Math.abs(x-i)){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }
}
