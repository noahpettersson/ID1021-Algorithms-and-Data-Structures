import java.util.Random;

public class BinaryTree {
    public Integer depth = 0;
    public Integer addDepth = 0;
    public class Node {
        public Integer value;

        public Node left, right;

        public Integer size;


        public Node(Integer value) {
            this.value = value;
            this.size = 1;
            this.left= this.right = null;
        }

        /*public void add(Integer data) {
            if(data < this.value) {
                int temp = data;
                data = this.value;
                this.value = temp;
            }
            if(this.left.size == 0) {
                this.left = new Node(data);
                return;
            }

            if(this.right.size == 0) {
                this.right = new Node(data);
                return;
            }

            if(this.left.size < this.right.size)
                this.left.add(data);
            else
                this.right.add(data);

        }*/

        public Integer add(Integer inputValue){
            Node current = this;
            current.size++;
            Integer temp = null;
            addDepth++;
            if(current.value > inputValue) {
                temp = current.value;
                current.value = inputValue;
                addDepth--;
                        //inputValue is smaller than root, replace root, set depth to 1
            } else {
                temp = inputValue;
            }
            if(current.left == null){
                current.left = new Node(temp);
            } else if (current.right == null) {
                current.right = new Node(temp);
            } else if (current.right.size > current.left.size ){
                current.left.add(temp);
            } else if (current.right.size < current.left.size ){
                current.right.add(temp);
            } else {
                current.left.add(temp);
            }
            return addDepth;
        }

        public void remove() {
            if(root.size == 1) {
                root = null;
            }
            Node current = this;
            current.size--;

            if (current.left == null) {
                current.value = current.right.value;
                if(current.right.size == 1) {
                    current.right = null;
                }
                else {
                    current = current.right;
                    //current.size--;
                    current.remove();
                }
            }
            else if (current.right == null) {
                current.value = current.left.value;
                if(current.left.size == 1) {
                    current.left = null;
                }
                else {
                    current = current.left;
                    //current.size--;
                    current.remove();
                }
            }
            else if(current.right.value < current.left.value){
                current.value = current.right.value;
                if(current.right.size == 1) {
                    current.right = null;
                }
                else {
                    current = current.right;
                    current.remove();
                }
            }
            else {
                current.value = current.left.value;
                if(current.left.size == 1) {
                    current.left = null;
                }
                else {
                    current = current.left;
                    current.remove();
                }
            }
        }

        /*public Node remove(){
            if (this.left == null){
                return  this.right;
            } else if (this.right == null){
                return  this.left;
            } else if (this.right.value > this.left.value){
                this.value =  this.left.value;
                this.size--;
                if(this.left.size == 0)
                    this.left = null;
                else
                    this.left = this.left.remove();
                return this;
            } else {
                this.value =  this.right.value;
                this.size--;
                if(this.right.size == 0)
                    this.right = null;
                else
                    this.right = this.right.remove();
                return this;
            }
        }*/

        /*public Integer push() {
            depth++;
            Node current = this;

            if(current.left == null) {
                Integer tbu = current.value;
                if(current.right.size == 1 && current.right.value < current.value) {
                    current.value = current.right.value;
                    current.right.value = tbu;
                    return ++depth;
                }
                else if(current.right.size == 1 && current.right.value > current.value) {
                    return depth;
                }
                else if(current.right.value > current.value)
                    return depth;
                else{
                    current.value = current.right.value;
                    current.right.value = tbu;
                    current = current.right;
                    current.push();
                }
            }
            else if(current.right == null) {
                Integer tbu = current.value;
                if(current.left.size == 1 && current.left.value < current.value) {
                    current.value = current.left.value;
                    current.left.value = tbu;
                    return ++depth;
                }
                else if(current.left.size == 1 && current.left.value > current.value) {
                    return depth;
                }
                else if(current.left.value > current.value)
                    return depth;
                else{
                    current.value = current.left.value;
                    current.left.value = tbu;
                    current = current.left;
                    current.push();
                }
            }
            else if(current.left.value < current.right.value) {
                Integer tbu = current.value;
                if(current.left.size == 1 && current.left.value < current.value) {
                    current.value = current.left.value;
                    current.left.value = tbu;
                    return ++depth;
                }
                else if(current.left.size == 1 && current.left.value > current.value) {
                    return depth;
                }
                else if(current.left.value < current.value) {
                    current.value = current.left.value;
                    current.left.value = tbu;
                    current = current.left;
                    current.push();
                }
            }
            else {
                Integer tbu = current.value;
                if(current.right.size == 1 && current.right.value < current.value) {
                    current.value = current.right.value;
                    current.right.value = tbu;
                    return ++depth;
                }
                else if(current.right.size == 1 && current.right.value > current.value) {
                    return depth;
                }
                else if(current.right.value < current.value) {
                    current.value = current.right.value;
                    current.right.value = tbu;
                    current = current.right;
                    current.push();
                }
            }
            return depth;
        }*/

        public Integer push() {
            Node currentNode = this;
            depth++;
            if (currentNode.left == null && currentNode.right == null) {
                return depth;
            }
            else if (currentNode.left != null && currentNode.left.value < currentNode.value) {
                if (currentNode.right != null && currentNode.right.value < currentNode.left.value) {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.right.value;
                    currentNode.right.value = temp;
                    // depth++;
                    currentNode.right.push();
                }
                else {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.left.value;
                    currentNode.left.value = temp;
                    // depth++;
                    currentNode.left.push();
                }
            }
            else if (currentNode.right != null && currentNode.right.value < currentNode.value) {
                if (currentNode.left != null && currentNode.left.value < currentNode.right.value) {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.left.value;
                    currentNode.left.value = temp;
                    // depth++;
                    currentNode.left.push();
                }
                else {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.right.value;
                    currentNode.right.value = temp;
                    // depth++;
                    currentNode.right.push();
                }
            }
            return depth;
        }

        public void print() {
            if(left != null) {
                left.print();
            }
            System.out.println(" value: " + value);
            if(right != null) {
                right.print();
            }
        }
    }
    static Node root;

    public BinaryTree() {
        root = null;
    }

    public Integer add(Integer value) {
        addDepth = 1;
        if(root == null) {
            root = new Node(value);
            return addDepth;
        } else  return root.add(value);
    }

    public Integer remove(){
        if(root == null) {
            return null;
        }
        else{
            Integer temp = root.value;
            root.remove();
            return  temp;
        }
    }

    /*public Integer push(Integer incr) {
        if(root == null) {
            return null;
        }
        else if(root.size == 1) {
            root.value += incr;
            return 1;
        }
        else {
            root.value += incr;
            return root.push();
        }


    }*/

    public Integer push(Integer incr) {
        if (root != null) {
            root.value += incr;
            return root.push();
        }
        return null;
    }

    public BinaryTree generate(Integer n) {
        Random rnd = new Random();
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < n; i++) {
            tree.add(rnd.nextInt(101));
        }
        return tree;
    }

}
