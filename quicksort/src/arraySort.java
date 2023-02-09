public class arraySort {

    static int partition(int[] array, int i, int j, int pivot){
        int low = i;
        int high = j;
        int temp = 0;

        while(low < high) {
            while(array[low] <= pivot && low < high) {
                low++;
            }
            while(array[high] >= pivot && low < high) {
                high--;
            }
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return low;
    }

    static int part(int[] array, int i, int j, int pivot){
        int low = i;
        int high = j;
        int temp = 0;

        while (low < high) {
            while(array[low] <= pivot && low < j)
                low++;

            while(array[high] >= pivot && high > i)
                high--;

            if(array[low] > array[high] && low < high) {
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        return high;
    }

    static void sort(int[] array, int i, int j) {
        if(i >= j)
            return;

        int pivot = array[i];
        int high = part(array, i, j, pivot);

        sort(array, i, high-1);
        sort(array, high+1, j);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
