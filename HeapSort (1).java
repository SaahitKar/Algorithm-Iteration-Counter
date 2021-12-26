public class HeapSort {
	/** Heap sort method */
	public static int movement = 0;
	public static int comparision = 0;
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		movement = heap.move;
		comparision = heap.compare;
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--)
			list[i] = heap.remove();
	}
}