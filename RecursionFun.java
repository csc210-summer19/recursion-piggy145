//Ivan Perez Pina

import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Ivan Perez Pina
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n > 999) {
			String check = "";
			if (n % 1000 < 100) {
				check += "0";
			}
			if (n % 1000 < 10) {
				check += "0";
			}
			return intWithCommas(n / 1000) + "," + check + intWithCommas(n % 1000);

		}

		return String.valueOf(n);
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index == len - 1 || index == len) {
			return;
		}

		int hold = x[index];
		x[index] = x[len - 1];
		x[len - 1] = hold;
		reverseArray(x, index + 1, len - 1);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return helperMax(a, a.length) - helperMin(a, a.length);
	}

	private int helperMax(int[] a, int n) {
		if (n == 1) {
			return a[0];
		}

		int max = Math.max(a[n - 1], helperMax(a, n - 1));
		return max;
	}

	private int helperMin(int[] a, int n) {
		if (n == 1) {
			return a[0];
		}
		int min = Math.min(a[n - 1], helperMin(a, n - 1));
		return min;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return helperSorted(nums, 0);
	}

	private boolean helperSorted(int[] nums, int n) {
		if (nums.length == 0) {
			return true;
		}

		if (n == nums.length - 1) {
			return true;
		}

		if (nums[n] > nums[n + 1]) {
			return false;
		}

		return helperSorted(nums, n + 1);

	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return helperFound(search, strs, 0);
	}

	private boolean helperFound(String search, String[] strs, int n) {

		if (strs[n] == search) {
			return true;
		}

		if (n == strs.length - 1) {
			return false;
		}

		return helperFound(search, strs, n + 1);

	}
}
