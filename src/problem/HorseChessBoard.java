package problem;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HorseChessBoard {
    static boolean finished = false;
    static int x = 0, y = 0;
    static int n = 8;
    static int[][] chessBoard = new int[n][n];

    public static void main(String[] args) {
        boolean[][] visited = new boolean[n][n];
        traversalChessboard(chessBoard, 0, 0, 1, visited, n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }

    public static void traversalChessboard(int[][] chessBoard, int x, int y, int step, boolean[][] visited, int n) {
        visited[x][y] = true;
        chessBoard[x][y] = step;
        ArrayList<Point> points = nexts(new Point(x, y), n);
        sort(points, n);
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visited[point.x][point.y]) {
                traversalChessboard(chessBoard, point.x, point.y, step + 1, visited, n);
            }
        }
        if (step < n * n && !finished) {
            chessBoard[x][y] = 0;
            visited[x][y] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> nexts(Point curPoint, int n) {
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < n && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < n && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < n && (p.y = curPoint.y + 1) < n) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < n && (p.y = curPoint.y + 2) < n) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < n) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 2) < n) {
            points.add(new Point(p));
        }
        return points;
    }

    public static void sort(ArrayList<Point> points, int n) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int p1 = nexts(o1, n).size();
                int p2 = nexts(o2, n).size();
                return p1 - p2;
            }
        });
    }

}

