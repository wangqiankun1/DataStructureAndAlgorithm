package datastructure;


class Test {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(15);
        hashTable.add(123, "王乾坤");
        hashTable.add(123, "温馨");
        hashTable.add(14, "柳叶");
        hashTable.add(6418, "啊");
        hashTable.list();
        hashTable.findNode(6418);
    }
}


public class HashTable {
    private LinkList[] linkListArray;
    private int size = 0;

    public HashTable(int size) {
        linkListArray = new LinkList[size];
        initLinkLists();
        this.size = size;
    }

    private void initLinkLists() {
        for (int i = 0; i < linkListArray.length; i++) {
            linkListArray[i] = new LinkList();
        }
    }

    public int hash(int id) {
        return id % size;
    }

    public void add(int id, String name) {
        Node node = new Node(id, name);
        int hashValue = hash(id);
        linkListArray[hashValue].add(node);
    }

    public void findNode(int id) {
        int hashValue = hash(id);
        Node p = linkListArray[hashValue].head.next;
        while (p != null) {
            if (p.id == id){
                System.out.println("员工的姓名为："+p.name);
                return;
            }
            p = p.next;
        }
        System.out.println("没有找到该员工");
    }

    public void list() {
        for (int i = 0; i < linkListArray.length; i++) {
            System.out.println("LinkListArray[" + i + "]" + ":");
            Node p = linkListArray[i].head.next;
            while (p != null) {
                System.out.print(p + "\t");
                p = p.next;
            }
            System.out.println();
        }
    }

}

class LinkList {
    Node head = new Node(-1, null);

    public LinkList() {
    }

    public void add(Node node) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
    }

}

class Node {
    public int id;
    public String name;
    public Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}