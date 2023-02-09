import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        ArrayHeap heap = new ArrayHeap(5);
        Random rnd = new Random();
        BinaryTree.Node test = tree.new Node(7);
        BinaryTree.Node test2 = tree.new Node(20);
        //OuterClass.InnerClass innerObject = outerObject.new InnerClass();

        //int g = 1000;

        /*Integer pushAvg = 0;
        for(int i = 0; i < g; i++) {
            tree = tree.generate(1000);
            Integer temp = tree.push(rnd.nextInt(10, 51));
            pushAvg += temp;
            System.out.println(temp);
        }
        System.out.println("push average: " + (pushAvg/g));*/

        /*Integer addAvg = 0;
        for(int i = 0; i < 64; i++) {
            Integer temp = tree2.add(rnd.nextInt());
            addAvg += temp;
            System.out.println("temp: " + temp);
        }
        System.out.println("add average: " + (addAvg/(g)));*/


        /*int[] sizes = {100,200,300,400,500,600,700,800,900,
                1000,1100,1200,1300,1400,1500,1600,2500,3000,5000,12800};
        System.out.printf("#%7s%9s%9s\n", "n   ", "List1", "List2");

        for(int n : sizes) {
            System.out.printf("%8d", n);

            tree = tree.generate(n);

            int k = 100000;

            double t2 = 0;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                tree.add(rnd.nextInt(n*5));
                long t1 = System.nanoTime();
                tree.remove();
                t2 += (t1 - t0);

            }

            System.out.printf("%9.0f\n", (t2/k));

        }*/

        int[] sizes = {100,200,300,400,500,600,700,800,900,
                1000,1100,1200,1300,1400,1500,1600,2500,3000,5000,12800};
        System.out.printf("#%7s%9s%9s\n", "n   ", "List1", "List2");

        for(int n : sizes) {
            System.out.printf("%8d", n);

            list = list.gen(n);
            list2 = list2.gen2(n);

            int k = 1000000;

            double t = 0;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                list.remove();
                list.add(rnd.nextInt(n*5));
                long t1 = System.nanoTime();
                t += (t1 - t0);
            }
            System.out.printf("%9.0f", (t/k));

            double t2 = 0;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                list2.add2(rnd.nextInt(n*5));
                list2.remove2();
                long t1 = System.nanoTime();
                t2 += (t1 - t0);

            }

            System.out.printf("%9.0f\n", (t2/k));

        }



    }
}