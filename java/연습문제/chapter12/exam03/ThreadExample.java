package ch12.exam.exam03;

import ch12.exam.exam02.MovieThread;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.setDaemon(true);
        thread.start();

        try{Thread.sleep(3000);} catch (InterruptedException e){}
    }
}
