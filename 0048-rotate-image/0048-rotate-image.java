class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=i;j<c;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<r/2;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][r-1-j];
                matrix[i][r-1-j]=t;
            }
        }
    }
}