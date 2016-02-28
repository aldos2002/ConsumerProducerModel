package com.epam;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Consumer(sharedResource, "consumer1"));
        executorService.execute(new Producer(sharedResource, "producer1"));
        executorService.execute(new Consumer(sharedResource, "consumer2"));
        executorService.execute(new Producer(sharedResource, "producer2"));
        executorService.execute(new Producer(sharedResource, "producer3"));
        executorService.execute(new Consumer(sharedResource, "consumer3"));
        executorService.shutdown();
    }
}
