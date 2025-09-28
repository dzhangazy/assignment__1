import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        Random rand = new Random();

        String csvFile = "results.csv";

        // Заголовок CSV (перезаписываем файл)
        try {
            java.io.FileWriter writer = new java.io.FileWriter(csvFile, false); // false = overwrite
            writer.write("Algorithm,n,time_ns,comparisons,allocations,recursion_depth\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] sizes = {100, 1000, 5000, 10000};

        for (int n : sizes) {
            int[] arr1 = rand.ints(n, 0, 100000).toArray();
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();

            // MergeSort
            metrics.reset();
            metrics.startTimer();
            MergeSortWithMetrics.mergeSort(arr1, metrics, 1);
            metrics.stopTimer();
            metrics.printReport("MergeSort n=" + n);
            metrics.saveToCSV("MergeSort", n, csvFile);

            // QuickSort
            metrics.reset();
            metrics.startTimer();
            QuickSortWithMetrics.quickSort(arr2, 0, arr2.length - 1, metrics, 1);
            metrics.stopTimer();
            metrics.printReport("QuickSort n=" + n);
            metrics.saveToCSV("QuickSort", n, csvFile);

            // Deterministic Select
            metrics.reset();
            metrics.startTimer();
            int median = DeterministicSelectWithMetrics.select(arr3, arr3.length / 2, metrics);
            metrics.stopTimer();
            metrics.printReport("DeterministicSelect n=" + n + " median=" + median);
            metrics.saveToCSV("DeterministicSelect", n, csvFile);
        }
    }
}
