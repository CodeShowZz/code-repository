package com.javaconcurrencyinaction.cancellation_and_shutdown;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author junlin_huang
 * @create 2020-10-17 下午7:07
 **/

public class UEHLogger implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Thread terminated with exception: " + t.getName(), e);
    }
}