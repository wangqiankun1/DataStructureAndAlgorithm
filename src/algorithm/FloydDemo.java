package algorithm;

import java.util.Arrays;

public class FloydDemo {
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertexs.length][vertexs.length];
        final int N = 65535;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        for (int i = 0; i < vertexs.length; i++) {
            matrix[i][i] = 0;
        }
        for (int i = 0; i < vertexs.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        FloydGraph graph = new FloydGraph(vertexs, matrix);
        int[][] folyd = graph.folyd();
        for (int i = 0; i < vertexs.length; i++) {
            System.out.println(Arrays.toString(folyd[i]));
        }
        System.out.println();
        graph.printPre();
    }

}

class FloydGraph {
    public char[] vertexs;
    public int[][] matrix;
    public int[][] pre;

    public FloydGraph(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        pre = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public int[][] folyd() {
        /**
         * 深拷贝，保证原始数据不被修改
         */
        int[][] distances = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            distances[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        int length = vertexs.length;
        int d = 0;
        for (int i = 0; i < length; i++) {  //中间节点
            for (int j = 0; j < length; j++) { // 起点
                for (int k = 0; k < length; k++) { // 终点
                    d = distances[j][i] + distances[i][k];
                    if (d < distances[j][k]) {
                        distances[j][k] = d;
                        pre[j][k] = pre[i][k];
                    }
                }
            }
        }
        return distances;
    }

    public void printPre() {
        for (int i = 0; i < vertexs.length; i++) {
            System.out.println(Arrays.toString(pre[i]));
        }
    }
}
