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
