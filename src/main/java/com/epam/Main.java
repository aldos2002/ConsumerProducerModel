package com.epam;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    private static Context CONTEXT = new Context();

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        executeUserStrategy(new Consumer(sharedResource, "consumer1"));
        executeUserStrategy(new Consumer(sharedResource, "consumer1"));
        executeUserStrategy(new Producer(sharedResource, "producer1"));
        executeUserStrategy(new Consumer(sharedResource, "consumer2"));
        executeUserStrategy(new Producer(sharedResource, "producer2"));
        executeUserStrategy(new Producer(sharedResource, "producer3"));
        executeUserStrategy(new Consumer(sharedResource, "consumer3"));
        CONTEXT.close();
    }

    private static void executeUserStrategy(UserStrategy strategy) {
        CONTEXT.setStrategy(strategy);
        CONTEXT.executeStrategy();
    }
}
