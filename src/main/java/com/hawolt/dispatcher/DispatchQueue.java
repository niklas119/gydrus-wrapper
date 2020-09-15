package com.hawolt.dispatcher;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DispatchQueue {
    private static ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
    private static List<Runnable> list = new LinkedList<>();

    private DispatchQueue(){
        service.scheduleAtFixedRate(()->{
            if(!list.isEmpty()){
                list.remove(0).run();
            }
        },0,1750, TimeUnit.MILLISECONDS);
    }

    static {
        new DispatchQueue();
    }

    public static void submit(Runnable runnable) {
        list.add(runnable);
    }
}
