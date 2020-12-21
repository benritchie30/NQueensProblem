import java.util.Scanner;


public class NQueens{

private int[][] board;
private int n;
public NQueens(int n){
    board = new int[n + 1][n + 1];
    this.n = n + 1;
}
public void markOff(int x, int y){
    
    for (int j = y; j < n; j++){
        board[x][j]++;
    }
    int z = x <= y ? y : x;
    

    
    for (int k = 1; k < n - z; k++){
        board[x+k][y+k]++;
    }
   
    if (n - x > y){
        for (int k = 1; k < x; k++){
            board[x-k][y+k]++;
    }
    }
    else{
        for (int k = 1; k < n - y; k++){
            board[x-k][y+k]++;
        }
    }
}

public void unmark(int x, int y){

    for (int j = y; j < n; j++){
        board[x][j]--;
    }
    int z = x <= y ? y : x;
    

    
    for (int k = 1; k < n - z; k++){
        board[x+k][y+k]--;
    }

    
    if (n - x > y){
        for (int k = 1; k < x; k++){
            board[x-k][y+k]--;
    }
    }
    else{
        for (int k = 1; k < n - y; k++){
            board[x-k][y+k]--;
        }
    }
}


public int place(int x, int y){
    if (x == n){
        return 0;
    }
    if (y == n){
        return 1;   
    }
    int count = 0;
    for (int i = 1; i < n; i++){
        if (check(i,y)){
            markOff(i,y);
            count += place(1,y+1);
            unmark(i,y);
        
        }
    }
    return count;


}
    
    


public Boolean check(int x, int y){
    if (board[x][y] == 0){
        return true;
    }
    return false;
}

public void print(){
    for (int x = 1; x < n; x++){
        for (int y = 1; y < n; y++){
           System.out.print(board[y][x] + " ");
        }
        System.out.println();
    }
    System.out.println();
}

public static void main(String [] args) {
 
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of queens: ");
    int n = sc.nextInt();
    NQueens nq = new NQueens(n);
    System.out.println("The number of valid arrangements is " + nq.place(1,1));
}
}

