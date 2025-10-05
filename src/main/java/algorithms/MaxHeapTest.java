package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    @Test
    void testInsertAndExtractMax() {
        MaxHeap heap = new MaxHeap();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(10);
        assertEquals(10, heap.extractMax());
        assertEquals(8, heap.extractMax());
    }

    @Test
    void testIncreaseKey() {
        MaxHeap heap = new MaxHeap();
        heap.insert(5);
        heap.insert(8);
        heap.insert(3);
        heap.increaseKey(2, 12);
        assertEquals(12, heap.extractMax());
    }
}