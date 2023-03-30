package Project_JAVA_DSA;

import com.kunal.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                matrix[i][j] = '|';
            }
        }
        System.out.println("Board is displayed here !!");
        System.out.println("|| Play your game here.");
        System.out.println("------------");
        System.out.println("");
        for(char[] mat : matrix){
            System.out.println(Arrays.toString(mat));
        }

        int var = 1;
        boolean flag = false;
        while(!flag){
            if(var %2 == 1){
                flag = player1(matrix);
            }
            else{
                flag = player2(matrix);
            }
            for(char[] mat : matrix){
                System.out.println(Arrays.toString(mat));
            }
           var++;
        }
    }

    private static boolean player1(char[][] matrix) {
        System.out.println("|| Turn for Player 1 (X)");
        return player1_val(matrix);
    }

    private static boolean player1_val(char[][] matrix) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (Character.compare(matrix[row][col],'|')==0) {
            matrix[row][col] = 'X';
        } else {
            System.out.println("You cannot Update value! Try Again");
            return player1_val(matrix);
        }

        return check(row,col,matrix);
    }
    private static boolean player2(char[][] matrix) {
        System.out.println("|| Turn for Player 2 (O)");
        return player2_val(matrix);
    }

    private static boolean player2_val(char[][] matrix) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (Character.compare(matrix[row][col],'|')==0) {
            matrix[row][col] = 'O';
        } else {
            System.out.println("You cannot Update value! Try Again");
            return player2_val(matrix);
        }
        return check(row,col,matrix);
    }
    public static boolean check(int row,int col,char[][] matrix) {
        // col-wise
        int i = 0;
        while (matrix[i][col] == 'X') {
            i++;
            if (i == matrix.length) {
                System.out.println("Player1 has won");
                return true;
            }
        }

        int j = 0;
        while (matrix[j][col] == 'O') {
            j++;
            if (j == matrix.length) {
                System.out.println("Player2 has won");
                return true;
            }
        }

        // row wise
        i=0;
        while (matrix[row][i] == 'X') {
            i++;
            if (i == matrix.length) {
                System.out.println("Player1 has won");
                return true;
            }
        }

        j=0;
        while (matrix[col][j] == 'O') {
            j++;
            if (j == matrix.length) {
                System.out.println("Player2 has won");
                return true;
            }
        }
        i=0;j=0;
        // diagonal
        while (matrix[i][j] == 'X') {
            if (i == matrix.length - 1 && j == matrix.length - 1) {
                System.out.println("Player1 has won");
                return true;
            }
            i++;
            j++;
        }
        i = 0;
        j = 0;
        while (matrix[i][j] == 'O') {
            if (i == matrix.length - 1 && j == matrix.length - 1) {
                System.out.println("Player2 has won");
                return true;
            }
            i++;
            j++;
        }

        // revert diagonal
        i = 0;
        j = matrix.length - 1;
        while (matrix[i][j] == 'X') {
            if (i == matrix.length - 1 && j == 0) {
                System.out.println("Player1 has won");
                return true;
            }
            i++;
            j--;
        }

        i = 0;
        j = matrix.length - 1;
        while (matrix[i][j] == 'O') {
            if (i == matrix.length - 1 && j == 0) {
                System.out.println("Player2 has won");
                return true;
            }
            i++;
            j--;
        }
        return false;
    }
}
