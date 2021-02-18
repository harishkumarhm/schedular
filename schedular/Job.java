package ood.schedular;

import java.util.Calendar;

public class Job {
    private long delay;
    private Task task;
    private Calendar scheduledTime;

    public Job(Task task,long delay)
    {
        this.delay = delay;
        this.task = task;
        this.scheduledTime = calculateScheduledTime(delay);
    }

    public void run() {
        task.performTask();
    }

    private Calendar calculateScheduledTime(long delay)
    {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(now.getTimeInMillis() +delay);
        return now;
    }
    public Calendar getScheduledTime()
    {
        return this.scheduledTime;
    }
}
