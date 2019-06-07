package algos;

public class NumberOfIslandsInMatrix {

	public static void main(String[] args) {

		int[][] a = new int[][] {{1, 1, 0, 0, 0}, 
								 {0, 1, 0, 0, 1}, 
								 {1, 0, 0, 1, 1}, 
								 {0, 0, 0, 0, 0}, 
								 {1, 0, 1, 0, 1} 
		}; 
		System.out.println("Number of Islands is: " + countIslands(a));
	}

	private static int countIslands(int[][] a) {
		
		int count = 0;
		int r = a.length;
		int c = a[0].length;
		boolean visited[][] = new boolean[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]==1 && !visited[i][j]) {
					count++;
					visitNeighbours(a, visited,i ,j);
				}
			}
		}
		return count;
	}
	
	private static void visitNeighbours(int[][] a, boolean[][] visited, int r, int c) {
		int rowMov[] = {-1,-1,-1,0,0,1,1,1};
		int colMov[] = {-1,0,1,-1,1,-1,0,1};
		for(int i=0;i<rowMov.length;i++) {
			for(int j=0;j<colMov.length;j++) {
				int k = r + rowMov[i];
				int l = c + colMov[j];
				if(inLimit(k, l, a) && a[k][l]==1 && !visited[k][l]) {
					visited[k][l] = true;
					visitNeighbours(a, visited,k ,l);
				}
			}
		}
	}

	private static boolean inLimit(int k, int l, int [][]a) {
		if(k>=0 && k<a.length && l>=0 && l<a[0].length)
			return true;
		return false;
	}

}
