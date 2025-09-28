import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        int[] arr = {5, 3, 8, 1, 2};

        metrics.startTimer();
        MergeSortWithMetrics.mergeSort(arr, metrics, 1);
        metrics.stopTimer();

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        metrics.printReport("MergeSort");
    }
}