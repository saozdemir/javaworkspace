package com.sao.threads.dummy;

import java.util.Random;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadWork extends Thread implements Runnable {
    boolean isFinished = false;
    Exception exception;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread() + " calculated.");
            isFinished = true;
        } catch (InterruptedException e) {
            exception = e;
            isFinished = true;
        }

    }

    public boolean isFinished() {
        return isFinished;
    }

    public Exception getException() {
        return exception;
    }
}
