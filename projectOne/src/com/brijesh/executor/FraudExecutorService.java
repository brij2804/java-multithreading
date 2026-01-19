package com.brijesh.executor;

import com.brijesh.tasks.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FraudExecutorService {

    private ExecutorService executorService;

    public FraudExecutorService(){
        executorService = Executors.newFixedThreadPool(10);
    }

    public void execute() {
        executorService.submit(new Task());
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
