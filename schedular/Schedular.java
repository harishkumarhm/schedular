package ood.schedular;

import java.util.Calendar;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Schedular implements ISchedular{
    PriorityBlockingQueue<Job> taskQueue;
    private boolean running = true;
private static final int CAPACITY = 10;
    public Schedular()
    {
        taskQueue = new PriorityBlockingQueue(CAPACITY, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.getScheduledTime().compareTo(j2.getScheduledTime());
            }
        });
    }


    @Override
    public void addTask(Job job) {

        synchronized (this)
        {
            taskQueue.add(job);
            notifyAll();
        }

    }

    @Override
    public synchronized void start() throws InterruptedException {
    while(running) {
        while (!isTimeForRun())
            wait(timeRemainingForNextTask());
        Job job = taskQueue.poll();
        job.run();

    }
    }

    @Override
    public void stop() {
        this.running = false;
    }

    private long timeRemainingForNextTask()
    {
        return taskQueue.peek().getScheduledTime().getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
    }
    private boolean isTimeForRun()
    {
        if(taskQueue.peek()!=null)
           return timeRemainingForNextTask() <=0?true: false;
        return false;
    }

}
