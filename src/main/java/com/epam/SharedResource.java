package com.epam;

import org.apache.log4j.Logger;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Almas_Doskozhin on
 * 2/22/2016.
 */
public class SharedResource {
    private static final Logger LOG = Logger.getLogger(SharedResource.class);

    private int resValue = 10;
    private Object resLock = new Object();

    public void consume(String threadName) {
        synchronized(resLock) {
            if (resValue > 5){
                resValue = resValue-1;
                LOG.info("Consumer "+threadName+" consumed: 1 unit; left "+resValue+"units");
            } else {
                LOG.info("Consumer "+threadName+" consumed: 0 unit; left "+resValue+"units");
            }
        }
    }

    public void produce(String threadName) {
        synchronized (resLock) {
            if (resValue < 10){
                resValue = resValue+1;
                LOG.info("Producer "+threadName+" produced: 1 unit; left "+resValue+"units");
            } else {
                LOG.info("Producer "+threadName+" produced: 0 unit; left "+resValue+"units");
            }
        }
    }
}
