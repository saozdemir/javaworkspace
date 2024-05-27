package com.sao.course.coordination.termination;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 26 May 2024
 * <p>
 * @description:
 */
public class TerminationBlocking {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }
}
