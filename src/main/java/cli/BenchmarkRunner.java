package cli;

import algorithms.MinHeap;
import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 50000};
        Random rand = new Random();

        System.out.println("Benchmark: MinHeap vs MaxHeap\n");

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = rand.nextInt(n * 10);

            PerformanceTracker tracker = new PerformanceTracker();

            // MinHeap
            MinHeap minHeap = new MinHeap();
            tracker.start();
            for (int val : data) minHeap.insert(val);
            tracker.stop();
            double minTime = tracker.getElapsedMillis();

            // MaxHeap
            MaxHeap maxHeap = new MaxHeap();
            tracker.start();
            for (int val : data) maxHeap.insert(val);
            tracker.stop();
            double maxTime = tracker.getElapsedMillis();

            System.out.printf("n=%d | MinHeap: %.3f ms | MaxHeap: %.3f ms%n",
                    n, minTime, maxTime);
        }
    }
}