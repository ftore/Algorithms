package multithreading;

public class AlternatePrint {
    private static volatile int counter = 0;
    static class PrintA implements Runnable {
        public void run() {
            while(counter % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("A");
            notifyAll();
        }
    }

    static class PrintB implements Runnable {
        public void run() {
            while(counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("B");
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintA a = new PrintA();
        PrintB b = new PrintB();
        Thread aThread = new Thread(a);
        Thread bThread = new Thread(b);
        aThread.start();
        bThread.start();
    }
}
