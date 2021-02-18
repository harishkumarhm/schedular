package ood.schedular;

public interface ISchedular {

     void addTask(Job job);
     void start() throws InterruptedException;
     void stop();

}
