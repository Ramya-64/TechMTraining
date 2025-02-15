package week2Threads;

class MatrixMultiplier extends Thread {
    private int[][] A, B, C;
    private int row;

    public MatrixMultiplier(int[][] A, int[][] B, int[][] C, int row) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
    }

    public void run() {
        int colsB = B[0].length;
        int commonDim = A[0].length;

        for (int j = 0; j < colsB; j++) {
            for (int k = 0; k < commonDim; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class MatrixMultiplication_4 {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        int M = A.length, N = A[0].length, P = B[0].length;
        int[][] C = new int[M][P];

        Thread[] threads = new Thread[M];

        
        for (int i = 0; i < M; i++) {
            threads[i] = new MatrixMultiplier(A, B, C, i);
            threads[i].start();
        }

       
        for (int i = 0; i < M; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        System.out.println("Resultant Matrix:");
        for (int[] row : C) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

