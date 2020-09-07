package binarysorttree;

import java.util.TreeSet;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] array = {1,1,1,1,1,1};
        BinarySortTree binarySortTree = new BinarySortTree(new SortNode(7));
        for (int i = 1; i < array.length; i++) {
            binarySortTree.addSortNode(new SortNode(array[i]));
        }
//        binarySortTree.infixOrder();
//        SortNode node = binarySortTree.findNode(1);
//        System.out.println(node);
//        SortNode parent = binarySortTree.findParent(10);
//        System.out.println(parent);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private SortNode root;

    public BinarySortTree(SortNode root) {
        this.root = root;
    }

    public void addSortNode(SortNode node) {
        if (root == null) {
            return;
        }
        root.add(node);
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public SortNode findNode(int value) {
        if (root != null) {
            return root.findSortNode(value);
        }
        return null;
    }

    public SortNode findParent(int value) {
        if (root != null) {
            return root.findParent(value);
        }
        return null;
    }

    public SortNode deleteSortNode(int value) {
        if (root != null) {
            return root.deleteSortNode(value);
        }
        return null;
    }


}

class SortNode {
    public int value;
    public SortNode left;
    public SortNode right;

    public SortNode(int value) {
        this.value = value;
    }

    public int getLeftHeight() {
        if (this.left != null) {
            return this.left.height();
        }
        return -1;
    }

    public int getRightHeight() {
        if (this.right != null) {
            return this.right.height();
        }
        return -1;
    }

    public int getHeight() {
        return this.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate() {
        SortNode newNode = new SortNode(value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;
    }

    public SortNode deleteSortNode(int value) {

        SortNode deleteNode = findSortNode(value);
        if (deleteNode == null) {
            return null;
        }
        SortNode parent = findParent(value);
        if (parent == null) {
            SortNode leftMaxNode = findLeftMaxNode(deleteNode);
            SortNode leftMaxNodeParent = findParent(leftMaxNode.value);
            if (leftMaxNodeParent.right == leftMaxNode) {
                leftMaxNodeParent.right = null;
            } else {
                leftMaxNodeParent.left = null;
            }
            SortNode temp = new SortNode(deleteNode.value);
            deleteNode.value = leftMaxNode.value;
            return temp;
        }

        if (deleteNode.left == null && deleteNode.right == null) {
            if (parent.left == deleteNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return deleteNode;
        }

        if (parent.left == deleteNode && (deleteNode.left == null ^ deleteNode.right == null)) {
            if (deleteNode.left == null) {
                parent.left = deleteNode.right;
            } else {
                parent.left = deleteNode.left;
            }
            return deleteNode;
        }

        if (parent.right == deleteNode && (deleteNode.left == null ^ deleteNode.right == null)) {
            if (deleteNode.left == null) {
                parent.right = deleteNode.right;
            } else {
                parent.right = deleteNode.left;
            }
            return deleteNode;
        }

        if (deleteNode.left != null && deleteNode.right != null) {
            SortNode leftMaxNode = findLeftMaxNode(deleteNode);
            SortNode leftMaxNodeParent = findParent(leftMaxNode.value);
            if (leftMaxNodeParent.right == leftMaxNode) {
                leftMaxNodeParent.right = null;
            } else {
                leftMaxNodeParent.left = null;
            }
            SortNode temp = new SortNode(deleteNode.value);
            deleteNode.value = leftMaxNode.value;
            return temp;
        }

        return deleteNode;
    }

    private SortNode findLeftMaxNode(SortNode deleteNode) {
        if (deleteNode != null) {
            SortNode maxNode = deleteNode.left;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
            return maxNode;
        }
        return null;
    }

    private SortNode findRightMinNode(SortNode deleteNode) {
        if (deleteNode != null) {
            SortNode minNode = deleteNode.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            return minNode;
        }
        return null;
    }

    public SortNode findParent(int value) {
        if (this.left != null && this.left.value == value) {
            return this;
        }
        if (this.right != null && this.right.value == value) {
            return this;
        }
        SortNode parent;
        if (this.left != null) {
            parent = this.left.findParent(value);
            if (parent != null) {
                return parent;
            }
        }
        if (this.right != null) {
            parent = this.right.findParent(value);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }

    public SortNode findSortNode(int value) {
        if (this.value == value) {
            return this;
        }
        SortNode node;
        if (this.left != null) {
            node = this.left.findSortNode(value);
            if (node != null) {
                return node;
            }
        }
        if (this.right != null) {
            node = this.right.findSortNode(value);
            if (node != null) {
                return node;
            }
        }
        return null;
    }


    public void add(SortNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if (getRightHeight() - getLeftHeight() > 1) {
            if (right != null && right.getLeftHeight() > right.getRightHeight()) {
                this.rlRotate();
            } else {
                this.rrRotate();
            }
            return;
        }
        if (getLeftHeight() - getRightHeight() > 1) {
            if (left != null && left.getRightHeight() > left.getLeftHeight()) {
                this.lrRotate();
            } else {
                this.llRotate();
            }
        }
    }

    private void llRotate() {
        SortNode node = new SortNode(value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = node;
    }

    private void rrRotate() {
        SortNode node = new SortNode(value);
        node.left = this.left;
        node.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = node;
    }

    private void lrRotate() {
        this.left.rrRotate();
        this.llRotate();
    }

    private void rlRotate() {
        this.right.llRotate();
        this.rrRotate();
        ;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}