import java.util.Arrays;

public class DeterministicSelectWithMetrics {
    public static int select(int[] arr, int k, Metrics metrics) {
        return select(arr, 0, arr.length - 1, k, metrics, 1);
    }

    private static int select(int[] arr, int left, int right, int k, Metrics metrics, int depth) {
        metrics.updateDepth(depth);
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right, metrics);
        int pivotIndex = partition(arr, left, right, pivot, metrics);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return select(arr, left, pivotIndex - 1, k, metrics, depth + 1);
        else return select(arr, pivotIndex + 1, right, k, metrics, depth + 1);
    }

    private static int medianOfMedians(int[] arr, int left, int right, Metrics metrics) {
        int n = right - left + 1;
        int numMedians = (int) Math.ceil((double) n / 5);
        int[] medians = new int[numMedians];
        metrics.incAllocations();

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            int[] group = Arrays.copyOfRange(arr, subLeft, subRight + 1);
            Arrays.sort(group);
            medians[i] = group[group.length / 2];
        }

        if (numMedians == 1) return medians[0];
        else return medianOfMedians(medians, 0, medians.length - 1, metrics);
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics metrics) {
        while (left <= right) {
            while (arr[left] < pivot) { metrics.incComparisons(); left++; }
            while (arr[right] > pivot) { metrics.incComparisons(); right--; }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return left - 1;
    }
}
