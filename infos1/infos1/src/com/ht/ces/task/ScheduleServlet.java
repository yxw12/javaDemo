package com.ht.ces.task;

import java.util.Date;

public class ScheduleServlet implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(new Date().getTime()+"任务扫描...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
