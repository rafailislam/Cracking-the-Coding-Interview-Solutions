/*
// not in place solution

public class Main{
    public static int [][] rotation( int [][] arr, int n){
        int [][] narray = new int [n][n];
        int starti = 0, startj = n-1;
        for(int i = 0; i<n; i++){
            int ii = starti;
            int jj = startj;
            for ( int j=0;j<n;j++){
                narray[i+ii][j+jj] = arr[i][j];
                ii++;
                jj--;
            }
            starti--;
            startj--;
        }
        
        return narray;
    }

     public static void main(String []args){
         int n = 3;
        int [][] arr =  new int [n][n];
        int c = 1;
        for( int i=0;i<n;i++){
            for( int j=0; j<n; j++)
            {
                arr[i][j] = c++;
            }
        }
         for( int i=0;i<n;i++){
            for( int j=0; j<n; j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        arr = rotation(arr,n);
        for( int i=0;i<n;i++){
            for( int j=0; j<n; j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
     }
}
*/
public class Main
{
    public static boolean rotation(int [][] arr){
        if ( arr.length == 0 || arr.length != arr[0].length )
            return false;
        int n = arr.length;
        
        for (int layer = 0; layer<n/2; layer++)
        {
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i< last; i++){
                int offset = i-first;
                int temp = arr[first][i];
                
                arr[first][i] = arr[last-offset][first];
                arr[last-offset][first] = arr[last][last - offset];
                arr[last][last - offset] = arr[i][last];
                
                arr[i][last] = temp;
            }
        }
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }
	public static void main(String[] args) {
	    int n = 6;
	    int c=1;
	    int arr[][] = new int[n][n];
	    for(int i=0;i<n; i++){
            for(int j=0;j<n; j++){
                arr[i][j] = c++;
            }
        }
		System.out.println(rotation(arr) );
	}
}
