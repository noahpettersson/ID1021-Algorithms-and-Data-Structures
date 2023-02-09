public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        /*for (int i : tree)
            System.out.println("next value " + i);*/

        arrayQueue q = new arrayQueue();
        q.enqueue(tree.root);
        q.enqueue(tree.root.left);
        q.enqueue(tree.root.right);
        q.enqueue(tree.root.left.left);
        q.enqueue(tree.root.left.right);
        q.enqueue(tree.root.right.left);
        q.enqueue(tree.root.right.right);
        for(int i = q.front; i <= q.rear; i++) {
            System.out.println(q.queue[i].value);
        }
        System.out.println("------------------");

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        for(int i = q.front; i <= q.rear; i++) {
            System.out.println(q.queue[i].value);
        }

        q.enqueue(tree.root);
        q.enqueue(tree.root.left);
        q.enqueue(tree.root.right);
        q.enqueue(tree.root.left.right);
        q.enqueue(tree.root.left.left);

        System.out.println("-------------------");


        int i = 0;
        for(i = 0; i != q.rear; i++) {
            //System.out.println(i);
            System.out.println(q.queue[i].value);
        }
        System.out.println(q.queue[i].value);





    }
}