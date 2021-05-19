/**
 * @author Isen
 * @date 2021/3/13 10:12
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new MyThread("Printer1", 100, 1)).start();
        new Thread(new MyThread("Printer2", 100, 0)).start();
    }

    private static int state = 1;

    private static class MyThread implements Runnable{
        private String name;
        private int count;
        private int no;

        private MyThread (String name, int count, int no) {
            this.name = name;
            this.count = count;
            this.no = no;
        }

        @Override
        public void run() {
            while(state <= count) {
                synchronized (MyThread.class) {
                    if ((state & 1) == no) {
                        System.out.println(name + "-" + state);
                        state++;
                        MyThread.class.notifyAll();
                    } else {
                        try {
                            MyThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
