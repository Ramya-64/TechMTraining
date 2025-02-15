package week2Threads;

import java.util.concurrent.atomic.AtomicInteger;

class PrimeSumThread extends Thread {
    private int start, end;
    private AtomicInteger totalSum; 

    public PrimeSumThread(int start, int end, AtomicInteger totalSum) {
        this.start = start;
        this.end = end;
        this.totalSum = totalSum;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        int localSum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                localSum += i;
            }
        }
        totalSum.addAndGet(localSum); 
    }
}

public class PrimeNumbers_5 {
    public static void main(String[] args) {
        int limit = 100;  
        int numThreads = 4;  
        AtomicInteger totalSum = new AtomicInteger(0); 

        Thread[] threads = new Thread[numThreads];
        int range = limit / numThreads; 

        for (int i = 0; i < numThreads; i++) {
            int start = i * range + 1;
            int end = (i == numThreads - 1) ? limit : (start + range - 1);
            threads[i] = new PrimeSumThread(start, end, totalSum);
            threads[i].start(); 
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
