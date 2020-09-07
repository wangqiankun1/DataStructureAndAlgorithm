package algorithm;

import java.util.Arrays;

public class DijkstraDemo {

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertexs.length][vertexs.length];
        final int N = 65535;// 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        Graph graph = new Graph(vertexs, matrix);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%6d", matrix[i][j]);
            }
            System.out.println();
        }

        graph.dijkstra(2);
    }

}

class Graph {
    public char[] vertexs;
    public int[][] matrix;
    public VisitedVertex visitedVertex;

    public Graph(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
    }

    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertexs.length, index);
        update(index);
        for (int i = 0; i < vertexs.length; i++) {
            index = visitedVertex.updateVisited();
            update(index);
        }
        System.out.println(Arrays.toString(visitedVertex.disstance));
    }

    private void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = visitedVertex.getDisstance(index) + matrix[index][i];
            if (!visitedVertex.isVisited(i) && len < visitedVertex.getDisstance(i)) {
                visitedVertex.updatePre(i, index);
                visitedVertex.updateDis(i, len);
            }
        }
    }

}

class VisitedVertex {
    public boolean[] visited;
    public int[] preVisited;
    public int[] disstance;

    public VisitedVertex(int n, int index) {
        this.visited = new boolean[n];
        this.preVisited = new int[n];
        this.disstance = new int[n];
        Arrays.fill(disstance, 65535);
        this.visited[index] = true;
        this.disstance[index] = 0;
    }

    public boolean isVisited(int index) {
        return visited[index];
    }

    public int getDisstance(int index) {
        return disstance[index];
    }

    public void updatePre(int pre, int index) {
        preVisited[pre] = index;
    }

    public void updateDis(int index, int len) {
        disstance[index] = len;
    }

    public int updateVisited() {
        int min = 65535, index = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false && disstance[i] < min) {
                min = disstance[i];
                index = i;
            }
        }
        visited[index] = true;
        return index;
    }
}
