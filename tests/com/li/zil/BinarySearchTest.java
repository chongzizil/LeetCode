package com.li.zil;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BinarySearchTest  {
	@Test
	public void test1() {
		int[] nums = new int[]{1,2,3,4,5,6,7};
		System.out.println(BinarySearch.binarySearch(nums, 3));
		assertEquals(2, BinarySearch.binarySearch(nums, 3));
	}
}