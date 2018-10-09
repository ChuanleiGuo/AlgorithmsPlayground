import java.util.*;

class Solution {
	private final Set<Integer> occupiedCols = new HashSet<Integer>();
	private final Set<Integer> occupiedDiag1 = new HashSet<Integer>();
	private final Set<Integer> occupiedDiag2 = new HashSet<Integer>(); 
	public int totalNQueens(int n) {
		return helper(0, 0, n);
	}
	
	private int helper(int row, int count, int n) {
		for (int col = 0; col < n; col++) {
			if (occupiedCols.contains(col)) {
				continue;
			}
			int diag1 = row - col;
			if (occupiedDiag1.contains(diag1)) {
				continue;
			}
			int diag2 = row + col;
			if (occupiedDiag2.contains(diag2)) {
				continue;
			}
			
			if (row == n - 1) {
				count += 1;
			} else {
				occupiedCols.add(col);
				occupiedDiag1.add(diag1);
				occupiedDiag2.add(diag2);
				
				count = helper(row + 1, count, n);
				
				occupiedCols.remove(col);
				occupiedDiag1.remove(diag1);
				occupiedDiag2.remove(diag2);
			}
		}
		return count;
	}
}