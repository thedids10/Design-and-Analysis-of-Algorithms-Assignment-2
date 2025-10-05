package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void testInsertAndExtractMin() {
        MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
    }

    @Test
    void testDecreaseKey() {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.decreaseKey(2, 5);
        assertEquals(5, heap.extractMin());
    }

    @Test
    void testMerge() {
        MinHeap a = new MinHeap();
        a.insert(3);
        a.insert(10);

        MinHeap b = new MinHeap();
        b.insert(1);
        b.insert(7);

        a.merge(b);
        assertEquals(1, a.extractMin());
        assertEquals(3, a.extractMin());
    }
}