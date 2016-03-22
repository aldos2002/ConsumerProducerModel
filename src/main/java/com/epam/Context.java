package com.epam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Almas_Doskozhin
 * on 3/22/2016.
 */
public class Context {
    private UserStrategy strategy;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Context() {
    }

    public void setStrategy(UserStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(){
        executorService.execute(strategy);
    }

    public void close(){
        executorService.shutdown();
    }
}
