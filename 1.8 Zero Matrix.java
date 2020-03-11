public class Main
{
    
    public static void setZero(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for(int i = 0; i< matrix.length; i++)
        {
            for(int j =0; j< matrix[0].length; j++ ){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        // setting zero for rows
        for(int i=0; i<matrix.length; i++)
        {
            if(row[i]) nullifyRow(matrix,i);
        }
        //
        for(int j=0; j<matrix[0].length; j++)
        {
            if(column[j]) nullifyColumn(matrix,j);
        }
        for(int i = 0; i< matrix.length; i++)
        {
            for(int j =0; j< matrix[0].length; j++ ){
               System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void nullifyColumn(int[][] matrix,int j){
        for(int i=0; i<matrix.length; i++){
            matrix[i][j] = 0;
        }
    }
    public static void nullifyRow(int[][] matrix,int i){
        for(int j=0; j<matrix[0].length; j++){
            matrix[i][j] = 0;
        }
        
    }
	public static void main(String[] args) {
		int arr[][]= new int[][]{ {0,1,1,1},{1,1,1,1},{1,1,0,0},{1,1,1,1} };
		setZero(arr);
	}
}
