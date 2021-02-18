package ood.schedular;

public class MyTask  implements Task{
    String message;
    public MyTask(String message)
    {
        this.message = message;
    }

    @Override
    public void performTask() {
        System.out.println("Performing this task.." + message);
    }
}
