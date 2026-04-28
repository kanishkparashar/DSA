class Solution {
	public int minOperations(int[][] grid, int x) {
		java.util.List<Integer> list = new java.util.ArrayList<>();

		for (int[] row : grid) {
			for (int val : row) {
				list.add(val);
			}
		}

		int remainder = list.get(0) % x;

		for (int val : list) {
			if (val % x != remainder) {
				return -1;
			}
		}

		java.util.Collections.sort(list);
		int median = list.get(list.size() / 2);

		int operations = 0;

		for (int val : list) {
			operations += Math.abs(val - median) / x;
		}

		return operations;
	}
}