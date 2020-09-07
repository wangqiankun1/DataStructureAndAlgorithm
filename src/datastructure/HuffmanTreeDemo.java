package datastructure;

import java.util.*;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        List<HuffmanNode> nodes = new ArrayList<>();
        nodes.add(new HuffmanNode("a", 7));
        nodes.add(new HuffmanNode("b", 5));
        nodes.add(new HuffmanNode("c", 2));
        nodes.add(new HuffmanNode("d", 4));
        nodes.add(new HuffmanNode("e",10));
        nodes.add(new HuffmanNode("f",24));
        nodes.add(new HuffmanNode("g",3));
        nodes.add(new HuffmanNode("h",20));
        nodes.add(new HuffmanNode("i",14));
        nodes.add(new HuffmanNode("j",18));

        HuffmanNode huffmanNodeRoot = HuffmanTree.createHuffmanTree(nodes);
//        HuffmanTree.infixOrder(huffmanNodeRoot);

        Map<String, String> huffmanCodes = HuffmanTree.getHuffmanCodes(huffmanNodeRoot);

    }
}

class HuffmanTree {

    public static Map<String, String> huffmanCodes;

    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        List<HuffmanNode> tempNodes = nodes;

        while (tempNodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanNode left = tempNodes.remove(0);
            HuffmanNode right = tempNodes.remove(0);
            HuffmanNode parent = new HuffmanNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            tempNodes.add(parent);
        }
        return tempNodes.get(0);
    }

    public static void infixOrder(HuffmanNode root) {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("Huffman树为空");
        }
    }

    public static Map<String, String> getHuffmanCodes(HuffmanNode root) {
        if (root == null) {
            System.out.println("Huffman树空");
            return null;
        }
        huffmanCodes = new HashMap<>();
        HuffmanCode(root.left, "0", new StringBuilder());
        HuffmanCode(root.right, "1", new StringBuilder());
        return huffmanCodes;
    }

    public static void HuffmanCode(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder currentString = new StringBuilder(stringBuilder);
        currentString.append(code);
        if (node != null) {
            if (node.str == null) {
                HuffmanCode(node.left, "0", currentString);
                HuffmanCode(node.right, "1", currentString);
            } else {
                huffmanCodes.put(node.str,currentString.toString());
            }
        }
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    public String str;
    public int weight;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(String str, int weight) {
        this.str = str;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "str='" + str + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode huffmanNode) {
        return this.weight - huffmanNode.weight;
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
}