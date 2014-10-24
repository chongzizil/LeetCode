package com.li.zil;

/**
 * Created by Zil on 2014/10/11.
 */
public class MergeSort {
	private int[] numbers;
	private int[] helper;

	private int n;

	public void sort(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}

		this.numbers = numbers;
		this.n = numbers.length;
		this.helper = new int[n];

		mergeSort(0, n - 1);
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	private void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}
}
