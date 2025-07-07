package ch12.exam.exam02;

public class MovieThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("동영상을 재생합니다.");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("동영상 재생을 종료합니다.");
        }
    }
}
