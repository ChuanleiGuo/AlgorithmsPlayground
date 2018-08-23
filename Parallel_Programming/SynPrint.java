public class SynPrint {
    public static class Monitor {
        public static final boolean ODD = true;
        public static final boolean EVEN = false;
        private boolean turn = ODD;

        public synchronized void waitTurn(boolean oldTurn) {
            while (turn != oldTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted in wait: " + e);
                }
            }
        }

        public synchronized void toggleTurn() {
            turn ^= true;
            notify();
        }
    }

    public static class OddThread extends Thread {
        private final Monitor monitor;

        public OddThread(Monitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                monitor.waitTurn(Monitor.ODD);
                System.out.println("i = " + i);
                monitor.toggleTurn();
            }
        }
    }

    public static class EvenThread extends Thread {
        private final Monitor monitor;

        public EvenThread(Monitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                monitor.waitTurn(Monitor.EVEN);
                System.out.println("i = " + i);
                monitor.toggleTurn();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        Thread t1 = new OddThread(monitor);
        Thread t2 = new EvenThread(monitor);

        t1.start();;
        t2.start();

        t1.join();
        t2.join();
    }
} 