import com.brijesh.executor.CustomerScheduledExecutorService;
import com.brijesh.executor.FraudExecutorService;
import com.brijesh.executor.Invoker;
import com.brijesh.tasks.Task;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    // 1. first way
    //firstwayrunning();


    //2. second way of running
    //secondwayarunning();

    // 3. third way of running
   // thirdwayrunning();

    // 4. fourth way of running
    //fourthwayrunning();

    //5. fifth way of running
    fifthwayrunning();

}

public void firstwayrunning(){
       Executor executor = new Invoker();
  executor.execute(() -> {
        System.out.println(" Invoker execute function");
    });
}

public void secondwayarunning(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    System.out.println("Executor service created");
    executorService.submit(()->{
        System.out.println("Executor service submitted");
        Task t= new Task();
        t.run();
        System.out.println("Task completed");
    });
    System.out.println("Shutting down ExecutorService");
    executorService.shutdown();
}

public void thirdwayrunning(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    System.out.println("Executor service created");
    executorService.submit(()->{
        System.out.println("Executor service submitted");
        Task t= new Task();
        t.run();
        System.out.println("Task completed");
    });
    System.out.println("Terminating down ExecutorService");
    try {
        executorService.awaitTermination( 20l, TimeUnit.NANOSECONDS );
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public void fourthwayrunning(){
    FraudExecutorService fraudExecutorService = new FraudExecutorService();
    fraudExecutorService.execute();
    fraudExecutorService.shutdown();
   }

public void fifthwayrunning(){
    CustomerScheduledExecutorService scService = new CustomerScheduledExecutorService();
    scService.executeOne();
    scService.executeTwo();
    scService.shutdown();
}
