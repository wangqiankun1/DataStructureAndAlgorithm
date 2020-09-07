package algorithm;


import java.util.Arrays;

public class KMPSearch {
    public static void main(String[] args) {
        String str = "ABAAaBABAAABABAA";
        String str2 = "ababaaababaa";
        String s = "ABABAAABABAA";
        int[] next = getNext1(str2);
        int[] next2 =getNext2(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(next2));
//        int i = KMPSearch(str, s);
//        System.out.println(i);
    }

    /**
     * @param S 主串
     * @param T 模式串
     * @return
     */
    public static int BFSearch(String S, String T) {

        int i = 0; // 主串索引
        int j = 0; // 模式串索引
        while (i < S.length() && j < T.length()) {
            if (S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == T.length()) {
            return i - j;
        }
        return -1;
    }

    public static int KMPSearch(String S, String T) {
        int i = 0;
        int j = 0;
        int[] next = getNext1(T);
        while (i < S.length() && j < T.length()) {
            if (j == 0 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j] - 1;
            }
        }
        if (j == T.length()) {
            return i - j;
        }
        return -1;
    }

    public static int[] getNext1(String T) {
        int i = 1;
        int j = 0;
        int[] next = new int[T.length() + 1];
        next[1] = 0;
        while (i < T.length()) {
            if (j == 0 || T.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int[] getNext2(String T) {
        int[] next = new int[T.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != T.charAt(j)) {
                j = next[j - 1];
            }
            if (T.charAt(i) == T.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
