import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap<T extends Comparable<T>> {
    private List<T> heap;        // List to store the elements of the heap
    private int numChildren;     // Number of children per parent node

    public PowerOfTwoMaxHeap(int numChildren) {
        this.heap = new ArrayList<>();
        this.numChildren = numChildren;
    }

    public void insert(T value) {
        heap.add(value);     // Add the new element at the end of the list
        siftUp(heap.size() - 1);     // Sift up the element to its correct position
    }

    public T popMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T max = heap.get(0);     // Store the maximum value (at the root)
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));     // Replace the root with the last element
        heap.remove(lastIndex);     // Remove the last element
        siftDown(0);     // Sift down the new root to its correct position

        return max;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / numChildren;

        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);     // Swap the element with its parent if necessary
            index = parentIndex;
            parentIndex = (index - 1) / numChildren;
        }
    }

    private void siftDown(int index) {
        int maxChildIndex = getMaxChildIndex(index);

        while (maxChildIndex != -1 && heap.get(index).compareTo(heap.get(maxChildIndex)) < 0) {
            swap(index, maxChildIndex);     // Swap the element with its largest child if necessary
            index = maxChildIndex;
            maxChildIndex = getMaxChildIndex(index);
        }
    }

    private int getMaxChildIndex(int index) {
        int startChildIndex = index * numChildren + 1;
        int maxChildIndex = -1;
        T maxChildValue = null;

        for (int i = startChildIndex; i < startChildIndex + numChildren && i < heap.size(); i++) {
            if (maxChildValue == null || heap.get(i).compareTo(maxChildValue) > 0) {
                maxChildValue = heap.get(i);     // Track the maximum child value and its index
                maxChildIndex = i;
            }
        }

        return maxChildIndex;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);     // Swap elements at indices i and j
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
