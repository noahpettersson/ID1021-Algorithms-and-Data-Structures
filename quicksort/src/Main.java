import java.util.Random;

public class Main {

    public static void main(String[] args) {


        /*list.add(5);
        list.add(9);
        list.add(10);
        list.add(16);
        list.add(11);
        list.add(4);*/
        //list.add(6);
        //list.add(14);

        /*list.add(rnd.nextInt(20));
        list.add(rnd.nextInt(20));
        list.add(rnd.nextInt(20));
        list.add(rnd.nextInt(20));
        list.add(rnd.nextInt(20));
        list.add(rnd.nextInt(20));*/

        /*int[] array = new int[10];

        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(50);
        }

        int[] a = {6, 48, 46, 27, 43, 7, 43, 36, 25, 22,};

        printArray(array);

        arraySort.sort(array, 0, array.length-1);

        printArray(array);*/

        /*list.print();
        System.out.println();

        list.part(list.head, list.end);
        System.out.println();
        list.sort(list.head, list.end);
        System.out.println("-----------------");
        list.print();*/


        LinkedList list = new LinkedList();
        Random rnd = new Random();
        int[] sizes = {100,200,300,400,500,600,700,800,900,
                1000,1100,1200,1300,1400,1500,1600,2000,3000,4000,5000,6000,7000,8000,9000,10000,12800};
        System.out.printf("#%7s%9s\n", "n   ", "AddList");

        for(int n : sizes) {
            System.out.printf("%8d", n);

            int k = 10000;

            double min = Double.POSITIVE_INFINITY;
            double min2 = Double.POSITIVE_INFINITY;
            double t = 0;
            double tT = 0;
            for (int i = 0; i < k; i++) {

                LinkedList l = new LinkedList();
                int[] array = new int[n];

                for(int j = 0; j < n; j++) {
                    array[j] = rnd.nextInt(5*n);
                }

                for(int f = n-1; f > -1; f--) {
                    l.add(array[f]);
                }
                list = l;

                long t0 = System.nanoTime();
                list.sort(list.head, list.end);
                long t1 = System.nanoTime();
                t += (t1 - t0);

                long ta = System.nanoTime();
                arraySort.sort(array, 0, array.length-1);
                long tb = System.nanoTime();
                tT += (tb - ta);
            }

            System.out.printf("%9.0f%9.0f\n", t/k, tT/k);

        }





    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("\n");
    }

    public static void arrayList (int n) {
        Random rnd = new Random();
        LinkedList list = new LinkedList();
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(5*n);
        }

        for(int i = 0; i < n; i++) {
            list.add(array[i]);
        }
    }

    public static int[] arrayGen(int n) {
        Random rnd = new Random();
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(5*n);
        }
        return array;
    }

    public static LinkedList listGen(int n){
        LinkedList list = new LinkedList();
        int[] array = arrayGen(n);

        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

}