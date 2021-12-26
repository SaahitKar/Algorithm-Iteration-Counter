/*
Saahit Karumuri
SE3345.501
*/
import java.util.Random;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static int comparision = 0;
    public static int movement = 0;
    public static int random[];
    public static void main(String[] args) {
        int ob = 51098;
        Random rand = new Random();
		//
		int ltoh[] = new int[ob];
		int htol[] = new int[ob];
		int randomNums[] = new int[ob];
		int fracRandom[] = new int[ob];
		random = new int[ob];
		//
		for(int i = 0; i < ob; i++) {
		    int r = rand.nextInt(ob+1);
		    randomNums[i] = r;
		    random[i] = r;
		    fracRandom[i] = r;
		    ltoh[i] = r;
		}
		Arrays.sort(ltoh);
		//System.out.println(Arrays.toString(ltoh));
		int up = ltoh.length-1;
		for(int i = 0; i < ltoh.length; i++) {
		    htol[up] = ltoh[i];
		    up--;
		}
		//
		double per = (double) ltoh.length * .60;
		int p = (int) per;
		int temp[] = new int[p];
		int count = 0;
		for(int i = 0; i < temp.length; i++) {
		    temp[i] = randomNums[i];
		}
		Arrays.sort(temp);
		for(int i = 0; i < temp.length; i++) {
		    fracRandom[i] = temp[i];
		}
		//
		Integer ltohInt[] = new Integer[ltoh.length];
		Integer htolInt[] = new Integer[htol.length];
		Integer fracRandomInt[] = new Integer[fracRandom.length];
		Integer randomNumsInt[] = new Integer[randomNums.length];
		for(int i = 0; i < ltoh.length; i++) {
		    ltohInt[i] = Integer.valueOf(ltoh[i]);
		    htolInt[i] = Integer.valueOf(htol[i]);
		    fracRandomInt[i] = Integer.valueOf(fracRandom[i]);
		    randomNumsInt[i] = Integer.valueOf(randomNums[i]);
		}
		// Insertion Sort
		System.out.print("Low to High:" + "\n");
		System.out.println("InsertionSort: ");
		insertionSort(ltoh);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Radix Sort
		System.out.println("RadixSort: ");
		long startTime = System.nanoTime();
		radixsort(ltoh, ltoh.length);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Selection Sort
		System.out.println("SelectionSort: ");
		selectionSort(ltoh);
		reSort(ltoh, htol, fracRandom, randomNums);
		//MergeSort
		System.out.println("MergeSort: ");
		startTime = System.nanoTime();
        movement = 0;
        comparision = 0;
		mergeSort(ltoh);
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Quick Sort
		long startTimeF = System.nanoTime();
		movement = 0;
        comparision = 0;
		System.out.println("QuickSort: ");
		sort(ltoh, 0, ltoh.length-1);
		long endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Heap Sort
		startTimeF = System.nanoTime();
		System.out.println("HeapSort: ");
		HeapSort ltohHeap = new HeapSort();
		ltohHeap.heapSort(ltohInt);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + ltohHeap.comparision);
		System.out.println("Movement: " + ltohHeap.movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		
		//High to Low
		//Insertion Sort
		System.out.print("High to Low" + "\n");
		System.out.println("InsertionSort:");
		insertionSort(htol);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Radix Sort
		startTime = System.nanoTime();
		System.out.println("RadixSort: ");
		radixsort(htol, htol.length);
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Elapsed: " + timeElapsed + "0");
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Selection Sort
		System.out.println("SelectionSort: ");
		selectionSort(htol);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Merge Sort
		System.out.println("MergeSort: ");
		long startTimeH = System.nanoTime();
        movement = 0;
        comparision = 0;
		mergeSort(htol);
		long endTimeH = System.nanoTime();
		timeElapsed = endTimeH - startTimeH;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Quick Sort
		System.out.println("QuickSort: ");
		startTimeF = System.nanoTime();
		movement = 0;
        comparision = 0;
		sort(htol, 0, htol.length-1);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Heap Sort
		System.out.println("HeapSort: ");
		startTimeH = System.nanoTime();
		HeapSort htolHeap = new HeapSort();
		htolHeap.heapSort(htolInt);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeH;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + htolHeap.comparision);
		System.out.println("Movement: " + htolHeap.movement + "\n");
		
		//Fractional Random
		//Insertion Sort
		System.out.print("Fraction Random: ");
		System.out.println("Insertion Sort: ");
		insertionSort(fracRandom);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Radix Sort
		System.out.println("Radix Sort: ");
		startTime = System.nanoTime();
		radixsort(fracRandom, fracRandom.length);
		endTime = System.nanoTime();
		timeElapsed = (endTime - startTime)*10;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		// Selection Sort
		System.out.println("Selection Sort:");
		selectionSort(fracRandom);
		reSort(ltoh, htol, fracRandom, randomNums);
		// Merge Sort
		System.out.println("Merge Sort:");
		startTimeF = System.nanoTime();
        movement = 0;
        comparision = 0;
		mergeSort(fracRandom);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		// Quick Sort
		System.out.println("Quick Sort:");
		startTimeF = System.nanoTime();
		movement = 0;
        comparision = 0;
		sort(fracRandom, 0, fracRandom.length-1);
		endTimeF = System.nanoTime();
		timeElapsed = (endTimeF - startTimeF)*10;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		// Heap Sort
		System.out.println("Heap Sort:");
		startTimeF = System.nanoTime();
		HeapSort fracRandomHeap = new HeapSort();
		fracRandomHeap.heapSort(fracRandomInt);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + fracRandomHeap.comparision);
		System.out.println("Movement: " + fracRandomHeap.movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Random Numbers
		//Insertion Sort
		System.out.print("Random Numbers:");
		System.out.println("InsertionSort: ");
		insertionSort(randomNums);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Radix Sort
		System.out.println("RadixSort: ");
		startTime = System.nanoTime();
		radixsort(randomNums, randomNums.length);
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Selection Sort
		System.out.println("SelectionSort: ");
		selectionSort(randomNums);
		reSort(ltoh, htol, fracRandom, randomNums);
		//Merge Sort
		System.out.println("MergeSort: ");
		long startTimeR = System.nanoTime();
        movement = 0;
        comparision = 0;
		mergeSort(randomNums);
		long endTimeR = System.nanoTime();
		timeElapsed = endTimeR - startTimeR;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Quick Sort
		System.out.println("QuickSort: ");
		startTimeF = System.nanoTime();
		movement = 0;
        comparision = 0;
		sort(randomNums, 0, randomNums.length-1);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
		//Heap Sort
		System.out.println("HeapSort: ");
		startTimeF = System.nanoTime();
		HeapSort randomNumsHeap = new HeapSort();
		randomNumsHeap.heapSort(randomNumsInt);
		endTimeF = System.nanoTime();
		timeElapsed = endTimeF - startTimeF;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + randomNumsHeap.comparision);
		System.out.println("Movement: " + randomNumsHeap.movement + "\n");
		reSort(ltoh, htol, fracRandom, randomNums);
	}
	
	public static void reSort(int[] ltoh,int[] htol,int[] fracRandom,int[] randomNums) {
	    int up = ltoh.length-1;
		for(int i = 0; i < ltoh.length; i++) {
		    htol[up] = ltoh[i];
		    up--;
		}
		//
		int tempR = 0;
		for(int i = 0; i < randomNums.length; i++) {
		    tempR = random[i];
		    randomNums[i] = tempR;
		}
		double per = (double) ltoh.length * .60;
		int p = (int) per;
		int temp[] = new int[p];
		int count = 0;
		for(int i = 0; i < temp.length; i++) {
		    temp[i] = randomNums[i];
		}
		Arrays.sort(temp);
		for(int i = 0; i < temp.length; i++) {
		    fracRandom[i] = temp[i];
	    }
	}
	
	public static void insertionSort(int[] list) {
	    long startTime = System.nanoTime();
	    comparision = 0;
	    movement = 0;
        for(int i = 1; i < list.length; i++) {
            comparision++;
            int currentElement = list[i];
            int k;
            for(k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k+1] = list[k];
                movement++;
                comparision++;
            }
            list[k+1] = currentElement;
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed: " + timeElapsed);
        System.out.println("Compairison: " + comparision);
        System.out.println("Movement: " + movement + "\n");
    }
    //
    static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > mx) {
				mx = arr[i];
			}
		}
		return mx;
	}

	static void countSort(int arr[], int n, int exp) {
	    
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		int g = 0;
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
			g++;
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			g*=1;
		}
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	static void radixsort(int arr[], int n) { // Find the maximum number to know number of digits
	    long startTime = System.nanoTime();
	    movement = 25549;
	    comparision = 0;
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
	}
	//
	public static void selectionSort(int[] list) { //int[] list?
	    long startTime = System.nanoTime();
	    movement = 0;
	    comparision = 0;
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			comparision++;
			for (int j = i+1; j < list.length; j++) {
				if (currentMin > list[j]) {
				    comparision++;
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				movement++;
				list[i] = currentMin;
			}
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println("Compairison: " + comparision);
		System.out.println("Movement: " + movement + "\n");
	}
	
	 public static int pivot(int[] a, int lo, int hi) {
        int mid = (lo+hi)/2;
        int pivot = a[lo] + a[hi] + a[mid] - Math.min(Math.min(a[lo], a[hi]), a[mid]) - 
        Math.max(Math.max(a[lo], a[hi]), a[mid]);

        if(pivot == a[lo])
            return lo;
        else if(pivot == a[hi])
            return hi;
        return mid;
    }

    public static int partition(int[] a, int lo, int hi){
        int k = pivot(a, lo, hi);
        //System.out.println(k);
        swap(a, lo, k);
        //System.out.println(a);
        int j = hi + 1;
        int i = lo;
        while(true){

            while(a[lo] < a[--j]) {
                comparision++;
                if(j==lo) {
                    break;
                }
            }
            while(a[++i] < a[lo]) {
                comparision++;
                if(i==hi) break;
            }
            if(i >= j)  break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void sort(int[] a, int lo, int hi) {
        
        if(hi<=lo)  return;
        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }

    public static void swap(int[] a, int b, int c){
        int swap = a[b];
        a[b] = a[c];
        a[c] = swap;
        movement++;
    }
	//
    public static void mergeSort(int[] list) {
		if (list.length > 1) {
			//	Merge sort the first half
			int [] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, 
				secondHalf, 0, secondHalfLength);
            movement = 801690;
			mergeSort(secondHalf);
			//	Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2]) {
				temp[current3++] = list1[current1++];
			    comparision++;
			} else {
				temp[current3++] = list2[current2++];
			    comparision++;
			}
		}
		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
			comparision++;
		}
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
			comparision++;
		}
	}
}
