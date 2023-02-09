import java.util.Arrays;
import java.util.Random;

public class Array {
    int[] a;

    public static int[] arrayAppend(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        int i = 0;
        int temp = 0;
        for(i = 0; i < a.length; i++){
            array[i] = a[i];
            //System.out.println(Arrays.toString(array));
        }

        for(int j = i; j < array.length; j++) {
            array[j] = b[temp++];
            //System.out.println(Arrays.toString(array));
        }

        return array;
    }

    public static int[] unsorted(int k, int n) {
        Random rnd = new Random();
        int[] array = new int[k];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n);
        }
        return array;
    }

}