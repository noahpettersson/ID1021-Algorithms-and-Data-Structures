import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {

    public Iterator<Integer> iterator(){
        return new TreeIterator();
    }
    public class Node {
        public Integer key;
        public Integer value;

        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left= this.right = null;
        }

        public Node add(Integer key, Integer value) {
            if(this.key == key) {
                this.value = value;
            }
            if(this.key > key){
                if(this.left == null) {
                    this.left = new Node(key, value);
                } else {
                    this.left = this.left.add(key, value);
                }
            }
            if(this.key < key){
                if(this.right == null) {
                    this.right = new Node(key, value);
                } else {
                    this.right = this.right.add(key, value);
                }
            }
            return this;
        }

        public Integer lookup(Integer key) {
            Node current = this;
            while(current != null) {
                if(current.key == key) {
                    return current.value;
                }
                else if(current.key > key) {
                    current = current.left;
                } else
                    current = current.right;
            }
            return null;
        }

        public void print() {
            if(left != null) {
                left.print();
            }
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null) {
                right.print();
            }
        }
    }

    static Node root;
    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        if(root == null) {
            root = new Node(key, value);
        } else  root.add(key, value);
    }

    public Integer lookup(Integer key) {
        return root.lookup(key);
    }

}