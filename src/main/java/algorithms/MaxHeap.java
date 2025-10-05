package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;
    private int comparisons;
    private int swaps;

    public MaxHeap() {
        heap = new ArrayList<>();
        comparisons = 0;
        swaps = 0;
    }

    public void insert(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            comparisons++;
            if (heap.get(index) > heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }
        return max;
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size()) {
            comparisons++;
            if (heap.get(left) > heap.get(largest))
                largest = left;
        }

        if (right < heap.size()) {
            comparisons++;
            if (heap.get(right) > heap.get(largest))
                largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size()) return;
        if (newValue < heap.get(index)) return;
        heap.set(index, newValue);
        siftUp(index);
    }

    private void swap(int i, int j) {
        swaps++;
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}