import java.util.Random;

public class QuickSortWithMetrics {
    private static final Random rand = new Random();

    public static void quickSort(int[] arr, int low, int high, Metrics metrics, int depth) {
        metrics.updateDepth(depth);
        if (low < high) {
            int pivot = partition(arr, low, high, metrics);
            quickSort(arr, low, pivot - 1, metrics, depth + 1);
            quickSort(arr, pivot + 1, high, metrics, depth + 1);
        }
    }

    private static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            metrics.incComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
