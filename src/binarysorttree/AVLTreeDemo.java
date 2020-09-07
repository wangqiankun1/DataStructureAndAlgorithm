package binarysorttree;

public class AVLTreeDemo {
}

class AVLNode {
    public int value;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}