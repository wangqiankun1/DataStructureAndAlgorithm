package problem;

public class Maze {
    static int k = 1;
    public static void main(String[] args) {
        int[][] map = new int[8][10];
        initWall(map);
        map[5][0] = -1;
        map[5][1] = -1;
        map[5][2] = -1;
        map[4][2] = -1;
        map[3][2] = -1;
        map[2][2] = -1;
//        map[1][6] = -1;
        map[2][6] = -1;
        map[3][6] = -1;
        map[4][6] = -1;
        map[5][6] = -1;
        map[6][6] = -1;
        map[7][6] = -1;
        printMaze(map);
        System.out.println(setWay(map,1,1));
        printMaze(map);
    }

    public static void printMaze(int[][] map){
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void initWall(int[][] map){
        for (int i=0;i<map.length;i++){
            map[i][0] = -1;
            map[i][map[0].length-1] = -1;
        }
        for(int i=0;i<map[0].length;i++){
            map[0][i] = -1;
            map[map.length-1][i] = -1;
        }
    }
    /**
     *  单元格默认值0，-1表示墙不可走，1走了，-2表示走过，但是走不通
     */
    public static boolean setWay(int[][] map,int x,int y) {
        printMaze(map);
        if (map[map.length - 2][map[0].length - 2] > 1) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = k++;
                if (setWay(map, x + 1, y)) {
                    return true;
                } else if (setWay(map, x, y + 1)) {
                    return true;
                } else if (setWay(map, x - 1, y)) {
                    return true;
                } else if (setWay(map, x, y - 1)) {
                    return true;
                } else {
//                    map[x][y] = k++;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
