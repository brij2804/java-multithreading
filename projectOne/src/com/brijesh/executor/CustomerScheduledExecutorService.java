package com.brijesh.executor;

import com.brijesh.tasks.FutureTask;

import java.util.concurrent.*;

public class CustomerScheduledExecutorService {

    private ScheduledExecutorService scheduledExecutorService;

    public CustomerScheduledExecutorService(){
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void executeOne() {
        Future<String> future = (Future<String>) scheduledExecutorService.schedule(()->{

            return "This is a scheduled task, see you in sometime";
        },1, TimeUnit.SECONDS);
        String result=  getResult(future);
        System.out.println("First future "+result);
    }
    public void executeTwo() {
        ScheduledFuture<?> scFuture = scheduledExecutorService.schedule(()->{

            return "I m from future, respect me or vanish";
        },1, TimeUnit.SECONDS);
        String result1 = getResult(scFuture);
        System.out.println("Second future "+result1);
    }

    public void shutdown(){
        scheduledExecutorService.shutdown();
    }
    
    public String getResult(Future<String> future){

        if (future.isDone() && !future.isCancelled()) {
            try {
               String str = future.get(10,TimeUnit.SECONDS);
                return str;
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
                return "";
            }
        }else{
            System.out.println("Future is not done yet");
            return "";
        }
    }
    public String getResult(ScheduledFuture<?> future){

        if (future.isDone() && !future.isCancelled()) {
            try {
               String str = (String) future.get();
                return str;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return "";
            }
        }else{
            System.out.println("Future is not done yet");
            return "";
        }
    }

}
