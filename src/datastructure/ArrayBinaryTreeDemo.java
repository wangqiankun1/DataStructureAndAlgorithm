package datastructure;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 3, 1, 8};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
//        tree.preOrder(0);
//        tree.infixOrder(0);;
        tree.postOrder(0);
    }

}

class ArrayBinaryTree {
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder(int i) {
        if (array.length == 0 || array == null) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(array[i]);
        if ((i * 2 + 1) < array.length) {
            preOrder(i * 2 + 1);
        }
        if ((i * 2 + 2) < array.length) {
            preOrder(i * 2 + 2);
        }
    }

    public void infixOrder(int i) {
        if (array.length == 0 || array == null) {
            System.out.println("数组为空");
            return;
        }
        if ((i * 2 + 1) < array.length) {
            infixOrder(i * 2 + 1);
        }
        System.out.println(array[i]);
        if ((i * 2 + 2) < array.length) {
            infixOrder(i * 2 + 2);
        }
    }

    public void postOrder(int i){
        if (array.length == 0 || array == null) {
            System.out.println("数组为空");
            return;
        }
        if ((i * 2 + 1) < array.length) {
            postOrder(i * 2 + 1);
        }
        if ((i * 2 + 2) < array.length) {
            postOrder(i * 2 + 2);
        }
        System.out.println(array[i]);
    }
}