import java.io.FileWriter;
import java.io.IOException;

public class Metrics {
    private long comparisons = 0;
    private long allocations = 0;
    private int maxRecursionDepth = 0;
    private long startTime = 0, endTime = 0;

    public void startTimer() { startTime = System.nanoTime(); }
    public void stopTimer() { endTime = System.nanoTime(); }
    public long getElapsedTime() { return endTime - startTime; }

    public void incComparisons() { comparisons++; }
    public void addComparisons(long c) { comparisons += c; }
    public long getComparisons() { return comparisons; }

    public void incAllocations() { allocations++; }
    public long getAllocations() { return allocations; }

    public void updateDepth(int d) { maxRecursionDepth = Math.max(maxRecursionDepth, d); }
    public int getMaxRecursionDepth() { return maxRecursionDepth; }

    public void reset() {
        comparisons = allocations = 0;
        maxRecursionDepth = 0;
        startTime = endTime = 0;
    }

    public void printReport(String name) {
        System.out.println("=== " + name + " ===");
        System.out.println("Time (ns): " + getElapsedTime());
        System.out.println("Comparisons: " + getComparisons());
        System.out.println("Allocations: " + getAllocations());
        System.out.println("Depth: " + getMaxRecursionDepth());
    }

    public void saveToCSV(String algo, int n, String filename) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(algo + "," + n + "," + getElapsedTime() + "," + getComparisons() +
                    "," + getAllocations() + "," + getMaxRecursionDepth() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
