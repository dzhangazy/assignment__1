import java.util.Arrays;

public class MergeSortWithMetrics {
    public static void mergeSort(int[] arr, Metrics metrics, int depth) {
        metrics.updateDepth(depth);
        if (arr.length <= 1) return;
        int m = arr.length / 2;
        int[] L = Arrays.copyOfRange(arr, 0, m);
        int[] R = Arrays.copyOfRange(arr, m, arr.length);
        metrics.incAllocations();
        mergeSort(L, metrics, depth + 1);
        mergeSort(R, metrics, depth + 1);
        merge(arr, L, R, metrics);
    }

    private static void merge(int[] a, int[] l, int[] r, Metrics metrics) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            metrics.incComparisons();
            if (l[i] <= r[j]) a[k++] = l[i++];
            else a[k++] = r[j++];
        }
        while (i < l.length) a[k++] = l[i++];
        while (j < r.length) a[k++] = r[j++];
    }
}
