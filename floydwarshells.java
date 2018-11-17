package algo;

public class floydWarshells {
    public static int INF = 9999;
    void floydWarshellsAlgo(int[][] graph){
        int V = graph.length;
        int[][][] d = new int[V+1][][];
        d[0]=graph.clone();
        
        for(int k = 1 ; k <d.length ; k++){
            d[k] = new int[V][V];
            for(int i = 0; i < V ; i++){
                for(int j = 0; j < V ; j++){
                    if(i==j){
                        d[k][i][j] = 0;
                    }
                    else if( (i!=(k-1) || j!=(k-1)) && d[k-1][i][k-1]!=INF && d[k-1][k-1][j]!=INF && d[k-1][i][j] > d[k-1][i][k-1] + d[k-1][k-1][j]){
                                d[k][i][j] = d[k-1][i][k-1] + d[k-1][k-1][j];
                    }else{
                        d[k][i][j] = d[k-1][i][j];
                    }
                }
            }
        }
        System.out.println("The following matrix shows the shortest "+ 
                         "distances between every pair of vertices"); 
        for (int[][] d1 : d) {
            print2DMatrix(d1);
            System.out.println("----------------");
        }
    }
    void print2DMatrix(int[][] matrix){
        for(int i=0; i< matrix.length ; i++){
            for(int j=0; j<matrix[i].length;j++){
                if(matrix[i][j] == INF){
                    System.out.print("INF  ");
                }else{
                    System.out.print(matrix[i][j]+"    ");
                }
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{0,3,8,INF,-4},
                         {INF,0,INF,1,7},
                         {INF,4,0,INF,INF},
                         {2,INF,-5,0,INF},
                         {INF,INF,INF,6,0}};
        
        floydWarshells f = new floydWarshells();
        f.floydWarshellsAlgo(graph);
    }
}
