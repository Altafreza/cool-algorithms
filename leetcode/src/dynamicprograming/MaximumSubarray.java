package dynamicprograming;

public class MaximumSubarray {
	// O(n2)
	public int maxSubArray2(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int currentSum = 0;
			for (int j = i; j < nums.length; j++) {
				currentSum += nums[j];
				if (currentSum > maxSum)
					maxSum = currentSum;
			}
		}
		return maxSum;
	}

	// Kadane's O(n)
	public int maxSubArray1(int[] nums) {
		int maxSum = nums[0], sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	// Recursive
	int maxSum = Integer.MIN_VALUE;

	public int maxSubArray4(int[] nums) {
		dfs1(nums, nums.length - 1);
		return maxSum;
	}

	private int dfs1(int[] nums, int index) {
		if (index < 0)
			return 0;
		int maxSumFromIndex = Math.max(nums[index], nums[index] + dfs(nums, index - 1));
		maxSum = Math.max(maxSumFromIndex, maxSum);
		return maxSumFromIndex;
	}

	public int maxSubArray(int[] nums) {

		dfs(nums, 0);
		return maxSum;
	}

	private int dfs(int[] nums, int index) {
		if (index >= nums.length)
			return 0;
		int sum = nums[index];
		int incsum = nums[index] + dfs(nums, index + 1);
		int maxSumFromIndex = Math.max(sum, incsum);
		maxSum = Math.max(maxSumFromIndex, maxSum);
		return maxSumFromIndex;
	}
}
