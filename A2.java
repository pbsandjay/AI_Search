public class A2 {
	public static int N = 9;
	public static int quad[][] = new int[9][10];
	public static int readrow[][] = new int[9][10];
	public static int createroweaterow[][] = new int[9][10];
	
	public static int quad(int x, int y) {
		return 3*(x/3) + y/3;
	}
	
	public static boolean putable(int x, int y, int v) {
		int q = quad(x, y);
		if(readrow[x][v] == 1 || createrow[y][v] == 1 || quad[q][v] !=0)return false;
		return true;
	}
	
	public static void solve(int x, int y) {

		if(x == 8 && y == 9) {printBoard();return;}
		if(y == 9) {y=0; x++;}
		
		if(board[x][y]!=0) {solve(x, y+1); return;}
		
		for(int i=1;i<=9;++i) {
			int q = quad(x, y);
			
			if(putable(x, y, i)) {
				quad[q][i] = 1;
				readrow[x][i] = 1;
				createrow[y][i] = 1;
				
				board[x][y] = i;
				solve(x, y+1);				
				board[x][y] = 0;

				readrow[x][i] = 0;
				createrow[y][i] = 0;
				quad[q][i] = 0;
			}
		}
	}
	
	public static void main(String[] args)throws Exception{
		for(int i=0;i<9;++i) {
			for(int j=0;j<9;++j) {
				if(board[i][j] != 0) {
					int q = quad(i, j);
					int v = board[i][j];
					readrow[i][v] = 1;
					createrow[j][v] = 1;
					quad[q][board[i][j]] = 1;
				}
			}
		}
		solve(0, 0);
	}
	
	public static void printBoard() {
		System.out.println();
		for(int i=0;i<9;++i) {
			for(int j=0;j<9;++j) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

    public static int board[][] = {
    		{9, 0, 6, 0, 7, 0, 4, 0, 3},
    		{0, 0, 0, 4, 0, 0, 2, 0, 0},
    		{0, 7, 0, 0, 2, 3, 0, 1, 0},
    		{5, 0, 0, 0, 0, 0, 1, 0, 0},
    		{0, 4, 0, 2, 0, 8, 0, 6, 0},
    		{0, 0, 3, 0, 0, 0, 0, 0, 5},
    		{0, 3, 0, 7, 0, 0, 0, 5, 0},
    		{0, 0, 7, 0, 0, 5, 0, 0, 0},
    		{4, 0, 5, 0, 1, 0, 7, 0, 8},};
}