package com.epam;

import org.apache.log4j.Logger;

/**
 * Created by Almas_Doskozhin
 * on 2/22/2016.
 */
public class Consumer implements UserStrategy {
    private SharedResource resource;
    private String name;

    public Consumer(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.consume(getName());
        }
    }

    public String getName(){
        return name;
    }
}
