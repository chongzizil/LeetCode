package com.li.zil;

public class QuickSort {
	private int[] numbers;
	private int n;

	public void sortA(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}

		this.numbers = numbers;
		this.n = numbers.length;

		quickSortA(0, n - 1);
	}

	private void quickSortA(int low, int high) {
		int pivot = numbers[low + (high - low) / 2];
		int i = low;
		int j = high;

		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (low < j) {
			quickSortA(low, j);
		}
		if (high > i) {
			quickSortA(i, high);
		}
	}

	public void sortB(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}

		this.numbers = numbers;
		this.n = numbers.length;

		quickSortB(0, n);
	}

	public void quickSortB(int low, int high) {

		if (low < high) {
			int mid = partition(low, high);
			quickSortB(low, mid - 1);
			quickSortB(mid + 1, high);
		}
	}

	private int partition(int start, int end) {
		int pivot = numbers[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (numbers[j] <= pivot) {
				i++;
				exchange(i, j);
			}
		}

		exchange(++i, end);
		return i;
	}

	private void exchange(int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
