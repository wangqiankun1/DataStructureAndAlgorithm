package algorithm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(4, 'A', 'B', 'C');
    }


    public static void hanoiTower(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
        } else {
            hanoiTower(n - 1, A, C, B);
            System.out.println(A + "->" + C);
            hanoiTower(n - 1, B, A, C);
        }
    }

}

