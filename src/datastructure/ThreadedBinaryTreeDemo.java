package datastructure;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedTreeNode root = new ThreadedTreeNode(123, "王乾坤");
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        ThreadedTreeNode liu = new ThreadedTreeNode(243, "刘叶");
        root.left = liu;
        ThreadedTreeNode wen = new ThreadedTreeNode(312, "温馨");
        root.right = wen;
        ThreadedTreeNode zhang = new ThreadedTreeNode(151, "张金龙");
        liu.left = zhang;
        ThreadedTreeNode xian = new ThreadedTreeNode(152, "咸鱼");
        liu.right = xian;
        threadedBinaryTree.threadedNodes(root);
        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree {
    private ThreadedTreeNode root;
    private ThreadedTreeNode pre = null;

    public ThreadedBinaryTree(ThreadedTreeNode root) {
        this.root = root;
    }

    public void setRoot(ThreadedTreeNode root) {
        this.root = root;
    }

    public void threadedList() {
        ThreadedTreeNode node = root;
        while (node != null) {
            while (node.LTag == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.RTag == 1){
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    public void threaadedNodes() {
        threadedNodes(this.root);
    }

    public void threadedNodes(ThreadedTreeNode node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.left); //中序线索化，执行完后然后线索当前节点，也是子树的根节点
        if (node.left == null) {
            node.left = pre;
            node.LTag = 1;
        }
        if (pre != null && pre.right == null) {  //让前驱节点的右指针指向当前节点
            pre.right = node;
            pre.RTag = 1;
        }
        pre = node;
        threadedNodes(node.right);
    }
}

class ThreadedTreeNode {
    public int no;
    public String str;
    public ThreadedTreeNode left;
    public ThreadedTreeNode right;
    public int LTag;
    public int RTag;

    public ThreadedTreeNode(int no, String str) {
        this.no = no;
        this.str = str;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
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

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public ThreadedTreeNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        ThreadedTreeNode findNode = null;
        if (this.left != null) {
            findNode = this.left.preOrderSearch(no);
        }
        if (findNode != null) {
            return findNode;
        }
        if (this.right != null) {
            findNode = this.right.preOrderSearch(no);
        }
        return findNode;
    }

    public ThreadedTreeNode infixOrderSearch(int no) {
        ThreadedTreeNode findNode = null;
        if (this.left != null) {
            findNode = this.left.infixOrderSearch(no);
        }
        if (findNode != null) {
            return findNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            findNode = this.right.infixOrderSearch(no);
        }
        return findNode;
    }

    public ThreadedTreeNode postOrderSearch(int no) {
        ThreadedTreeNode findNode = null;
        if (this.left != null) {
            findNode = this.left.postOrderSearch(no);
        }
        if (findNode != null) {
            return findNode;
        }
        if (this.right != null) {
            findNode = this.right.postOrderSearch(no);
        }
        if (findNode != null) {
            return findNode;
        }
        if (this.no == no) {
            return this;
        }
        return findNode;
    }

    public ThreadedTreeNode deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            ThreadedTreeNode deleteNode = this.left;
            this.left = null;
            return deleteNode;
        }
        if (this.right != null && this.right.no == no) {
            ThreadedTreeNode deleteNode = this.right;
            this.right = null;
            return deleteNode;
        }
        if (this.left != null) {
            return this.left.deleteNode(no);
        }
        if (this.right != null) {
            return this.right.deleteNode(no);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ThreadedTreeNode{" +
                "no=" + no +
                ", str='" + str + '\'' +
                '}';
    }
}