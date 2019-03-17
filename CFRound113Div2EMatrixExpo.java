/**
 * The below solution uses Matrix Exponentiation.
 * 
 * There's a ball at top of tetrahedron and can go to any other vertex connected to it. Moving from one vertex to another cost a
 * distance of 1. Value of path length is given, say L. We've to tell in how many ways the ant can return to the vertex 
 * from where it started after traversing length L. Technically we've to find out the number of different cyclic paths with the 
 * length of L from starting vertex to itself.
 * 
 * As it's a tetrahedron so this is a regular graph of degree 3. Just build the adjacency matrix and raise it to the power L.
 * 
 * Proof - https://math.stackexchange.com/questions/2434064/proof-raising-adjacency-matrix-to-n-th-power-gives-n-length-walks-between
 * 
 * Resources :
 * Hackerearth blog on Matrix Exponentiation - https://www.hackerearth.com/practice/notes/matrix-exponentiation-1/
 * CP algorithms - https://cp-algorithms.com/algebra/binary-exp.html
 * 
 * This is definently an overkill for this problem, but it's worth learning
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MatrixExponentiation {
	public static void main (String []args)throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        /**
         *We assume that the graph is specified with an adjacency matrix, i.e. the matrix G[][] of size n×n, where each element G[i][j] 
         *equal to 1 if the vertex i is connected with j by an edge, and 0 is they are not connected by an edge. The following algorithm
         *works also in the case of multiple edges: if some pair of vertices (i,j) is connected with m edges, then we can record this in
         *the adjacency matrix by setting G[i][j]=m. Also the algorithm works if the graph contains loops (a loop is an edge that 
         *connect a vertex with itself).
         */
         
        long a[][] = new long[4][4];
        a[0][0] = 0;
        a[0][1] = 1;
        a[0][2] = 1;
        a[0][3] = 1;
        a[1][0] = 1;
        a[1][1] = 0;
        a[1][2] = 1;
        a[1][3] = 1;
        a[2][0] = 1;
        a[2][1] = 1;
        a[2][2] = 0;
        a[2][3] = 1;
        a[3][0] = 1;
        a[3][1] = 1;
        a[3][2] = 1;
        a[3][3] = 0;
        
        int n = Integer.parseInt(br.readLine());
        long result[][]  = powerExpo(a, n); // function for matrix exponentiation
        System.out.println(result[3][3] % 1000000007);
	}
	//Function for matrix multiplication
	public static long[][] multiply(long a[][], long b[][]) {
		long res[][] = new long[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				res[i][j] = 0;
				for(int k=0; k<4; k++) {
					res[i][j] += a[i][k] * b[k][j];
					res[i][j] %= 1000000007;
				}
			}
		}
		return res;
	}
	//function for Matrix Exponentiation
	public static long[][] powerExpo(long arr[][], int pow) {
		if(pow == 1) return arr;
		long [][] temp = new long[4][4];
		temp = multiply(arr, arr);
		temp = powerExpo(temp, pow  >> 1);
		if((pow & 1) == 1) 
			temp =  multiply(temp, arr);
		return temp;
	}
}
