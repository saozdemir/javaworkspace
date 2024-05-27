package com.sao.course.intro;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 26 May 2024
 * <p>
 * @description:
 */
public class ThreadIntro2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("Misbehaving thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });
        thread.start();

    }
}
