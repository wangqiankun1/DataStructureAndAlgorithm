package datastructure;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(123, "王乾坤");
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode liu = new TreeNode(243, "刘叶");
        root.left = liu;
        TreeNode wen = new TreeNode(312, "温馨");
        root.right = wen;
        TreeNode zhang = new TreeNode(151, "张金龙");
        liu.left = zhang;
        TreeNode xian = new TreeNode(152, "咸鱼");
        liu.right = xian;
//        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
//        TreeNode node = binaryTree.preOrderSerach(243);
//        TreeNode node = binaryTree.infixOrderSearch(111);
//        TreeNode node = binaryTree.postOrderSearch(111);
        TreeNode node = binaryTree.deleteTreeNode(152);
        System.out.println(node);
        System.out.println("删除之后");
        binaryTree.infixOrder();

    }


}

class BinaryTree {
    TreeNode root = null;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }
        return null;
    }

    public TreeNode infixOrderSearch(int no) {
        if (root != null) {
            return this.root.infixOrderSearch(no);
        }
        return null;
    }

    public TreeNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        }
        return null;
    }

    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public TreeNode deleteTreeNode(int no){
        if(this.root.no == no){
            TreeNode deleteNode = root;
            root = null;
            return deleteNode;
        }else {
            return root.deleteNode(no);
        }
    }

}

class TreeNode {
    public int no;
    public String str;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int no, String str) {
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

    public TreeNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        TreeNode findNode = null;
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

    public TreeNode infixOrderSearch(int no) {
        TreeNode findNode = null;
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

    public TreeNode postOrderSearch(int no) {
        TreeNode findNode = null;
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

    public TreeNode deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            TreeNode deleteNode = this.left;
            this.left = null;
            return deleteNode;
        }
        if (this.right != null && this.right.no == no) {
            TreeNode deleteNode = this.right;
            this.right = null;
            return deleteNode;
        }
        if (this.left != null){
            return this.left.deleteNode(no);
        }
        if (this.right != null){
            return this.right.deleteNode(no);
        }
        return null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", str='" + str + '\'' +
                '}';
    }
}