package ood.schedular;

public class TestSchedular {

    public static void main(String[] args)
    {
        Schedular schedular = new Schedular();
        Task myTask = new MyTask("Test task");
        schedular.addTask(new Job(myTask, 100));
        schedular.addTask(new Job(myTask, 200));
        schedular.addTask(new Job(myTask,300));
        Runnable runnable = ()->{
            try {
                schedular.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread th1 = new Thread(runnable);
        th1.start();
    }
}
