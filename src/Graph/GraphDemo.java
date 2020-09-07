package Graph;


import java.util.*;

public class GraphDemo {
    public static void main(String[] args) {
        String[] vertexs = {"1", "2", "3", "4", "5", "6"};
        Graph graph = new Graph(vertexs.length);
        for (int i = 0; i < vertexs.length; i++) {
            graph.insertVertex(vertexs[i]);
        }
        graph.insertEdge(0, 1, 6);
        graph.insertEdge(0, 3, 5);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 5);
        graph.insertEdge(2, 3, 5);
        graph.insertEdge(1, 4, 3);
        graph.insertEdge(2, 4, 6);
        graph.insertEdge(2, 5, 4);
        graph.insertEdge(3, 5, 2);
        graph.insertEdge(4, 5, 6);
        graph.fill();
        graph.showGraph();
//        int[][] minTree = Prim.createMinTree(graph);
//        for (int i = 0; i < minTree.length; i++) {
//            System.out.println(Arrays.toString(minTree[i]));
//        }
        int[][] array = new int[10][10];
        Kruskal.createMiniSpanTree(graph);
    }

}

class Kruskal {

    public static void createMiniSpanTree(Graph graph) {
        int vertexNum = graph.getVertexNum();
        int[][] arcs = graph.getArcs();
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (arcs[i][j] < 10000) {
                    Edge edge = new Edge(i, j, arcs[i][j]);
                    edges.add(edge);
                }
            }
        }
        Collections.sort(edges);

        int[] ends = new int[vertexNum];    //将所有的顶点有序排列，数组的下标代表顶点的索引，值表示与它相连并且按顺序的排列的下一个顶点
        int m = 0, n = 0;
        for (int i = 0; i < edges.size(); i++) {
            n = findTail(ends, edges.get(i).begin);
            m = findTail(ends, edges.get(i).end);
            if (n != m) {
                ends[n] = m;
                System.out.println("(" + edges.get(i).begin+","+edges.get(i).end+")"+"权值:"+edges.get(i).weight);
            }
        }

    }

    private static int findTail(int[] parent, int n) {
        while (parent[n] > 0) {
            n = parent[n];
        }
        return n;
    }


}

class Edge implements Comparable<Edge> {
    public int begin;
    public int end;
    public int weight;

    public Edge(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "begin=" + begin +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

class Prim {

    public static int[][] createMinTree(Graph graph) {
        int vertexNum = graph.getVertexNum();
        List<Integer> selected = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertexNum()];
        int[][] arcs = graph.getArcs();
        selected.add(0);
        visited[0] = true;

        int[][] minTree = new int[vertexNum][vertexNum];

        for (int i = 0; i < graph.getVertexNum() - 1; i++) {
            int minWeight = 10000;
            int cur = -1;           //当前的顶点
            int next = -1;          //当前节点要连接的下一个顶点
            for (int j = 0; j < selected.size(); j++) {
                for (int k = 0; k < arcs[0].length; k++) {
                    if (visited[k] == false && arcs[selected.get(j)][k] < minWeight) {
                        minWeight = arcs[selected.get(j)][k];
                        cur = selected.get(j);
                        next = k;
                    }
                }
            }
            selected.add(next);
            visited[next] = true;
            minTree[cur][next] = minWeight;
            minTree[next][cur] = minWeight;
        }
        return minTree;
    }
}


class Graph {
    private List<String> vertexs;
    private int[][] arcs;
    private int vertexNum;
    private int arcNum;

    public int[][] getArcs() {
        return arcs;
    }

    public void fill() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                if (arcs[i][j] == 0) {
                    arcs[i][j] = 10000;
                }
            }
        }
    }

    private int maxVexNum;
    private boolean[] visited;

    public Graph(int maxVexNum) {
        this.maxVexNum = maxVexNum;
        arcs = new int[maxVexNum][maxVexNum];
        vertexs = new ArrayList<>();
        vertexNum = 0;
        arcNum = 0;
        visited = new boolean[maxVexNum];
    }

    public void insertVertex(String vertex) {
        vertexs.add(vertex);
        vertexNum++;
    }

    public void showVisited() {
        System.out.println(Arrays.toString(visited));
    }

    public void insertEdge(int v1, int v2, int weight) {
        arcs[v1][v2] = weight;
        arcs[v2][v1] = weight;
        arcNum++;
    }

    private void DFS(int i, boolean[] visitede) {
        int j;
        if (visited[i]) {
            return;
        }
        System.out.println(vertexs.get(i));
        visited[i] = true;
        for (int k = 0; k < vertexs.size(); k++) {
            if (!visitede[k] && arcs[i][k] > 0) {
                DFS(k, visited);
            }
        }
    }

    public void DFS() {
        for (int i = 0; i < vertexs.size(); i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }


    public void BFS() {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexs.size(); i++) {
            if (!visited[i]) {
                System.out.println(vertexs.get(i));
                visited[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int head = queue.poll();
                    for (int j = 0; j < vertexs.size(); j++) {
                        if (!visited[j] && arcs[head][j] > 0) {
                            System.out.println(vertexs.get(j));
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }


    public int getVertexNum() {
        return vertexNum;
    }

    public int getArcNum() {
        return arcNum;
    }

    public String getVertex(int index) {
        return vertexs.get(index);
    }

    public int getWeight(int v1, int v2) {
        return arcs[v1][v2];
    }

    public void showGraph() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                System.out.print(arcs[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
